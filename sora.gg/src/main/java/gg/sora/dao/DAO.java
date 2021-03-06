package gg.sora.dao;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.sora.dto.Banlist;
import gg.sora.dto.InGame;
import gg.sora.dto.gid;
import gg.sora.dto.matchdetailDTO;
import gg.sora.dto.matchlistDTO;


public class DAO {
	
	@Autowired
	private RunAndSpell RunAndSpell;
	@Autowired
	private QueAndPo QueAndPo;
	@Autowired
	private champ champ;
	

	 static String aid = null;
	 String sid = null;
	 String pid = null;
	static String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
	static HttpsURLConnection huc = null;
	HttpURLConnection huc2 = null;

	public void apiver(HttpServletRequest request) {
		String url = "https://ddragon.leagueoflegends.com/api/versions.json";
		try {
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			JSONParser jp = new JSONParser();
			JSONArray loldata = (JSONArray) jp.parse(isr);

			request.setAttribute("curVer", loldata.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sumsearch(HttpServletRequest request) {

		try {
			apiver(request);
			String sname = request.getParameter("sname");
			sname = URLEncoder.encode(sname, "utf-8");
			String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
			url = url + sname + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			int resCode = huc.getResponseCode();
			if (resCode == 200) {
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			aid = String.valueOf(loldata.get("accountId"));
			sid = String.valueOf(loldata.get("id"));
			request.setAttribute("sid", sid);
			request.setAttribute("sname", loldata.get("name"));
			request.setAttribute("sicon", loldata.get("profileIconId"));
			request.setAttribute("slv", loldata.get("summonerLevel"));
			}
			else {
				request.setAttribute("nodata", 2);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static ArrayList<gid> gameId() {

		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";

			url = url + aid + "?api_key=" + api;

			URL u = new URL(url);

			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject lolData = (JSONObject) jp.parse(isr);

			JSONArray matches = (JSONArray) lolData.get("matches");
			System.out.println(matches);

			JSONObject gameId2 = null;

			ArrayList<gid> gids = new ArrayList<gid>();
			

			for (int i = 0; i < 20; i++) {
				gameId2 = (JSONObject) matches.get(i);
				String id3 = String.valueOf(gameId2.get("gameId"));
//				System.out.println(id3);
				gids.add(new gid(id3));
			}

//			for (gid gid : gids) {
//				System.out.println(gid.getGid());
//			}

			return gids;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void winningRate(HttpServletRequest request) {
		
		String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
		String url2 = null;
		try {

		ArrayList<gid> gids = gameId();
		int wins = 0;
		int loses = 0;
		for (gid gid : gids) {

				url2 = url+ gid.getGid() + "?api_key=" + api;
				
				URL u = new URL(url2);
				
				huc = (HttpsURLConnection) u.openConnection();

				InputStream is = huc.getInputStream();

				InputStreamReader isr = new InputStreamReader(is, "utf-8");

				JSONParser jp = new JSONParser();

				JSONObject lolData = (JSONObject) jp.parse(isr);

				JSONArray participantIdentities = (JSONArray) lolData.get("participantIdentities");

				for (int i = 0; i < participantIdentities.size(); i++) {
					JSONObject j = (JSONObject) participantIdentities.get(i);
					JSONObject j2 = (JSONObject) j.get("player");
					if (j2.get("currentAccountId").equals(aid)) {
						// System.out.println(j.get("participantId"));
						pid = String.valueOf(j.get("participantId"));
					}

				}

				JSONArray participants = (JSONArray) lolData.get("participants");
				
				for (int i = 0; i < participants.size(); i++) {
					JSONObject j = (JSONObject) participants.get(i);
					JSONObject j2 = (JSONObject) j.get("stats");
					String participantId = String.valueOf(j.get("participantId"));
					if (participantId.equals(pid)) {
						String win = String.valueOf(j2.get("win"));
						if(win.equals("true")){
							wins+=1; 
							System.out.println(wins);
							}
						else if(win.equals("false")){
							loses+=1;
							}
					}
					
				}
				url2 = "";
//				return kdas;
		}
		
		Double winRate = (((double) wins/20.0)*100); 

		request.setAttribute("win", wins);
		request.setAttribute("lose", loses);
		request.setAttribute("winRate", String.format("%.0f", winRate));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void matchl(HttpServletRequest request) {
		apiver(request);
		try {
			System.out.println(sid);
			String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
			url = url + aid + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONArray jjs = (JSONArray) loldata.get("matches");
			// JSONObject matches = (JSONObject) jjs.get(0);

			ArrayList<matchlistDTO> matchlist = new ArrayList<matchlistDTO>();
			String queue = null;

			for (int i = 0; i < 10; i++) {

				matchlistDTO dto = new matchlistDTO();
				JSONObject jj = (JSONObject) jjs.get(i);
				System.out.println("게임번호 " + jj.get("gameId"));
				dto.setGameId(Long.valueOf(jj.get("gameId").toString()));
				System.out.println("게임 타입 " + QueAndPo.queue(Integer.parseInt(jj.get("queue").toString())));
				queue = QueAndPo.queue(Integer.parseInt(jj.get("queue").toString()));
				dto.setQueue(queue);
				// System.out.println("사용한 챔피언 " + jj.get("champion"));
				// int champkey = Integer.parseInt(jj.get("champion").toString());
				System.out.println("사용한 챔피언 " + champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
				Date timestamp = new Date((Long) jj.get("timestamp"));
				SimpleDateFormat sdf = new SimpleDateFormat("M월 dd일 HH시 mm분 ", Locale.KOREA);
				dto.setTimestamp(sdf.format(timestamp));
				dto.setChampionKr(champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
				dto.setChampionEn(champ.champnameEn(Integer.parseInt(jj.get("champion").toString())));
				dto.setPosition(QueAndPo.position(jj.get("lane"), jj.get("role")));
				// System.out.println("타임스탬프 " + jj.get("timestamp"));
				System.out.println("=====================");
				matchlist.add(dto);
			}
			request.setAttribute("mls", matchlist);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("출력오류ㅠ");
		}

	}
	public void matchlsearch(HttpServletRequest request) {
		apiver(request);
		String queuetype = request.getParameter("queue");
		try {
			System.out.println(sid);
			String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
			url = url + aid +"?queue=" +queuetype + "&api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONArray jjs = (JSONArray) loldata.get("matches");
			// JSONObject matches = (JSONObject) jjs.get(0);
			
			ArrayList<matchlistDTO> matchlist = new ArrayList<matchlistDTO>();
			String queue = null;
			
			for (int i = 0; i < 10; i++) {
				
				matchlistDTO dto = new matchlistDTO();
				JSONObject jj = (JSONObject) jjs.get(i);
				System.out.println("게임번호 " + jj.get("gameId"));
				dto.setGameId(Long.valueOf(jj.get("gameId").toString()));
				System.out.println("게임 타입 " + QueAndPo.queue(Integer.parseInt(jj.get("queue").toString())));
				queue = QueAndPo.queue(Integer.parseInt(jj.get("queue").toString()));
				dto.setQueue(queue);
				// System.out.println("사용한 챔피언 " + jj.get("champion"));
				// int champkey = Integer.parseInt(jj.get("champion").toString());
				System.out.println("사용한 챔피언 " + champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
				Date timestamp = new Date((Long) jj.get("timestamp"));
				SimpleDateFormat sdf = new SimpleDateFormat("M월 dd일 HH시 mm분 ", Locale.KOREA);
				dto.setTimestamp(sdf.format(timestamp));
				dto.setChampionKr(champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
				dto.setChampionEn(champ.champnameEn(Integer.parseInt(jj.get("champion").toString())));
				dto.setPosition(QueAndPo.position(jj.get("lane"), jj.get("role")));
				// System.out.println("타임스탬프 " + jj.get("timestamp"));
				System.out.println("=====================");
				matchlist.add(dto);
			}
			request.setAttribute("mls", matchlist);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("출력오류ㅠ");
		}
		
	}

	// 스펠/룬 추가하기 (초상화 옆)
	public void gamedata(HttpServletRequest request) {
		int ptkills = 0, btkills = 0;

		apiver(request);
		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
			String mid = request.getParameter("mid");
			url = url + mid + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			System.out.println("게임타입 : " + QueAndPo.queue(Integer.parseInt(loldata.get("queueId").toString())));
			request.setAttribute("queueType", QueAndPo.queue(Integer.parseInt(loldata.get("queueId").toString())));
			
			JSONArray teams = (JSONArray) loldata.get("teams");
			JSONObject blueteaminfo = (JSONObject) teams.get(0); // 블루팀 데이터
			JSONObject purpleteaminfo = (JSONObject) teams.get(1); // 레드팀 데이터
			ArrayList<matchdetailDTO> mde = new ArrayList<matchdetailDTO>();
			int sec = Integer.parseInt(loldata.get("gameDuration").toString());
			int min = sec / 60;
			sec = sec % 60;
			if (min < 5) {
				System.out.println("분 " + min);
				request.setAttribute("restartgame", "다시하기");
			}

			request.setAttribute("min", min);
			request.setAttribute("sec", sec);
			
			ArrayList<Banlist> bbls = new ArrayList<Banlist>();
			ArrayList<Banlist> pbls = new ArrayList<Banlist>();
			 //랭크 일때만 밴 목록 출력
			if (Integer.parseInt(loldata.get("queueId").toString()) == 420 || Integer.parseInt(loldata.get("queueId").toString()) == 440) {
				JSONArray bluebans = (JSONArray) blueteaminfo.get("bans");
				JSONArray purplebans = (JSONArray) purpleteaminfo.get("bans");
				System.out.println("블루팀 밴 : ");
				for (int i = 0; i < bluebans.size(); i++) {
					Banlist bluebanlist = new Banlist();
					JSONObject blueban = (JSONObject) bluebans.get(i);
					bluebanlist.setBannedChampion(champ.champnameEn(Integer.parseInt(blueban.get("championId").toString())));
					System.out.println(champ.champnameKr(Integer.parseInt(blueban.get("championId").toString())));
					bbls.add(bluebanlist);
				}
				System.out.println("퍼플팀 밴 : ");
				for (int i = 0; i < purplebans.size(); i++) {
					Banlist purplebanlist = new Banlist();
					JSONObject purpleban = (JSONObject) purplebans.get(i);
					purplebanlist.setBannedChampion(champ.champnameEn(Integer.parseInt(purpleban.get("championId").toString())));
					System.out.println(champ.champnameKr(Integer.parseInt(purpleban.get("championId").toString())));
					pbls.add(purplebanlist);
				}
				request.setAttribute("bbls", bbls);
				request.setAttribute("pbls", pbls);

			}

			System.out.println("=====================");
			JSONArray participantIdentities = (JSONArray) loldata.get("participantIdentities");
			JSONArray participants = (JSONArray) loldata.get("participants"); // 구성원 데이터

			for (int i = 0; i < participantIdentities.size(); i++) { // 킬관여율 계산 위한 
				JSONObject participant = (JSONObject) participants.get(i);
				JSONObject stats = (JSONObject) participant.get("stats");
				if (Integer.parseInt(participant.get("teamId").toString()) == 100) {
					btkills += Integer.parseInt(stats.get("kills").toString());
				}
				if (Integer.parseInt(participant.get("teamId").toString()) == 200) {
					ptkills += Integer.parseInt(stats.get("kills").toString());
				}

			}

			for (int i = 0; i < participantIdentities.size(); i++) {
				matchdetailDTO dto = new matchdetailDTO();
				JSONObject participant1 = (JSONObject) participants.get(i); // 인게임 정보
				JSONObject stats = (JSONObject) participant1.get("stats");
				JSONObject participant2 = (JSONObject) participantIdentities.get(i); // 인게임 외적 정보
				JSONObject player = (JSONObject) participant2.get("player");
				JSONObject timeline = (JSONObject) participant1.get("timeline");
				// int pId = Integer.parseInt(participant2.get("participantId").toString());

				if ((Boolean) stats.get("win")) {
					dto.setWin("승리");
				} else {
					dto.setWin("패배");
				}
			
				
				dto.setSummonerName(String.valueOf(player.get("summonerName")));
				dto.setChampionEn(champ.champnameEn(Integer.parseInt(participant1.get("championId").toString())));
				dto.setChampionKr(champ.champnameKr(Integer.parseInt(participant1.get("championId").toString())));

				dto.setPosition(QueAndPo.position(timeline.get("lane"), timeline.get("role")));

				dto.setKills(Integer.parseInt(stats.get("kills").toString()));
				dto.setDeaths(Integer.parseInt(stats.get("deaths").toString()));
				dto.setAssists(Integer.parseInt(stats.get("assists").toString()));

				
				if (Integer.parseInt(stats.get("deaths").toString()) == 0) {
					dto.setKda("Perfect");
				}

				else if (Integer.parseInt(stats.get("deaths").toString()) >= 1) {
					String kda = String.format("%.2f",
							(Double.parseDouble(stats.get("kills").toString())
									+ Integer.parseInt(stats.get("assists").toString()))
									/ Integer.parseInt(stats.get("deaths").toString()));
					dto.setKda(kda);
				}

				
				if (Integer.parseInt(participant1.get("teamId").toString()) == 100) {
					String killper =
							String.format("%.2f", (Double.parseDouble(stats.get("kills").toString())+ Integer.parseInt(stats.get("assists").toString()))/btkills*100);
			dto.setKillper(killper +"%");
				}
				if (Integer.parseInt(participant1.get("teamId").toString()) == 200) {
				String killper =
						String.format("%.2f", (Double.parseDouble(stats.get("kills").toString())+ Integer.parseInt(stats.get("assists").toString()))/ptkills*100);
				dto.setKillper(killper +"%");
				}
				
				if(Integer.parseInt(stats.get("doubleKills").toString())>0) {
					dto.setDoubleKills("더블킬!");
				}
				if(Integer.parseInt(stats.get("tripleKills").toString())>0) {
					dto.setDoubleKills("트리플킬!");
				}
				if(Integer.parseInt(stats.get("quadraKills").toString())>0) {
					dto.setDoubleKills("쿼드라킬!");
				}
				if(Integer.parseInt(stats.get("pentaKills").toString())>0) {
					dto.setDoubleKills("펜타킬!");
				}
				if(stats.get("firstBloodKill").equals("ture")) {
					dto.setDoubleKills("선취점!");
				}
				if(stats.get("firstTowerKill").equals("ture")) {
					dto.setDoubleKills("첫 포탑 철거!");
				}
				
				dto.setChampLevel(stats.get("champLevel"));
				dto.setWardsPlaced(stats.get("wardsPlaced"));
				dto.setWardsKilled(stats.get("wardsKilled"));
				dto.setVisionWardsBoughtInGame(stats.get("visionWardsBoughtInGame"));
				dto.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions"));
				dto.setVisionScore(stats.get("visionScore"));
				
				dto.setItem0(stats.get("item0"));
				dto.setItem1(stats.get("item1"));
				dto.setItem2(stats.get("item2"));
				dto.setItem3(stats.get("item3"));
				dto.setItem4(stats.get("item4"));
				dto.setItem5(stats.get("item5"));
				dto.setItem6(stats.get("item6"));
				dto.setPerkSubStyle(RunAndSpell.perks(Integer.parseInt(stats.get("perkSubStyle").toString())));
				dto.setKeyperks(RunAndSpell.perks(Integer.parseInt(stats.get("perk0").toString())));
				dto.setSpell1Id(RunAndSpell.spell(Integer.parseInt(participant1.get("spell1Id").toString())));
				dto.setSpell2Id(RunAndSpell.spell(Integer.parseInt(participant1.get("spell2Id").toString())));
				// if ((boolean) stats.get("firstBloodKill")) {
				// dto.setPb("선취점!");
				// }
				System.out.println("=====================");
				mde.add(dto);

			}
			request.setAttribute("md", mde);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void ingame(HttpServletRequest request) {
		apiver(request);
		try {
			String url = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/";
			
			String url2 = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/";
			
			String url3 = null;
			
			url = url + sid + "?api_key=" + api;

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject ingameData = (JSONObject) jp.parse(isr);

JSONArray participants =  (JSONArray) ingameData.get("participants");
			
			String queue = QueAndPo.queue(Integer.parseInt(ingameData.get("gameQueueConfigId")+""));
			
			request.setAttribute("queue",queue);
			
			long currentTime = System.currentTimeMillis();
			
			long gameStartTime = Long.parseLong(ingameData.get("gameStartTime").toString());
			
			long time = currentTime - gameStartTime;
			
			Date timestamp = new Date(time);
			SimpleDateFormat sdf = new SimpleDateFormat("mm분 ss초 전 ", Locale.KOREA);
			
			request.setAttribute("time", sdf.format(timestamp));
			
			Date timestamp2 = new Date(gameStartTime);
			SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY년 M월 dd일 오후 hh시 mm분 ", Locale.KOREA);
			
			
			ArrayList<InGame> ingames = new ArrayList<InGame>();
			
			
			for (int i = 0; i < participants.size(); i++) {
					InGame ingame = new InGame();
					JSONObject j = (JSONObject) participants.get(i);
					
					sid = String.valueOf(j.get("summonerId"));
					url3 = url2 + sid + "?api_key=" +api;
					URL u2 = new URL(url3);
					huc2 = (HttpsURLConnection) u2.openConnection();
					InputStream is2 = huc2.getInputStream();
					InputStreamReader isr2 = new InputStreamReader(is2, "utf-8");
					JSONParser jp2 = new JSONParser();
					JSONArray tierData = (JSONArray) jp2.parse(isr2);
					
					for (int t = 0; t < tierData.size(); t++) {
					JSONObject tier = (JSONObject) tierData.get(t);
					if(tier.get("queueType").equals("RANKED_SOLO_5x5")) {
						ingame.setTier(tier.get("tier")+"");
						ingame.setRank(tier.get("rank")+"");
				}}
					
					ingame.setTeam(j.get("teamId")+"");
					ingame.setChampEn(champ.champnameEn(Integer.parseInt(j.get("championId")+"")));
					ingame.setChampKr(champ.champnameKr(Integer.parseInt(j.get("championId")+"")));
					ingame.setSpell1(RunAndSpell.spell(Integer.parseInt(j.get("spell1Id")+"")));
					ingame.setSpell1Kr(RunAndSpell.spellKr(Integer.parseInt(j.get("spell1Id")+"")));
					ingame.setSpell2(RunAndSpell.spell(Integer.parseInt(j.get("spell2Id")+"")));
					ingame.setSpell2Kr(RunAndSpell.spellKr(Integer.parseInt(j.get("spell2Id")+"")));
					JSONObject p = (JSONObject) j.get("perks");
					JSONArray p1 = (JSONArray) p.get("perkIds");
					ingame.setPerks1(RunAndSpell.perks(Integer.parseInt(p1.get(0)+"")));
					ingame.setPerks1Kr(RunAndSpell.perksKr(Integer.parseInt(p1.get(0)+"")));
					ingame.setPerks2(RunAndSpell.perks(Integer.parseInt(p.get("perkSubStyle")+"")));
					ingame.setPerks2Kr(RunAndSpell.perksKr(Integer.parseInt(p.get("perkSubStyle")+"")));
					ingame.setName(j.get("summonerName")+"");
					
					
					if(queue.equals("솔로랭크")||queue.equals("자유랭크")) {
						JSONArray bannedChampions =  (JSONArray) ingameData.get("bannedChampions");
						JSONObject j2 = (JSONObject) bannedChampions.get(i);
						ingame.setBan(champ.champnameEn(Integer.parseInt(j2.get("championId")+"")));
						ingame.setBanKr(champ.champnameKr(Integer.parseInt(j2.get("championId")+"")));
					
			}
					ingames.add(ingame);
					}
			
			
			request.setAttribute("ingame","게임중!");
			request.setAttribute("ingames", ingames);
			
		} catch (Exception e) {
			request.setAttribute("ingame","현재 게임중이 아닙니다.");
		}
		
		
	}

	public void ingamenow(HttpServletRequest request) {

		try {
			String url = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/";
			url = url + sid + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			int resCode = huc.getResponseCode();
			if (resCode == 200) {
			//InputStream is = huc.getInputStream();
		//	InputStreamReader isr = new InputStreamReader(is, "utf-8");

			//JSONParser jp = new JSONParser();
			//JSONObject loldata = (JSONObject) jp.parse(isr);
			request.setAttribute("nowgame", "1");
			}
			else
			{request.setAttribute("nowgame", "2");}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
