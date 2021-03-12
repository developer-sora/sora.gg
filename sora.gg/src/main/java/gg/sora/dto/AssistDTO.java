package gg.sora.dto;

public class AssistDTO {
	private String assistSname;
	private String assistChampionKr;
	private String assistChampionEn;
	private String sname;
	private String participantId;
	
	public AssistDTO() {
		// TODO Auto-generated constructor stub
	}

	public AssistDTO(String assistSname, String assistChampionKr, String assistChampionEn, String sname,
			String participantId) {
		super();
		this.assistSname = assistSname;
		this.assistChampionKr = assistChampionKr;
		this.assistChampionEn = assistChampionEn;
		this.sname = sname;
		this.participantId = participantId;
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


	public String getAssistSname() {
		return assistSname;
	}

	public void setAssistSname(String assistSname) {
		this.assistSname = assistSname;
	}

	public String getAssistChampionKr() {
		return assistChampionKr;
	}

	public void setAssistChampionKr(String assistChampionKr) {
		this.assistChampionKr = assistChampionKr;
	}

	public String getAssistChampionEn() {
		return assistChampionEn;
	}

	public void setAssistChampionEn(String assistChampionEn) {
		this.assistChampionEn = assistChampionEn;
	}
	
}
