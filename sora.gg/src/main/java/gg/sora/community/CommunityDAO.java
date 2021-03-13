package gg.sora.community;

<<<<<<< HEAD
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.sora.dto.CSearch;
import gg.sora.dto.userID;

@Service
public class CommunityDAO {
	private int allMsgCnt;
	
	@Autowired
	private SqlSession ss;
	
	public void write(CMsg m, HttpServletRequest req) {
		String token = req.getParameter("token");
		
		String st = (String) req.getSession().getAttribute("successToken");
		
		if(st != null && token.equals(st)) {
			System.out.println("새로고침");
			return;	// 새로고침 누른 이때. 하지말자고
		}
		
		String txt = m.getS_comment();
		txt = txt.replace("\r\n", "<br>");
		m.setS_comment(txt);
		
		userID u = (userID) req.getSession().getAttribute("loginUser");
		
		System.out.println(u.getU_email());
		
		m.setU_email(u.getU_email());
		
		if(ss.getMapper(BoardMapper.class).writeMsg(m)==1) {
			System.out.println("등록 성공");
			
		}else {
			System.out.println("등록 실패");
		}
		
		
		
		
	}

	public void getAllMsg(CMsg m, HttpServletRequest req) {
	List<CMsg> cMsgs = ss.getMapper(BoardMapper.class).getAllMsg(m);
		
			
			req.setAttribute("msgs", cMsgs);
		
	}

	public void del(CMsg m, HttpServletRequest req) {
		if(ss.getMapper(BoardMapper.class).delMsg(m)==1) {
			System.out.println("글 삭제 성공!");
		}else {
			System.out.println("글 삭제 실패");
		}
		
	}
	
	

	public void getMsg(CSearch cs, HttpServletRequest req) {
		
//		String search = (String) req.getSession().getAttribute("search");	// 검색어로 쓸꺼
//		String csearch = req.getParameter("csearch");
		System.out.println("search : " + cs.getCsearch());
//		if (search == null) {	// 전체조회 (검색어 없으면)
//			search = "";
//		} else {	// 검색어가 있으면 검색인거.
//		CSearch cs = new CSearch(search);
		List<CMsg> cMsgs = ss.getMapper(BoardMapper.class).getMsg(cs);
//		}
		req.setAttribute("msgs", cMsgs);
		
	}

	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		System.out.println(search);
		req.getSession().setAttribute("search", search);
		
	}
	
=======
import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.sora.dto.userID;
public class CommunityDAO {
	private int allMsgCnt;
	
	@Autowired
	private SqlSession ss;
	
	public void write(CMsg m, HttpServletRequest req) {
//		String token = req.getParameter("token");
//		
//		String st = (String) req.getSession().getAttribute("successToken");
//		
//		if(st != null && token.equals(st)) {
//			
//		}
		
		String txt = m.getS_comment();
		txt = txt.replace("\r\n", "<br>");
		m.setS_comment(txt);
		
		userID u = (userID) req.getSession().getAttribute("loginUser");
		m.setU_email(u.getU_email());
		
		if(ss.getMapper(BoardMapper.class).writeMsg(m)==1) {
			System.out.println("등록 성공");
			
		}else {
			System.out.println("등록 실패");
		}
		
		
		
		
	}
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git
	
	
}
