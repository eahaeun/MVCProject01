//근태 정보를 나타내는 객체를 생성하고 관리하는 클래스
package project.model.request;

import java.sql.Date;
import java.util.Map;

public class KintaiRequest {
	private int KINTAI_NO;
	private String SHAIN_NO;
	private String KINTAI_KM;
	private Date NYUROKU_YMD;
	private Date KAISHI_YMD;
	private Date SHURYO_YMD;
	private int KINTAI_PAY;
	
	public KintaiRequest(String SHAIN_NO, String KINTAI_KM, Date NYUROKU_YMD, Date KAISHI_YMD, Date SHURYO_YMD, int KINTAI_PAY) {
		this.SHAIN_NO = SHAIN_NO;
		this.KINTAI_KM = KINTAI_KM;
		this.NYUROKU_YMD = NYUROKU_YMD;
		this.KAISHI_YMD = KAISHI_YMD;
		this.SHURYO_YMD = SHURYO_YMD;
		this.KINTAI_PAY = KINTAI_PAY;
	}
	public KintaiRequest() {}

	public String getSHAIN_NO() {
		return SHAIN_NO;
	}

	public String getKINTAI_KM() {
		return KINTAI_KM;
	}

	public Date getNYUROKU_YMD() {
		return NYUROKU_YMD;
	}

	public Date getKAISHI_YMD() {
		return KAISHI_YMD;
	}

	public Date getSHURYO_YMD() {
		return SHURYO_YMD;
	}

	public int getKINTAI_PAY() {
		return KINTAI_PAY;
	}
	
	//유효성 검사를 위한 메서드
	public void validate(Map<String,Boolean>errors) {
		if(SHAIN_NO == null || SHAIN_NO.trim().isEmpty()) {
			errors.put("SHAIN_NO", Boolean.TRUE);
		}
	}

	public void setSHAIN_NO(String SHAIN_NO) {
		this.SHAIN_NO = SHAIN_NO;
	}

	public void setKINTAI_KM(String kINTAI_KM) {
		KINTAI_KM = kINTAI_KM;
	}

	public void setNYUROKU_YMD(Date nYUROKU_YMD) {
		NYUROKU_YMD = nYUROKU_YMD;
	}

	public void setKAISHI_YMD(Date kAISHI_YMD) {
		KAISHI_YMD = kAISHI_YMD;
	}


	public void setSHURYO_YMD(Date sHURYO_YMD) {
		SHURYO_YMD = sHURYO_YMD;
	}

	public void setKINTAI_PAY(int kINTAI_PAY) {
		KINTAI_PAY = kINTAI_PAY;
	}

	public int getKINTAI_NO() {
		return KINTAI_NO;
	}
	public void setKINTAI_NO(int kINTAI_NO) {
		KINTAI_NO = kINTAI_NO;
	}

}

