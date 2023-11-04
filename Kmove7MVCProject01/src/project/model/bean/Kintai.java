package project.model.bean;

import java.sql.Date;

public class Kintai {
	private int KINTAI_NO;
	private String SHAIN_NO;
	private String KINTAI_KM;
	private Date NYUROKU_YMD;
	private Date KAISHI_YMD;
	private Date SHURYO_YMD;
	private int KINTAI_PAY;
	public int getKINTAI_NO() {
		return KINTAI_NO;
	}
	public void setKINTAI_NO(int kINTAI_NO) {
		KINTAI_NO = kINTAI_NO;
	}
	public String getSHAIN_NO() {
		return SHAIN_NO;
	}
	public void setSHAIN_NO(String sHAIN_NO) {
		SHAIN_NO = sHAIN_NO;
	}
	public String getKINTAI_KM() {
		return KINTAI_KM;
	}
	public void setKINTAI_KM(String kINTAI_KM) {
		KINTAI_KM = kINTAI_KM;
	}
	public Date getNYUROKU_YMD() {
		return NYUROKU_YMD;
	}
	public void setNYUROKU_YMD(Date nYUROKU_YMD) {
		NYUROKU_YMD = nYUROKU_YMD;
	}
	public Date getKAISHI_YMD() {
		return KAISHI_YMD;
	}
	public void setKAISHI_YMD(Date kAISHI_YMD) {
		KAISHI_YMD = kAISHI_YMD;
	}
	public Date getSHURYO_YMD() {
		return SHURYO_YMD;
	}
	public void setSHURYO_YMD(Date sHURYO_YMD) {
		SHURYO_YMD = sHURYO_YMD;
	}
	public int getKINTAI_PAY() {
		return KINTAI_PAY;
	}
	public void setKINTAI_PAY(int kINTAI_PAY) {
		KINTAI_PAY = kINTAI_PAY;
	}
	public Kintai(int kINTAI_NO, String sHAIN_NO, String kINTAI_KM, Date nYUROKU_YMD, Date kAISHI_YMD, Date sHURYO_YMD,
			int kINTAI_PAY) {
		super();
		KINTAI_NO = kINTAI_NO;
		SHAIN_NO = sHAIN_NO;
		KINTAI_KM = kINTAI_KM;
		NYUROKU_YMD = nYUROKU_YMD;
		KAISHI_YMD = kAISHI_YMD;
		SHURYO_YMD = sHURYO_YMD;
		KINTAI_PAY = kINTAI_PAY;
	}
	public Kintai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
