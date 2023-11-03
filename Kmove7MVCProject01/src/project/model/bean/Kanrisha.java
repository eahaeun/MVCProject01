package project.model.bean;

public class Kanrisha {
	private String kanrisha_uid;
	private String kanrisha_pw;
	private String kanrisha_nm;

	public Kanrisha() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kanrisha(String kanrisha_uid, String kanrisha_pw, String kanrisha_nm) {
		super();
		this.kanrisha_uid = kanrisha_uid;
		this.kanrisha_pw = kanrisha_pw;
		this.kanrisha_nm = kanrisha_nm;
	}

	public String getKanrisha_uid() {
		return kanrisha_uid;
	}

	public void setKanrisha_uid(String kanrisha_uid) {
		this.kanrisha_uid = kanrisha_uid;
	}

	public String getKanrisha_pw() {
		return kanrisha_pw;
	}

	public void setKanrisha_pw(String kanrisha_pw) {
		this.kanrisha_pw = kanrisha_pw;
	}

	public String getKanrisha_nm() {
		return kanrisha_nm;
	}

	public void setKanrisha_nm(String kanrisha_nm) {
		this.kanrisha_nm = kanrisha_nm;
	}

	public boolean matchPassword(String pwd) {
		return kanrisha_pw.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.kanrisha_pw = newPwd;
	}

	public void changeName(String newNm) {
		this.kanrisha_nm = newNm;
	}

}