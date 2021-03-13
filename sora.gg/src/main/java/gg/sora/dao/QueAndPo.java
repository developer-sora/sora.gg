package gg.sora.dao;

public class QueAndPo {

	public  String queue(int key) {
		switch (key) {
		case 0 : 
			return "커스텀게임"; 
		case 430: 
			return "일반게임"; 
		case 420: 
			return "솔로랭크"; 
		case 440: 
			return "자유랭크"; 
		case 900: 
			return "우르프모드"; 
		case 830: 
			return "입문 AI"; 
		case 840: 
			return "초급 AI"; 
		case 850: 
			return "중급AI"; 
		case 450: 
			return "무작위 총력전"; 
//		case : 
//			return quetype =""; 

		default:
			return "기타게임"; 
		}
		
		
		
		
	}
	

	public String position(Object lane, Object role) {
		
		if (role.equals("DUO_SUPPORT")) {
			return "서포터";
		} else if (role.equals("DUO_CARRY")) {
			return "원거리 딜러";
		} else if (lane.equals("MIDDLE")) {
			return "미드";
		} else if (lane.equals("JUNGLE")) {
			return "정글";
		} else if (lane.equals("TOP")) {
			 return "탑";
		}
		
		
		return "기타";
		
	}
	

	
}
