package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import gg.sora.dto.Passive;
import gg.sora.dto.champName;
import gg.sora.dto.champSkillInfo;
import gg.sora.dto.tip;

public class championDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private champ chp;
	HttpsURLConnection huc = null;
	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";

	public ArrayList<champName> allChampion(HttpServletRequest req) {

		try {

			HttpURLConnection huc = null;

			String url = "http://ddragon.leagueoflegends.com/cdn/11.4.1/data/ko_KR/championFull.json";

			URL u = new URL(url);

			huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject championFull = (JSONObject) jp.parse(isr);
//			System.out.println(championFull);	// 전체 정보 (너무 커서 안 돌아가니까 실행하지 마)

			JSONObject jo = (JSONObject) championFull.get("keys");
//			System.out.println(jo); // 챔피언 키 값과 밸류 값

			JSONObject searchChamp = (JSONObject) championFull.get("data");

			Iterator allChampionList = jo.entrySet().iterator();
			ArrayList<String> val = new ArrayList<String>();

			ArrayList<champName> champNames = new ArrayList<champName>();

			while (allChampionList.hasNext()) {
				Entry ee = (Entry) allChampionList.next();

//				key.add((String) ee.getKey()); // 키 값 받아오기
				val.add((String) ee.getValue()); // 밸류 값 받아오기
//				System.out.println(ee.getValue());

				JSONObject champName = (JSONObject) searchChamp.get(ee.getValue());

				String champId = (String) champName.get("id");
//				System.out.println(champId); // 챔피언 ID(영어이름)

				String champKey = (String) champName.get("key");
				Integer champKey2 = Integer.parseInt(champKey);
//				System.out.println(champKey2); // 챔피언 키 값 (고유번호)

				String championName = (String) champName.get("name");
//				System.out.println(championName); // 챔피언 이름(한글이름)

				champName cn = new champName();

				cn.setName(champId);
				cn.setNameKr(championName);
				cn.setNo(champKey2);

				champNames.add(cn);

			}

			req.setAttribute("val", champNames);
			return champNames;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void rotationChampion(HttpServletRequest req) {
		try {
			String url = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations/";
			url = url + "?api_key=" + api;

			URL u;
			u = new URL(url);

			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject rotation = (JSONObject) jp.parse(isr);

			JSONArray freeChampNum = (JSONArray) rotation.get("freeChampionIds");
//			System.out.println(freeChampNum.get(0));

			ArrayList<champName> champNames = new ArrayList<champName>();

			for (Object rotationChampNum : freeChampNum) {
				champName cn = new champName();

				int champIdNum = Integer.parseInt(rotationChampNum + "");
				cn.setNo(champIdNum);
				cn.setName(chp.champnameEn(champIdNum));
				cn.setNameKr(chp.champnameKr(champIdNum));

				champNames.add(cn);

//			String freeChampNum = (String) rotation.get("freeChampionIds");
//			
//			int freeChampNumber = Integer.parseInt(freeChampNum);
//			
//			ifSearchChampionName(freeChampNumber);
//			
			}
			req.setAttribute("rotation", champNames);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void championPassive(HttpServletRequest req) {

		try {
			String champName = req.getParameter("c_name");

			System.out.println(champName); // 챔피언 고유 넘버 -> 이름 변환 확인

			HttpURLConnection huc = null;

			String url = "http://ddragon.leagueoflegends.com/cdn/11.4.1/data/ko_KR/champion/" + champName + ".json";

//			System.out.println(url); // url 확인

			URL u;
			u = new URL(url);

			huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject championDetail = (JSONObject) jp.parse(isr);

//			System.out.println(championDetail); // 챔피언 정보 확인

			JSONObject championData = (JSONObject) championDetail.get("data");
			JSONObject searchChampion = (JSONObject) championData.get(champName);
//			System.out.println(ja1); // 특정 챔피언 관련 모든 정보

			String nameKr = (String) searchChampion.get("name");

			String name = (String) searchChampion.get("id");
//			System.out.println(name);

			JSONObject championPassive = (JSONObject) searchChampion.get("passive");
//			System.out.println(ja2); // 특정 챔피언 패시브 정보

			JSONObject passiveImage = (JSONObject) championPassive.get("image");
//			System.out.println(ja3); // 특정 챔피언 패시브 이미지 정보

			String passiveImageName = (String) passiveImage.get("full");
//			System.out.println(ja4); // 특정 챔피언 패시브 이미지 이름

			String passiveTitle = (String) championPassive.get("name");
// 			System.out.println(passiveTitle);

			String passiveDescription = (String) championPassive.get("description");
//			System.out.println(passiveDescription);

			Passive p = new Passive();

			p.setNameKr(nameKr);
			p.setName(name);
			p.setImgName(passiveImageName);
			p.setTitle(passiveTitle);
			p.setDescription(passiveDescription);

			req.setAttribute("passive", p);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void championskill(HttpServletRequest req) {
		try {

			String champName = req.getParameter("c_name");
//			System.out.println(champName);

			ArrayList<champSkillInfo> champSkillInfos = new ArrayList<champSkillInfo>();

			HttpURLConnection huc = null;
			String url = "http://ddragon.leagueoflegends.com/cdn/11.4.1/data/ko_KR/championFull.json";

			URL u;
			u = new URL(url);

			huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject championFull = (JSONObject) jp.parse(isr);

			JSONObject allChampDetailInfo = (JSONObject) championFull.get("data");
//			System.out.println(allChampDetailInfo); // 챔피언 전체 정보
			JSONObject championName = (JSONObject) allChampDetailInfo.get(champName);
//			System.out.println(championName); // 특정 챔피언에 대한 정보만

			JSONArray skills = (JSONArray) championName.get("spells");
//			System.out.println(skills); // 챔피언 스킬 불러오기
//			System.out.println(skills.get(0));

			for (Object championSkills : skills) {
				JSONObject skillInfo = (JSONObject) championSkills;

				String skillName = (String) skillInfo.get("name");
//				skillName = removeTag(skillName); // champSkillInfo에서 처리함
//				System.out.println(skillName);

				String skillTooltip = (String) skillInfo.get("tooltip");
//				skillTooltip = removeTag(skillTooltip); // champSkillInfo에서 처리함
//				System.out.println(skillTooltip);

				JSONObject skillImage = (JSONObject) skillInfo.get("image");
//				System.out.println(skillImage);

				String skillImg = (String) skillImage.get("full");
//				System.out.println(skillImg);

				champSkillInfo csi = new champSkillInfo();

				csi.setName(skillImg);
				csi.setSkillName(skillName);
				csi.setTooltip(skillTooltip);

				champSkillInfos.add(csi);

			}
			req.setAttribute("champSkillInfo", champSkillInfos);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void championSearch(HttpServletRequest req) {

		try {

			String championNameKr = req.getParameter("championName");
			ArrayList<champName> champNames = (ArrayList<champName>) translationSearch(championNameKr, req);

			req.setAttribute("val", champNames);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List translationSearch(String championNameKr, HttpServletRequest req) {

		ArrayList<champName> championNames = new ArrayList<champName>();

		for (champName champName : allChampion(req)) {
			champName cn = new champName();

			if (champName.getNameKr().contains(championNameKr)) {
				// 챔피언 이름(한글)에 검색어(championNameKr)가 포함되면
				cn.setName(champName.getName());
				cn.setNameKr(champName.getNameKr());
				cn.setNo(champName.getNo());

				championNames.add(cn);
				// set 해주고 championNames에 add
			}

		}

		return championNames;
	}

	private String KrTranslationEn(String championNameKr) {
		// 쓰려다 만 메소드

		String champName = null;

		if (championNameKr.equals("아트록스")) {
			champName = "Aatrox";

		} else if (championNameKr.equals("쓰레쉬")) {
			champName = "Thresh";

		} else if (championNameKr.equals("트린다미어")) {
			champName = "Tryndamere";

		} else if (championNameKr.equals("그라가스")) {
			champName = "Gragas";

		} else if (championNameKr.equals("카시오페아")) {
			champName = "Cassiopeia";

		} else if (championNameKr.equals("아우렐리온 솔")) {
			champName = "AurelionSol";

		} else if (championNameKr.equals("라이즈")) {
			champName = "Ryze";

		} else if (championNameKr.equals("뽀삐")) {
			champName = "Poppy";

		} else if (championNameKr.equals("사이온")) {
			champName = "Sion";

		} else if (championNameKr.equals("애니")) {
			champName = "Annie";

		} else if (championNameKr.equals("진")) {
			champName = "Jhin";

		} else if (championNameKr.equals("카르마")) {
			champName = "Karma";

		} else if (championNameKr.equals("노틸러스")) {
			champName = "Nautilus";

		} else if (championNameKr.equals("클레드")) {
			champName = "Kled";

		} else if (championNameKr.equals("럭스")) {
			champName = "Lux";

		} else if (championNameKr.equals("아리")) {
			champName = "Ahri";

		} else if (championNameKr.equals("올라프")) {
			champName = "Olaf";

		} else if (championNameKr.equals("빅토르")) {
			champName = "Viktor";

		} else if (championNameKr.equals("애니비아")) {
			champName = "Anivia";

		} else if (championNameKr.equals("신지드")) {
			champName = "Singed";

		} else if (championNameKr.equals("가렌")) {
			champName = "Garen";

		} else if (championNameKr.equals("리산드라")) {
			champName = "Lissandra";

		} else if (championNameKr.equals("마오카이")) {
			champName = "Maokai";

		} else if (championNameKr.equals("모르가나")) {
			champName = "Morgana";

		} else if (championNameKr.equals("이블린")) {
			champName = "Evelynn";

		} else if (championNameKr.equals("피즈")) {
			champName = "Fizz";

		} else if (championNameKr.equals("하이머딩거")) {
			champName = "Heimerdinger";

		} else if (championNameKr.equals("제드")) {
			champName = "Zed";

		} else if (championNameKr.equals("럼블")) {
			champName = "Rumble";

		} else if (championNameKr.equals("모데카이저")) {
			champName = "Mordekaiser";

		} else if (championNameKr.equals("소나")) {
			champName = "Sona";

		} else if (championNameKr.equals("코그모")) {
			champName = "KogMaw";

		} else if (championNameKr.equals("카타리나")) {
			champName = "Katarina";

		} else if (championNameKr.equals("룰루")) {
			champName = "Lulu";

		} else if (championNameKr.equals("애쉬")) {
			champName = "Ashe";

		} else if (championNameKr.equals("카서스")) {
			champName = "Karthus";

		} else if (championNameKr.equals("알리스타")) {
			champName = "Alistar";

		} else if (championNameKr.equals("다리우스")) {
			champName = "Darius";

		} else if (championNameKr.equals("베인")) {
			champName = "Vayne";

		} else if (championNameKr.equals("바루스")) {
			champName = "Varus";

		} else if (championNameKr.equals("우디르")) {
			champName = "Udyr";

		} else if (championNameKr.equals("레오나")) {
			champName = "Leona";

		} else if (championNameKr.equals("제이스")) {
			champName = "Jayce";

		} else if (championNameKr.equals("신드라")) {
			champName = "Syndra";

		} else if (championNameKr.equals("판테온")) {
			champName = "Pantheon";

		} else if (championNameKr.equals("리븐")) {
			champName = "Riven";

		} else if (championNameKr.equals("카직스")) {
			champName = "Khazix";

		} else if (championNameKr.equals("코르키")) {
			champName = "Corki";

		} else if (championNameKr.equals("아지르")) {
			champName = "Azir";

		} else if (championNameKr.equals("케이틀린")) {
			champName = "Caitlyn";

		} else if (championNameKr.equals("니달리")) {
			champName = "Nidalee";

		} else if (championNameKr.equals("케넨")) {
			champName = "Kennen";

		} else if (championNameKr.equals("갈리오")) {
			champName = "Galio";

		} else if (championNameKr.equals("베이가")) {
			champName = "Veigar";

		} else if (championNameKr.equals("바드")) {
			champName = "Bard";

		} else if (championNameKr.equals("나르")) {
			champName = "Gnar";

		} else if (championNameKr.equals("말자하")) {
			champName = "Malzahar";

		} else if (championNameKr.equals("그레이브즈")) {
			champName = "Graves";

		} else if (championNameKr.equals("바이")) {
			champName = "Vi";

		} else if (championNameKr.equals("케일")) {
			champName = "Kayle";

		} else if (championNameKr.equals("이렐리아")) {
			champName = "Irelia";

		} else if (championNameKr.equals("리 신")) {
			champName = "LeeSin";

		} else if (championNameKr.equals("일라오이")) {
			champName = "Illaoi";

		} else if (championNameKr.equals("엘리스")) {
			champName = "Elise";

		} else if (championNameKr.equals("볼리베어")) {
			champName = "Volibear";

		} else if (championNameKr.equals("누누와 윌럼프")) {
			champName = "Nunu";

		} else if (championNameKr.equals("트위스티드 페이트")) {
			champName = "TwistedFate";

		} else if (championNameKr.equals("잭스")) {
			champName = "Jax";

		} else if (championNameKr.equals("쉬바나")) {
			champName = "Shyvana";

		} else if (championNameKr.equals("칼리스타")) {
			champName = "Kalista";

		} else if (championNameKr.equals("문도박사")) {
			champName = "DrMundo";

		} else if (championNameKr.equals("아이번")) {
			champName = "Ivern";

		} else if (championNameKr.equals("다이애나")) {
			champName = "Diana";

		} else if (championNameKr.equals("브랜드")) {
			champName = "Brand";

		} else if (championNameKr.equals("세주아니")) {
			champName = "Sejuani";

		} else if (championNameKr.equals("블라디미르")) {
			champName = "Vladimir";

		} else if (championNameKr.equals("자크")) {
			champName = "Zac";

		} else if (championNameKr.equals("렉사이")) {
			champName = "RekSai";

		} else if (championNameKr.equals("퀸")) {
			champName = "Quinn";

		} else if (championNameKr.equals("아칼리")) {
			champName = "Akali";

		} else if (championNameKr.equals("탈리야")) {
			champName = "Taliyah";

		} else if (championNameKr.equals("트리스타나")) {
			champName = "Tristana";

		} else if (championNameKr.equals("헤카림")) {
			champName = "Hecarim";

		} else if (championNameKr.equals("시비르")) {
			champName = "Sivir";

		} else if (championNameKr.equals("루시안")) {
			champName = "Lucian";

		} else if (championNameKr.equals("렝가")) {
			champName = "Rengar";

		} else if (championNameKr.equals("워윅")) {
			champName = "Warwick";

		} else if (championNameKr.equals("스카너")) {
			champName = "Skarner";

		} else if (championNameKr.equals("말파이트")) {
			champName = "Malphite";

		} else if (championNameKr.equals("야스오")) {
			champName = "Yasuo";

		} else if (championNameKr.equals("제라스")) {
			champName = "Xerath";

		} else if (championNameKr.equals("티모")) {
			champName = "Teemo";

		} else if (championNameKr.equals("나서스")) {
			champName = "Nasus";

		} else if (championNameKr.equals("레넥톤")) {
			champName = "Renekton";

		} else if (championNameKr.equals("드레이븐")) {
			champName = "Draven";

		} else if (championNameKr.equals("샤코")) {
			champName = "Shaco";

		} else if (championNameKr.equals("스웨인")) {
			champName = "Swain";

		} else if (championNameKr.equals("탈론")) {
			champName = "Talon";

		} else if (championNameKr.equals("잔나")) {
			champName = "Janna";

		} else if (championNameKr.equals("직스")) {
			champName = "Ziggs";

		} else if (championNameKr.equals("에코")) {
			champName = "Ekko";

		} else if (championNameKr.equals("오리아나")) {
			champName = "Orianna";

		} else if (championNameKr.equals("피오라")) {
			champName = "Fiora";

		} else if (championNameKr.equals("피들스틱")) {
			champName = "Fiddlesticks";

		} else if (championNameKr.equals("초가스")) {
			champName = "ChoGath";

		} else if (championNameKr.equals("람머스")) {
			champName = "Rammus";

		} else if (championNameKr.equals("르블랑")) {
			champName = "Leblanc";

		} else if (championNameKr.equals("소라카")) {
			champName = "Soraka";

		} else if (championNameKr.equals("질리언")) {
			champName = "Zilean";

		} else if (championNameKr.equals("녹턴")) {
			champName = "Nocturne";

		} else if (championNameKr.equals("징크스")) {
			champName = "Jinx";

		} else if (championNameKr.equals("요릭")) {
			champName = "Yorick";

		} else if (championNameKr.equals("우르곳")) {
			champName = "Urgot";

		} else if (championNameKr.equals("킨드레드")) {
			champName = "Kindred";

		} else if (championNameKr.equals("미스 포츈")) {
			champName = "MissFortune";

		} else if (championNameKr.equals("오공")) {
			champName = "MonkeyKing";

		} else if (championNameKr.equals("블리츠크랭크")) {
			champName = "Blitzcrank";

		} else if (championNameKr.equals("쉔")) {
			champName = "Shen";

		} else if (championNameKr.equals("브라움")) {
			champName = "Braum";

		} else if (championNameKr.equals("신 짜오")) {
			champName = "XinZhao";

		} else if (championNameKr.equals("트위치")) {
			champName = "Twitch";

		} else if (championNameKr.equals("마스터이")) {
			champName = "MasterYi";

		} else if (championNameKr.equals("타릭")) {
			champName = "Taric";

		} else if (championNameKr.equals("아무무")) {
			champName = "Amumu";

		} else if (championNameKr.equals("갱플랭크")) {
			champName = "Gangplank";

		} else if (championNameKr.equals("트런들")) {
			champName = "Trundle";

		} else if (championNameKr.equals("카사딘")) {
			champName = "Kassadin";

		} else if (championNameKr.equals("벨코즈")) {
			champName = "Velkoz";

		} else if (championNameKr.equals("자이라")) {
			champName = "Zyra";

		} else if (championNameKr.equals("나미")) {
			champName = "Nami";

		} else if (championNameKr.equals("자르반 4세")) {
			champName = "JarvanIV";

		} else if (championNameKr.equals("이즈리얼")) {
			champName = "Ezreal";

		} else if (championNameKr.equals("유미")) {
			champName = "Yuumi";

		} else if (championNameKr.equals("카이사")) {
			champName = "Kaisa";

		} else if (championNameKr.equals("니코")) {
			champName = "Neeko";

		} else if (championNameKr.equals("조이")) {
			champName = "Zoe";

		} else if (championNameKr.equals("자야")) {
			champName = "Xayah";

		} else if (championNameKr.equals("사일러스")) {
			champName = "Sylas";

		} else if (championNameKr.equals("케인")) {
			champName = "Kayn";

		} else if (championNameKr.equals("오른")) {
			champName = "Ornn";

		} else if (championNameKr.equals("파이크")) {
			champName = "Pyke";

		} else if (championNameKr.equals("카밀")) {
			champName = "Camille";

		} else if (championNameKr.equals("키아나")) {
			champName = "Qiyana";

		} else if (championNameKr.equals("라칸")) {
			champName = "Rakan";

		} else if (championNameKr.equals("요네")) {
			champName = "Yone";

		} else if (championNameKr.equals("릴리아")) {
			champName = "Lillia";

		} else if (championNameKr.equals("세나")) {
			champName = "Senna";

		} else if (championNameKr.equals("세트")) {
			champName = "Sett";

		} else if (championNameKr.equals("아펠리오스")) {
			champName = "Aphelios";

		} else if (championNameKr.equals("탐켄치")) {
			champName = "TahmKench";

		} else if (championNameKr.equals("세라핀")) {
			champName = "Seraphine";

		} else if (championNameKr.equals("사미라")) {
			champName = "Samira";

		} else if (championNameKr.equals("비에고")) {
			champName = "Viego";

		} else if (championNameKr.equals("렐")) {
			champName = "Rell";

		} else {
			champName = "오류";

		}
		return champName;

	}
	// 쓰려다가 만 메소드

	public void getAllTip(tip t, HttpServletRequest req) {

		List<tip> tips = ss.getMapper(TipMapper.class).getAllTip(t);

		req.setAttribute("tips", tips);

	}

	public void regTip(tip t, HttpServletRequest req) {

		ss.getMapper(TipMapper.class).regTip(t);

	}

	public void delTip(tip t, HttpServletRequest req) {

		ss.getMapper(TipMapper.class).delTip(t);

		}

}
