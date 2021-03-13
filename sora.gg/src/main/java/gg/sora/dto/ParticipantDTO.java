package gg.sora.dto;

public class ParticipantDTO {

	private int participantId;
	private String sname;
	private String championKr;
	private String championEn;

	public ParticipantDTO() {
	}

	public ParticipantDTO(int participantId, String sname, String championKr, String championEn) {
		super();
		this.participantId = participantId;
		this.sname = sname;
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



	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
