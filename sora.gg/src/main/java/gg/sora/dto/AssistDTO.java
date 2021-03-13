package gg.sora.dto;

public class AssistDTO {
	private String assistSname;
	private String assistChampionKr;
	private String assistChampionEn;
	
	public AssistDTO() {
		// TODO Auto-generated constructor stub
	}

	public AssistDTO(String assistSname, String assistChampionKr, String assistChampionEn) {
		super();
		this.assistSname = assistSname;
		this.assistChampionKr = assistChampionKr;
		this.assistChampionEn = assistChampionEn;
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
