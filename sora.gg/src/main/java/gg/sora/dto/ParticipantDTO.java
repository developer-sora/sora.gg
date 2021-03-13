package gg.sora.dto;

public class ParticipantDTO {

	private int participantId;
	private String partisname;
	private String championKr;
	private String championEn;

	public ParticipantDTO() {
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



	public String getPartisname() {
		return partisname;
	}



	public void setPartisname(String partisname) {
		this.partisname = partisname;
	}



	public ParticipantDTO(int participantId, String partisname, String championKr, String championEn) {
		super();
		this.participantId = participantId;
		this.partisname = partisname;
		this.championKr = championKr;
		this.championEn = championEn;
	}



}
