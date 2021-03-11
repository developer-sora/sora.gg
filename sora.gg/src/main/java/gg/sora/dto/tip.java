package gg.sora.dto;

import java.math.BigDecimal;

public class tip {
	BigDecimal c_no;
	String c_name;
	String c_comment;

	public tip() {
		// TODO Auto-generated constructor stub
	}

	public tip(BigDecimal c_no, String c_name, String c_comment) {
		super();
		this.c_no = c_no;
		this.c_name = c_name;
		this.c_comment = c_comment;
	}

	public BigDecimal getC_no() {
		return c_no;
	}

	public void setC_no(BigDecimal c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_comment() {
		return c_comment;
	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}

}
