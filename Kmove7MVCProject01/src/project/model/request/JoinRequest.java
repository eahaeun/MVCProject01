package project.model.request;

import java.util.Map;

public class JoinRequest {
	private String kanrisha_uid;
	private String kanrisha_pw;
	private String confirm_pw;
	private String kanrisha_nm;

	

	public JoinRequest(String kanrisha_uid, String kanrisha_pw, String confirm_pw, String kanrisha_nm) {
		super();
		this.kanrisha_uid = kanrisha_uid;
		this.kanrisha_pw = kanrisha_pw;
		this.confirm_pw = confirm_pw;
		this.kanrisha_nm = kanrisha_nm;
	}

	public JoinRequest() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getConfirm_pw() {
		return confirm_pw;
	}

	public void setConfirm_pw(String confirm_pw) {
		this.confirm_pw = confirm_pw;
	}

	public String getKanrisha_nm() {
		return kanrisha_nm;
	}

	public void setKanrisha_nm(String kanrisha_nm) {
		this.kanrisha_nm = kanrisha_nm;
	}

	// 비번과 비번확인이 맞는지 확인하는 메서드
	public boolean isPasswordEqualToConfirm() {
		return kanrisha_pw != null && kanrisha_pw.equals(confirm_pw);
	}

	// 빈칸, 비번확인 메서드
	public void validate(Map<String, Boolean> errors) {
		// Map에 id라는 값이 없으면 checkEmpty메서드를 통해 (id,TRUE)를 put함
		// 나머지 프로퍼티들도 마찬가지...
		checkEmpty(errors, kanrisha_uid, "kanrisha_uid");
		checkEmpty(errors, kanrisha_pw, "kanrisha_pw");
		checkEmpty(errors, confirm_pw, "confirm_pw");
		checkEmpty(errors, kanrisha_nm, "kanrisha_nm");
		if (!errors.containsKey("confirm_pw")) {
			if (!isPasswordEqualToConfirm()) {
				// 비번과 비번확인이 틀리면 put
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
