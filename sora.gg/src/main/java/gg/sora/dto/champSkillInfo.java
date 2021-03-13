package gg.sora.dto;

public class champSkillInfo {

	private String name;
	private int no;
	private String skillName;
	private String tooltip;

	public champSkillInfo() {
		// TODO Auto-generated constructor stub
	}

	public champSkillInfo(String name, int no, String skillName, String tooltip) {
		super();
		this.name = name;
		this.no = no;
		this.skillName = skillName;
		this.tooltip = tooltip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
//		this.tooltip = tooltip.replace("{{ ", "<").replace(" }}", ">");
//		System.out.println((this.tooltip));
//		System.out.println("-----------------------------");
		this.tooltip = tooltip.replaceAll("<(/)?([a-zA-Z0-9.-]*)(\\s[a-zA-Z0-9.-]*=[^>]*)?(\\s)*(/)?>", "").replace("{{ ", "<")
				.replace(" }}", ">").replace("*", "").replace("-", "")
				.replaceAll("<(/)?([a-zA-Z0-9.:.-.%]*)(\\s[a-zA-Z0-9.:.-.%]*=[^>]*)?(\\s)*(/)?>", "???")
				.replaceAll("<(/)?([a-zA-Z0-9._.-.?]*)(\\s[a-zA-Z._.-.?]*=[^>]*)?(\\s)*(/)?>", "");

		System.out.println((this.tooltip));
//		System.out.println("-----------------------------");

	}

}
