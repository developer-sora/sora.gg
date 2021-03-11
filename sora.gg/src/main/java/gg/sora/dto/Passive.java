package gg.sora.dto;

public class Passive {

	private String name;
	private String nameKr;
	private String imgName;
	private String title;
	private String description;

	public Passive() {
		// TODO Auto-generated constructor stub
	}

	public Passive(String name, String nameKr, String imgName, String title, String description) {
		super();
		this.name = name;
		this.nameKr = nameKr;
		this.imgName = imgName;
		this.title = title;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameKr() {
		return nameKr;
	}

	public void setNameKr(String nameKr) {
		this.nameKr = nameKr;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.replaceAll("<(/)?([a-zA-Z0-9]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}

}
