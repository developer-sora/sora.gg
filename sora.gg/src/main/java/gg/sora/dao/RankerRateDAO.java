package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import gg.sora.otherDTO.ChampionName;
import gg.sora.otherDTO.GameId;
import gg.sora.otherDTO.challchampban;
import gg.sora.otherDTO.challchampick;
import gg.sora.otherDTO.challlist;

public class RankerRateDAO {

	@Autowired
	private SqlSession ss;
	@Autowired
	private champ champ;

	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";

	private Connection getConnection() {
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			return DriverManager.getConnection(dburl, "test2", "test2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	Connection con = null;
	PreparedStatement pstmt = null;

	public void close(Connection con, PreparedStatement pstmt) {
		// 오류발생시 트라이캐치

		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<String> challlist() {
		ArrayList<String> topchall = new ArrayList<String>();

		try {

			String url = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5";
			url = url + "?api_key=" + api;
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONArray entries = (JSONArray) loldata.get("entries");
			System.out.println(entries);
			for (int i = 0; i < entries.size(); i++) {
				JSONObject entri = (JSONObject) entries.get(i);
				topchall.add(String.valueOf(entri.get("summonerName")));
			}

		} catch (Exception e) {
		}

		return topchall;
	}

	public void challsave(challlist c, HttpServletRequest request) {
		ArrayList<String> csnl = challlist(); // 챌린저 소환사 이름 리스트

		try {
			con = getConnection();
			pstmt = con.prepareStatement("TRUNCATE table toprankeruser");
			pstmt.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		try {
			// String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";

			for (int i = 0; i < 33; i++) {
				String sname = csnl.get(i);
				sname = URLEncoder.encode(sname, "utf-8");
				String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
				url = url + sname + "?api_key=" + api;
				URL u = new URL(url);
				HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				JSONParser jp = new JSONParser();
				JSONObject loldata = (JSONObject) jp.parse(isr);
				c.setS_aid(String.valueOf(loldata.get("accountId")));
				c.setS_name(String.valueOf(loldata.get("name")));

				if (ss.getMapper(Mapper.class).challlistreg(c) == 1) {
					request.setAttribute("regr", "등록성공");
				} else {
					request.setAttribute("regr", "등록실패");

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			//
		}

	}

	public void getchallmatchlist(challlist c, GameId g) {
		try {
			con = getConnection();

			pstmt = con.prepareStatement("TRUNCATE table toprankergame");
			pstmt.execute();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			close(con, pstmt);

		}

		ArrayList<challlist> challs = ss.getMapper(Mapper.class).getchall(c);
		for (int i = 0; i < challs.size(); i++) {
			String aid = challs.get(i).getS_aid();
			try {
				String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
				url = url + aid + "?queue=420&api_key=" + api;
				URL u = new URL(url);
				HttpURLConnection huc = (HttpsURLConnection) u.openConnection();
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				JSONParser jp = new JSONParser();
				JSONObject loldata = (JSONObject) jp.parse(isr);
				JSONArray jjs = (JSONArray) loldata.get("matches");
				for (int j = 0; j < 15; j++) {

					JSONObject jj = (JSONObject) jjs.get(i);
					g.setG_number(String.valueOf(jj.get("gameId"))); // DTO 만들어서 이거 넣고 DB에 등록
					if (ss.getMapper(Mapper.class).gameidreg(g) == 1) {
						System.out.println("게임넘버 저장 완료" + i);
					} else {

						System.out.println("게임넘버 저장 완료실패" + i);
						System.out.println("반복" + j);
					}

					System.out.println("반복" + j);

				}
			} catch (Exception e) {

			}

		}

	}

	public void champreg(challchampban cb ,challchampick cp, GameId g) {
		try {
			con = getConnection();
			pstmt = con.prepareStatement("TRUNCATE table champban");
			pstmt.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		try {
			con = getConnection();
			pstmt = con.prepareStatement("TRUNCATE table champpick");
			pstmt.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		ArrayList<GameId> gameIds = ss.getMapper(Mapper.class).getchallgameid(g);
		for (int i = 0; i < gameIds.size(); i++) {
			try {
				String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
				String mid = gameIds.get(i).getG_number();
				url = url + mid + "?api_key=" + api;
				URL u = new URL(url);
				HttpURLConnection huc = (HttpsURLConnection) u.openConnection();
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");

				JSONParser jp = new JSONParser();
				JSONObject loldata = (JSONObject) jp.parse(isr);
				JSONArray teams = (JSONArray) loldata.get("teams");
				JSONObject blueteaminfo = (JSONObject) teams.get(0); // 블루팀 데이터
				JSONObject purpleteaminfo = (JSONObject) teams.get(1); // 레드팀 데이터
				JSONArray bluebans = (JSONArray) blueteaminfo.get("bans");
				JSONArray purplebans = (JSONArray) purpleteaminfo.get("bans");
				for (int j = 0; j < 5; j++) {
					JSONObject blueban = (JSONObject) bluebans.get(j);
					JSONObject purpleban = (JSONObject) purplebans.get(j);
					cb.setBenchamp(Integer.parseInt(blueban.get("championId").toString()));
					cb.setBenchamp(Integer.parseInt(purpleban.get("championId").toString()));
					
		if (ss.getMapper(Mapper.class).banreg(cb) == 1) {
				System.out.println("챔프밴 등록 성공" +j);
				} else {
				System.out.println("챔프밴 등록 실패" +j);
			}
					
				}
				
				//JSONArray participantIdentities = (JSONArray) loldata.get("participantIdentities");
				JSONArray participants = (JSONArray) loldata.get("participants"); // 구성원 데이터
				for (int j = 0; j < 10; j++) {
					
					JSONObject participant = (JSONObject) participants.get(j); // 인게임 정보
				cp.setPickchamp(Integer.parseInt(participant.get("championId").toString()));
				
				if (ss.getMapper(Mapper.class).pickreg(cp)== 1) {
				System.out.println("챔프픽 등록 성공" +j);
				} else {
					System.out.println("챔프픽 등록 실패" +j);
				}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

		}

	}
	public void monthchampreg(challchampban cb ,challchampick cp, GameId g) {
		
		
		ArrayList<GameId> gameIds = ss.getMapper(Mapper.class).monthgetchallgameid(g);
		for (int i = 0; i < gameIds.size(); i++) {
			try {
				String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
				String mid = gameIds.get(i).getG_number();
				url = url + mid + "?api_key=" + api;
				URL u = new URL(url);
				HttpURLConnection huc = (HttpsURLConnection) u.openConnection();
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				
				JSONParser jp = new JSONParser();
				JSONObject loldata = (JSONObject) jp.parse(isr);
				JSONArray teams = (JSONArray) loldata.get("teams");
				JSONObject blueteaminfo = (JSONObject) teams.get(0); // 블루팀 데이터
				JSONObject purpleteaminfo = (JSONObject) teams.get(1); // 레드팀 데이터
				JSONArray bluebans = (JSONArray) blueteaminfo.get("bans");
				JSONArray purplebans = (JSONArray) purpleteaminfo.get("bans");
				for (int j = 0; j < 5; j++) {
					JSONObject blueban = (JSONObject) bluebans.get(j);
					JSONObject purpleban = (JSONObject) purplebans.get(j);
					cb.setBenchamp(Integer.parseInt(blueban.get("championId").toString()));
					cb.setBenchamp(Integer.parseInt(purpleban.get("championId").toString()));
					
					if (ss.getMapper(Mapper.class).monthbanreg(cb) == 1) {
						System.out.println("달챔프밴 등록 성공" +j);
					} else {
						System.out.println("달챔프밴 등록 실패" +j);
					}
					
				}
				
				//JSONArray participantIdentities = (JSONArray) loldata.get("participantIdentities");
				JSONArray participants = (JSONArray) loldata.get("participants"); // 구성원 데이터
				for (int j = 0; j < 10; j++) {
					
					JSONObject participant = (JSONObject) participants.get(j); // 인게임 정보
					cp.setPickchamp(Integer.parseInt(participant.get("championId").toString()));
					
					if (ss.getMapper(Mapper.class).monthpickreg(cp)== 1) {
						System.out.println("달챔프픽 등록 성공" +j);
					} else {
						System.out.println("달챔프픽 등록 실패" +j);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
		}
		
	}

	
	
public void banpicks(challchampban cb ,challchampick cp,HttpServletRequest req) {
ArrayList<challchampban> challbans = ss.getMapper(Mapper.class).getchallban(cb);
ArrayList<challchampick> challpicks =ss.getMapper(Mapper.class).getchallpick(cp);
ArrayList<ChampionName> bannames = new ArrayList<ChampionName>();
ArrayList<ChampionName> picknames = new ArrayList<ChampionName>();

for (int i = 0; i < 5; i++) {
	ChampionName cn1 = new ChampionName();
cn1.setChampionEn(champ.champnameEn(challbans.get(i).getBenchamp()));
cn1.setChampionKr(champ.champnameKr(challbans.get(i).getBenchamp()));	
	bannames.add(cn1);
}
for (int i = 0; i < 5; i++) {
	ChampionName cn2 = new ChampionName();
	cn2.setChampionEn(champ.champnameEn(challpicks.get(i).getPickchamp()));	
	cn2.setChampionKr(champ.champnameKr(challpicks.get(i).getPickchamp()));	
	picknames.add(cn2);
}


	req.setAttribute("cbl", bannames);
	req.setAttribute("cpl", picknames);
}




public void monthbanpicks(challchampban cb ,challchampick cp,HttpServletRequest req) {
	ArrayList<challchampban> mchallbans = ss.getMapper(Mapper.class).monthgetchallban(cb);
	ArrayList<challchampick> mchallpicks =ss.getMapper(Mapper.class).monthgetchallpick(cp);
	ArrayList<ChampionName> bannames = new ArrayList<ChampionName>();
	ArrayList<ChampionName> picknames = new ArrayList<ChampionName>();
	
	for (int i = 0; i < 5; i++) {
		ChampionName cn3 = new ChampionName();
		System.out.println("aa" + mchallbans.get(i).getBenchamp());
		cn3.setChampionEn(champ.champnameEn(mchallbans.get(i).getBenchamp()));
		cn3.setChampionKr(champ.champnameKr(mchallbans.get(i).getBenchamp()));	
		bannames.add(cn3);
	}
	for (int i = 0; i < 5; i++) {
		ChampionName cn4 = new ChampionName();
		System.out.println("bb" + mchallpicks.get(i).getPickchamp());
		cn4.setChampionEn(champ.champnameEn(mchallpicks.get(i).getPickchamp()));	
		cn4.setChampionKr(champ.champnameKr(mchallpicks.get(i).getPickchamp()));	
		picknames.add(cn4);
	}
	
	
	req.setAttribute("mcbl", bannames);
	req.setAttribute("mcpl", picknames);
}
}
