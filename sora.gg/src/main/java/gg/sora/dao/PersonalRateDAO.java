package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonalRateDAO {
//// 닉 받은 애 목록 보기에 게임 불러오기 - > 두개 써서 승 패 불러오기
//	@Autowired
//	private SqlSession ss;
//	
//	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
//public void matchdblist() {
//	String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
//	try {
//	url = url + aid + "?api_key=" + api;
//	URL u = new URL(url);
//HttpURLConnection	huc = (HttpsURLConnection) u.openConnection();
//	InputStream is = huc.getInputStream();
//	InputStreamReader isr = new InputStreamReader(is, "utf-8");
//
//	JSONParser jp = new JSONParser();
//	JSONObject loldata = (JSONObject) jp.parse(isr);
//	JSONArray jjs = (JSONArray) loldata.get("matches");
//
//
//	}
//	catch (Exception e) {
//		// TODO: handle exception
//	}
//	
//}

}
