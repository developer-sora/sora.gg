package gg.sora.dto;

import java.math.BigDecimal;
import java.util.Date;

public class tip {
	private BigDecimal c_no;
	private String c_writer;
	private String c_name;
	private String c_comment;
	private Date c_date;

	public tip() {
		// TODO Auto-generated constructor stub
	}

	public tip(BigDecimal c_no, String c_writer, String c_name, String c_comment, Date c_date) {
		super();
		this.c_no = c_no;
		this.c_writer = c_writer;
		this.c_name = c_name;
		this.c_comment = c_comment;
		this.c_date = c_date;
	}

	public BigDecimal getC_no() {
		return c_no;
	}

	public void setC_no(BigDecimal c_no) {
		this.c_no = c_no;
	}

	public String getC_writer() {
		return c_writer;
	}

	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
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

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

}
