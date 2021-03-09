package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import gg.sora.dto.matchlistDTO;
import gg.sora.otherDTO.challlist;
public class RankerRateDAO {
	
	@Autowired
	private SqlSession ss;
	
	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
	
	
	public ArrayList<String> challlist() {
		ArrayList<String> topchall = new ArrayList<String>();
		
		
		try {
			
			String url = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5";
			url = url  + "?api_key=" + api;
			URL u = new URL(url);
			 HttpsURLConnection  huc = (HttpsURLConnection) u.openConnection();
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
	
	public void challsave(challlist c,HttpServletRequest request) {
		ArrayList<String> csnl = challlist(); // 챌린저 소환사 이름 리스트
		try {
			String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";

			for (int i = 0; i < 30; i++) {
				String sname = csnl.get(i);
				sname = URLEncoder.encode(sname, "utf-8");
				String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
				url = url + sname + "?api_key=" + api;
				URL u = new URL(url);
				HttpsURLConnection  huc = (HttpsURLConnection) u.openConnection();
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				JSONParser jp = new JSONParser();
				JSONObject loldata = (JSONObject) jp.parse(isr);
				c.setS_aid(String.valueOf(loldata.get("accountId")));
				c.setS_name(String.valueOf(loldata.get("name")));
				
				if(ss.getMapper(Mapper.class).challlistreg(c)==1) {
					request.setAttribute("regr", "등록성공");
				}
				else {
					request.setAttribute("regr", "등록실패");
					
				}
					
			}

		
				
				
			
		} catch (Exception e) {
			e.printStackTrace();
			//
		}

	}
	
	
	public void getchallmatchlist(challlist c, HttpServletRequest req) {
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
			ArrayList<matchlistDTO> matchlist = new ArrayList<matchlistDTO>();
for (int j = 0; j < 3; j++) {
				
				matchlistDTO dto = new matchlistDTO();
				JSONObject jj = (JSONObject) jjs.get(i);
				 jj.get("gameId"); // DTO 만들어서 이거 넣고 DB에 등록
}
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		

	}


		}
	
	
	
}
