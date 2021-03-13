package gg.sora.dto;

import java.util.ArrayList;

public class KillVictimDTO {
	private String timestamp;
	private String killSname;
	private String killChampionKr;
	private String killChampionEn;
	private String victimSname;
	private String victimChampionKr;
	private String victimChampionEn;
	private String participantId;
	private String sname;
	private ArrayList<AssistDTO> assistList;

	public KillVictimDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public KillVictimDTO(String timestamp, String killSname, String killChampionKr, String killChampionEn,
			String victimSname, String victimChampionKr, String victimChampionEn, ArrayList<AssistDTO> assistList) {
		super();
		this.timestamp = timestamp;
		this.killSname = killSname;
		this.killChampionKr = killChampionKr;
		this.killChampionEn = killChampionEn;
		this.victimSname = victimSname;
		this.victimChampionKr = victimChampionKr;
		this.victimChampionEn = victimChampionEn;
		this.assistList = assistList;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getKillSname() {
		return killSname;
	}

	public void setKillSname(String killSname) {
		this.killSname = killSname;
	}

	public String getKillChampionKr() {
		return killChampionKr;
	}

	public void setKillChampionKr(String killChampionKr) {
		this.killChampionKr = killChampionKr;
	}

	public String getKillChampionEn() {
		return killChampionEn;
	}

	public void setKillChampionEn(String killChampionEn) {
		this.killChampionEn = killChampionEn;
	}

	public String getVictimSname() {
		return victimSname;
	}

	public void setVictimSname(String victimSname) {
		this.victimSname = victimSname;
	}

	public String getVictimChampionKr() {
		return victimChampionKr;
	}

	public void setVictimChampionKr(String victimChampionKr) {
		this.victimChampionKr = victimChampionKr;
	}

	public String getVictimChampionEn() {
		return victimChampionEn;
	}

	public void setVictimChampionEn(String victimChampionEn) {
		this.victimChampionEn = victimChampionEn;
	}

	public ArrayList<AssistDTO> getAssistList() {
		return assistList;
	}

	public void setAssistList(ArrayList<AssistDTO> assistList) {
		this.assistList = assistList;
	}

	

}
