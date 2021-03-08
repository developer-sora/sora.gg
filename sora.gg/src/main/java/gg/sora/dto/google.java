package gg.sora.dto;

public class google {
	private String g_email;
	private String g_given_name;
	
	public google() {
		// TODO Auto-generated constructor stub
	}

	public google(String g_email, String g_given_name) {
		super();
		this.g_email = g_email;
		this.g_given_name = g_given_name;
	}

	public String getG_email() {
		return g_email;
	}

	public void setG_email(String g_email) {
		this.g_email = g_email;
	}

	public String getG_given_name() {
		return g_given_name;
	}

	public void setG_given_name(String g_given_name) {
		this.g_given_name = g_given_name;
	}
	
}
