package gg.sora.dto;

public class userID {
	String u_email;
	String u_nickname;
	String u_password;
	
	public userID() {
		// TODO Auto-generated constructor stub
	}

	public userID(String u_email, String u_nickname, String u_password) {
		super();
		this.u_email = u_email;
		this.u_nickname = u_nickname;
		this.u_password = u_password;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_nickname() {
		return u_nickname;
	}

	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
}
