package gg.sora.dao;

public class RunAndSpell {

	public String perks(int perks) {

		switch (perks) {
		case 8010: // 정복자
			return "perk-images/Styles/Precision/Conqueror/Conqueror.png";
		case 8021: // 기민한 발놀림
			return "perk-images/Styles/Precision/FleetFootwork/FleetFootwork.png";
		case 8008: // 치명적 속도
			return "perk-images/Styles/Precision/LethalTempo/LethalTempoTemp.png";
		case 8005: // 집중 공격
			return "perk-images/Styles/Precision/PressTheAttack/PressTheAttack.png";
		case 8437: // 착취의 손아귀
			return "perk-images/Styles/Resolve/GraspOfTheUndying/GraspOfTheUndying.png";
		case 8439: // 여진
			return "perk-images/Styles/Resolve/VeteranAftershock/VeteranAftershock.png";
		case 8465: // 수호자
			return "perk-images/Styles/Resolve/Guardian/Guardian.png";
		case 8214: // 콩콩이
			return "perk-images/Styles/Sorcery/SummonAery/SummonAery.png";
		case 8229: // 신비로운 유성
			return "perk-images/Styles/Sorcery/ArcaneComet/ArcaneComet.png";
		case 8230: // 난입
			return "perk-images/Styles/Sorcery/PhaseRush/PhaseRush.png";
		case 8112: // 감전
			return "perk-images/Styles/Domination/Electrocute/Electrocute.png";
		case 8124: // 포식자
			return "perk-images/Styles/Domination/Predator/Predator.png";
		case 8128: // 어둠의 수확
			return "perk-images/Styles/Domination/DarkHarvest/DarkHarvest.png";
		case 9923: // 칼날비
			return "perk-images/Styles/Domination/HailOfBlades/HailOfBlades.png";
		case 8351: // 빙결 강화
			return "perk-images/Styles/Inspiration/GlacialAugment/GlacialAugment.png";
		case 8360: // 봉인 풀린 주문서
			return "perk-images/Styles/Inspiration/UnsealedSpellbook/UnsealedSpellbook.png";
		case 8358: // 만능의 돌
			return "perk-images/Styles/Inspiration/MasterKey/MasterKey.png";
		// case : //
		// return "";
		// case : //
		// return "";
		 case 8100: // 지배
			 return "perk-images/Styles/7200_Domination.png";
			 case 8300: // 영감
				 return "perk-images/Styles/7203_Whimsy.png";
			 case 8000: // 정밀
				 return "perk-images/Styles/7201_Precision.png";
			 case 8400: // 결의
				 return "perk-images/Styles/7204_Resolve.png";
			 case 8200: // 마법
				 return "perk-images/Styles/7202_Sorcery.png";

		default:

			return null;
		}}
		
		public String perksKr(int perks) {

			switch (perks) {
			case 8010: // 정복자
				return "정복자";
			case 8021: // 기민한 발놀림
				return "기민한 발놀림";
			case 8008: // 치명적 속도
				return "치명적 속도";
			case 8005: // 집중 공격
				return "집중 공격";
			case 8437: // 착취의 손아귀
				return "착취의 손아귀";
			case 8439: // 여진
				return "여진";
			case 8465: // 수호자
				return "수호자";
			case 8214: // 콩콩이
				return "콩콩이";
			case 8229: // 신비로운 유성
				return "신비로운 유성";
			case 8230: // 난입
				return "난입";
			case 8112: // 감전
				return "감전";
			case 8124: // 포식자
				return "포식자";
			case 8128: // 어둠의 수확
				return "어둠의 수확";
			case 9923: // 칼날비
				return "칼날비";
			case 8351: // 빙결 강화
				return "빙결 강화";
			case 8360: // 봉인 풀린 주문서
				return "봉인 풀린 주문서";
			case 8358: // 만능의 돌
				return "프로토 타입: 만능의 돌";
			// case : //
			// return "";
			// case : //
			// return "";
			 case 8100: // 지배
				 return "지배";
				 case 8300: // 영감
					 return "영감";
				 case 8000: // 정밀
					 return "정밀";
				 case 8400: // 결의
					 return "결의";
				 case 8200: // 마법
					 return "마법";

			default:

				return null;
			}
	}
	//https://ddragon.leagueoflegends.com/cdn/11.4.1/img/spell/스펠명.png
	public String spell(int spell) {
		switch (spell) {
		case 4: //점멸
			return "SummonerFlash.png";
		case 6: //유체화
			return "SummonerHaste.png";
		case 7: // 힐
			return "SummonerHeal.png";
		case 13: // 총명
			return "SummonerMana.png";
		case 11: //스마이트
			return "SummonerSmite.png";
		case 12: //텔레포트
			return "SummonerTeleport.png";
		case 32: // 눈덩이 던지기
			return "SummonerSnowURFSnowball_Mark.png";
		case 21: //배리어
			return "SummonerBarrier.png";
		case 1: //정화
			return "SummonerBoost.png";
		case 14: // 점화
			return "SummonerDot.png";
		case 3: //탈진
			return "SummonerExhaust.png";
	//	case :
	//		return "";
	//	case :
	//		return "";
			
			

		default:
			return null;
		}
		
	}
	
	public String spellKr(int spell) {
		switch (spell) {
		case 4: //점멸
			return "점멸";
		case 6: //유체화
			return "유체화";
		case 7: // 힐
			return "회복";
		case 13: // 총명
			return "총명";
		case 11: //스마이트
			return "강타";
		case 12: //텔레포트
			return "순간이동";
		case 39: // 눈덩이 던지기
			return "눈덩이 던지기";
		case 21: //배리어
			return "방어막";
		case 1: //정화
			return "정화";
		case 14: // 점화
			return "점화";
		case 3: //탈진
			return "탈진";
	//	case :
	//		return "";
	//	case :
	//		return "";
			
			

		default:
			return null;
		}
		
	}

}