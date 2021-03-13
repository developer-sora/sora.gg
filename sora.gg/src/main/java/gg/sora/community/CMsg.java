package gg.sora.community;

import java.math.BigDecimal;
import java.util.Date;

public class CMsg {
	private String u_email;
<<<<<<< HEAD
	private String u_nickname;
	
	
	
	private BigDecimal s_no;
	private String s_title;
	private String s_comment;
	private Date s_date;
	
	public CMsg() {
		// TODO Auto-generated constructor stub
	}



	public CMsg(String u_email, String u_nickname, BigDecimal s_no, String s_title, String s_comment, Date s_date) {
		super();
		this.u_email = u_email;
		this.u_nickname = u_nickname;
		this.s_no = s_no;
		this.s_title = s_title;
		this.s_comment = s_comment;
		this.s_date = s_date;
	}


	public String getS_title() {
		return s_title;
	}






	public void setS_title(String s_title) {
		this.s_title = s_title;
	}






	public String getU_nickname() {
		return u_nickname;
	}



	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}

=======
	
	private BigDecimal s_no;
	private String s_comment;
	private Date s_date;
	
	public CMsg() {
		// TODO Auto-generated constructor stub
	}

	public CMsg(String u_email, BigDecimal s_no, String s_comment, Date s_date) {
		super();
		this.u_email = u_email;
		this.s_no = s_no;
		this.s_comment = s_comment;
		this.s_date = s_date;
	}
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git


	public String getU_email() {
		return u_email;
	}



	public void setU_email(String u_email) {
		this.u_email = u_email;
	}



	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}



	public String getS_comment() {
		return s_comment;
	}

	public void setS_comment(String s_comment) {
		this.s_comment = s_comment;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	
		
}
