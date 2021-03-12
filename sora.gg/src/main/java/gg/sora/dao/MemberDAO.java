package gg.sora.dao;

import java.util.Map;

import gg.sora.dto.userID;

public interface MemberDAO {
		 
	    public void join(Map<String, Object>map, userID u);     //회원가입 관련
	    
	    public boolean loginCheck(userID u);        //로그인 관련
	    
//	    public String find_idCheck(userID u);        //아이디 찾기
	    
//	    public String find_passCheck(userID u);    //비밀번호 찾기
	 
	    public void authentication(userID u);        //소셜 로그인 회원인증 관련 메소드
	 
//	    public void pass_change(Map<String, Object> map, userID u)throws Exception;    //비밀번호 변경
	 
	    public boolean email_check(String u_email) throws Exception;    //이메일 중복 확인
	    
	    
	 
//	    public boolean join_id_check(String user_id)throws Exception;    //아이디 중복 확인
	 
//	    public List<userID> member_profile(String user_id) throws Exception;  
}
