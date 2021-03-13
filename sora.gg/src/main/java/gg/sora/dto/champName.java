package gg.sora.dto;

public class champName {

	private String nameKr;
	private String name;
	private int no;

	public champName() {
		// TODO Auto-generated constructor stub
	}

	public champName(String nameKr, String name, int no) {
		super();
		this.nameKr = nameKr;
		this.name = name;
		this.no = no;
	}

	public String getNameKr() {
		return nameKr;
	}

	public void setNameKr(String nameKr) {
		this.nameKr = nameKr;
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

}
