package project.model.bean;

import java.sql.Date;

public class Kintai {

	private String SHAIN_NO;
	private String KINTAI_KM;
	private Date NYUROKU_YMD;
	private Date KAISHI_YMD;
	private Date SHURYO_YMD;
	private int KINTAI_PAY;
	
	public Kintai(String SHAIN_NO, String KINTAI_KM, Date NYUROKU_YMD, Date KAISHI_YMD, Date SHURYO_YMD, int KINTAI_PAY) {
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
	
}
