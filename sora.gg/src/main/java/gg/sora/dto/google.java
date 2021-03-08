package gg.sora.dto;

public class google {
	private String g_user_id;
	private String g_email;
	private String g_name;
	
	public google() {
		// TODO Auto-generated constructor stub
	}

	

	public google(String g_user_id, String g_email, String g_name) {
		super();
		this.g_user_id = g_user_id;
		this.g_email = g_email;
		this.g_name = g_name;
	}



	public String getG_email() {
		return g_email;
	}

	public void setG_email(String g_email) {
		this.g_email = g_email;
	}



	public String getG_user_id() {
		return g_user_id;
	}



	public void setG_user_id(String g_user_id) {
		this.g_user_id = g_user_id;
	}



	public String getG_name() {
		return g_name;
	}



	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	
	
}
