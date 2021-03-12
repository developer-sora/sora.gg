package gg.sora.community;

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
	
	
}
