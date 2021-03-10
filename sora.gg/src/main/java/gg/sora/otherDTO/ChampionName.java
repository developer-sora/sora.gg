package gg.sora.otherDTO;

public class ChampionName {
	private String championKr;
	private String championEn;
	public ChampionName() {
		// TODO Auto-generated constructor stub
	}
	public ChampionName(String championKr, String championEn) {
		super();
		this.championKr = championKr;
		this.championEn = championEn;
	}
	public String getChampionKr() {
		return championKr;
	}
	public void setChampionKr(String championKr) {
		this.championKr = championKr;
	}
	public String getChampionEn() {
		return championEn;
	}
	public void setChampionEn(String championEn) {
		this.championEn = championEn;
	}
	
	
}
