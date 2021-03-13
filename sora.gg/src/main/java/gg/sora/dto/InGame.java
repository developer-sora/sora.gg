package gg.sora.dto;

public class InGame {
	private String team;
	private String champEn;
	private String champKr;
	private String spell1;
	private String spell2;
	private String spell1Kr;
	private String spell2Kr;
	private String perks1;
	private String perks2;
	private String perks1Kr;
	private String perks2Kr;
	private String name;
	private String ban;
	private String banKr;
	private String tier;
	private String rank;
	
	public InGame() {
		// TODO Auto-generated constructor stub
	}





	public InGame(String team, String champEn, String champKr, String spell1, String spell2, String spell1Kr,
			String spell2Kr, String perks1, String perks2, String perks1Kr, String perks2Kr, String name, String ban,
			String banKr, String tier, String rank) {
		super();
		this.team = team;
		this.champEn = champEn;
		this.champKr = champKr;
		this.spell1 = spell1;
		this.spell2 = spell2;
		this.spell1Kr = spell1Kr;
		this.spell2Kr = spell2Kr;
		this.perks1 = perks1;
		this.perks2 = perks2;
		this.perks1Kr = perks1Kr;
		this.perks2Kr = perks2Kr;
		this.name = name;
		this.ban = ban;
		this.banKr = banKr;
		this.tier = tier;
		this.rank = rank;
	}





	public String getSpell1Kr() {
		return spell1Kr;
	}





	public void setSpell1Kr(String spell1Kr) {
		this.spell1Kr = spell1Kr;
	}





	public String getSpell2Kr() {
		return spell2Kr;
	}





	public void setSpell2Kr(String spell2Kr) {
		this.spell2Kr = spell2Kr;
	}





	public String getPerks1Kr() {
		return perks1Kr;
	}





	public void setPerks1Kr(String perks1Kr) {
		this.perks1Kr = perks1Kr;
	}





	public String getPerks2Kr() {
		return perks2Kr;
	}





	public void setPerks2Kr(String perks2Kr) {
		this.perks2Kr = perks2Kr;
	}





	public String getBanKr() {
		return banKr;
	}





	public void setBanKr(String banKr) {
		this.banKr = banKr;
	}





	public String getChampEn() {
		return champEn;
	}





	public void setChampEn(String champEn) {
		this.champEn = champEn;
	}





	public String getChampKr() {
		return champKr;
	}





	public void setChampKr(String champKr) {
		this.champKr = champKr;
	}





	public String getTier() {
		return tier;
	}









	public void setTier(String tier) {
		this.tier = tier;
	}









	public String getRank() {
		return rank;
	}









	public void setRank(String rank) {
		this.rank = rank;
	}









	public String getPerks1() {
		return perks1;
	}




	public void setPerks1(String perks1) {
		this.perks1 = perks1;
	}




	public String getPerks2() {
		return perks2;
	}




	public void setPerks2(String perks2) {
		this.perks2 = perks2;
	}




	public String getBan() {
		return ban;
	}


	public void setBan(String ban) {
		this.ban = ban;
	}


	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}


	public String getSpell1() {
		return spell1;
	}

	public void setSpell1(String spell1) {
		this.spell1 = spell1;
	}

	public String getSpell2() {
		return spell2;
	}

	public void setSpell2(String spell2) {
		this.spell2 = spell2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
