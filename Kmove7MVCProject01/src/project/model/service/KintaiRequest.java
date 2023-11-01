package project.model.service;

import java.sql.Date;
import java.util.Map;

public class KintaiRequest {
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
	
	public void validate(Map<String,Boolean>errors) {
		if(SHAIN_NO == null || SHAIN_NO.trim().isEmpty()) {
			errors.put("SHAIN_NO", Boolean.TRUE);
		}
	}

	public void setSHAIN_NO(String sHAIN_NO) {
		SHAIN_NO = sHAIN_NO;
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

	

}

