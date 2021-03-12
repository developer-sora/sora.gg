package gg.sora.dao;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.sora.dto.userID;

public class LoginDAO {

	
	@Autowired
	private SqlSession ss;
	
	public void join(userID u, HttpServletRequest req) {
		
		String u_email = req.getParameter("u_email");
		String u_nickname = req.getParameter("u_nickname");
		String u_password = req.getParameter("u_password");
		
		u.setU_email(u_email);
		u.setU_nickname(u_nickname);
		u.setU_password(u_password);
		
		if (ss.getMapper(Mapper.class).join(u) == 1) {
			req.setAttribute("r", "가입 성공!");
			
		} else {
			req.setAttribute("r", "가입 실패");
		}
		
	}
	
	public boolean login(userID u, HttpServletRequest req) {
		
		userID dbu = ss.getMapper(Mapper.class).getUserByID(u);
		
		if(dbu!=null) {
			if(dbu.getU_password().equals(u.getU_password())) {
				req.getSession().setAttribute("loginUser", dbu);
				req.getSession().setMaxInactiveInterval(60);
				
				return true;
				
			}else {
				req.setAttribute("lr", "비밀번호가 틀렸습니다.");
				return false;
			}
		}else {
			req.setAttribute("lr", "존재하지 않는 email입니다.");
			return false;
		}
		
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginUser", null);
		
	}
	
	
	
}
