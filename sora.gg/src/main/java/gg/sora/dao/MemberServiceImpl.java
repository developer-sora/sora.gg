package gg.sora.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import gg.sora.dto.userID;


public class MemberServiceImpl implements MemberService {
 
    
	
    @Inject    
    MemberDAO memberdao; //dao를 사용하기 위해 의존성을 주입
    private JavaMailSender mailSender;
 
    
    
    @Override    //회원가입 메소드, Map과 dto를 갖이 넘김
    public void join(Map<String, Object>map,userID u) {
        memberdao.join(map,u);
 
    }
 
 
    @Override    //로그인 관련 메소드 (세션에 아이디와 비밀번호를 저장)
    public boolean loginCheck(userID u, HttpSession session) {
        
        boolean result = memberdao.loginCheck(u);
        if(result) {    //로그인 성공
            session.setAttribute("u_email", u.getU_email());
            session.setAttribute("u_password", u.getU_password());
            System.out.println(session.getAttribute("u_email"));
            System.out.println(session.getAttribute("u_password"));
        }
     
        
        return result;
    }
 
    //아이디 찾기
//    @Override
//    public String find_idCheck(MemberDTO dto) {
//        String id = memberdao.find_idCheck(dto);
//        
//        return id;
//    }

    //비밀번호 찾기
//    @Override
//    public String find_passCheck(MemberDTO dto) {
//        String pass = memberdao.find_passCheck(dto);
//        return pass;
//    }
 
 
    @Override
    public void authentication(userID u) {
        
        memberdao.authentication(u);
    }
 
 
//    @Override
//    public void pass_change(Map<String, Object> map, MemberDTO dto) throws Exception {
//        
//        
//        memberdao.pass_change(map,dto);
//    }
 
 
    //이메일 중복 확인
    @Override
    public boolean email_check(String u_email) throws Exception{
        
        boolean result = memberdao.email_check(u_email);
        return result;
        
    }


	@Override
	public List<userID> member_profile(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
 
    //아이디 중복 확인
//    @Override
//    public boolean join_id_check(String user_id) throws Exception {
//    
//        boolean result = memberdao.join_id_check(user_id);
//        
//        return result;
//    }
 
 
    //자신의 프로필을 볼 수 있게 하는 메소드
//    @Override
//    public List<MemberDTO> member_profile(String user_id) throws Exception{
//        
//        return memberdao.member_profile(user_id);
//    }
    
 
	 
}
