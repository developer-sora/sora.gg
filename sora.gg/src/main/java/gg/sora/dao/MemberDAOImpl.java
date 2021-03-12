package gg.sora.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import gg.sora.dto.userID;

public class MemberDAOImpl implements MemberDAO {
	 
	    
	    @Inject
	    SqlSession ss;
	    
	    
	    
	    
	    //회원가입 관련 메소드
	    @Override
	    public void join(Map<String, Object>map, userID u) {
	 
	        map.get("u_email");
	        map.get("u_password");
	        map.get("u_nickname");
	        
	        ss.insert("member.insertUser",map);        
	    }
	    
	    
	    //로그인관련 메소드
	    @Override
	    public boolean loginCheck(userID u) {
	        String name
	            =ss.selectOne("member.login_check", u);
	        
	        //조건식 ? true일때의 값 : false일때의 값
	        return (name==null) ? false : true;
	    }
	 
	    
	    //아이디 찾기 관련 메소드
//	    @Override
//	    public String find_idCheck(MemberDTO dto) {
//	        String id = sqlSession.selectOne("member.find_id_check", dto);
//	        return id;
//	        
//	    }
	 
	    
	    //비밀번호 찾기 관련 메소드
//	    @Override
//	    public String find_passCheck(MemberDTO dto) {
//	        String pass = sqlSession.selectOne("member.find_pass_check", dto);
//	        return pass;
//	    }
	 
	    
	    //회원 인증 관련 메소드
	    //버튼을 클릭한 회원의 정보를 회원 테이블에 저장해서 사용할 수 있게 함
	    @Override
	    public void authentication(userID u) {
	        
	        ss.insert("member.authentication", u);
	        
	    }
	 
	 
//	    @Override
//	    public void pass_change(Map<String, Object> map, MemberDTO dto)throws Exception{
//	        
//	        map.get("member_pass");
//	        map.get("e_mail");
//	 
//	        sqlSession.update("member.pass_change", map);
//	    }
	 
	 
	    @Override
	    public boolean email_check(String u_email) throws Exception {
	        
	       String a = ss.selectOne("member.email_check", u_email);
	    
	        //조건식 ? true일때의 값 : false일때의 값
	        return (a==null) ? true : false;
	        
	    }
	 
	 
//	    @Override
//	    public boolean join_id_check(String user_id) throws Exception {
//	        String user_id1
//	        =sqlSession.selectOne("member.join_id_check", user_id);
//	    
//	        //조건식 ? true일때의 값 : false일때의 값
//	        return (user_id1==null) ? true : false;
//	    }
	 
	    
	    //회원의 프로필 정보를 리턴한다.
//	    @Override
//	    public List<MemberDTO> member_profile(String user_id) throws Exception {
//	        
//	        return sqlSession.selectList("member.member_profile", user_id);
//	    }


	    
}
