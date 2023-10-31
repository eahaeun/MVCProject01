package project.model.bean;

public class KyuyoDetail {
	private String shain_nm;
	private String nyusha_ymd;
	private String busho_nm;
	private String yakushoku_nm;
	private int kihon_pay;
	private int sikyu_pay;
	private int kojyo_pay;
	
	public String getShain_nm() {
		return shain_nm;
	}
	public void setShain_nm(String shain_nm) {
		this.shain_nm = shain_nm;
	}
	public String getNyusha_ymd() {
		return nyusha_ymd;
	}
	public void setNyusha_ymd(String nyusha_ymd) {
		this.nyusha_ymd = nyusha_ymd;
	}
	public String getBusho_nm() {
		return busho_nm;
	}
	public void setBusho_nm(String busho_nm) {
		this.busho_nm = busho_nm;
	}
	public String getYakushoku_nm() {
		return yakushoku_nm;
	}
	public void setYakushoku_nm(String yakushoku_nm) {
		this.yakushoku_nm = yakushoku_nm;
	}
	public int getKihon_pay() {
		return kihon_pay;
	}
	public void setKihon_pay(int kihon_pay) {
		this.kihon_pay = kihon_pay;
	}
	public int getSikyu_pay() {
		return sikyu_pay;
	}
	public void setSikyu_pay(int sikyu_pay) {
		this.sikyu_pay = sikyu_pay;
	}
	public int getKojyo_pay() {
		return kojyo_pay;
	}
	public void setKojyo_pay(int kojyo_pay) {
		this.kojyo_pay = kojyo_pay;
	}
	public KyuyoDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KyuyoDetail(String shain_nm, String nyusha_ymd, String busho_nm, String yakushoku_nm, int kihon_pay,
			int sikyu_pay, int kojyo_pay) {
		super();
		this.shain_nm = shain_nm;
		this.nyusha_ymd = nyusha_ymd;
		this.busho_nm = busho_nm;
		this.yakushoku_nm = yakushoku_nm;
		this.kihon_pay = kihon_pay;
		this.sikyu_pay = sikyu_pay;
		this.kojyo_pay = kojyo_pay;
	}
	
	
}
