package project.model.request;

public class KyuyoRequest {
	private String shain_no;
	private String kizoku_ym;
	private int kihon_pay;
	private int kintai_pay;
	private int shoku_pay;
	private int nenkin;
	private int kenko;
	private int koyo;
	private int shotoku;
	private int etc;
	
	
	public String getShain_no() {
		return shain_no;
	}
	public void setShain_no(String shain_no) {
		this.shain_no = shain_no;
	}
	
	
	public String getKizoku_ym() {
		return kizoku_ym;
	}
	public void setKizoku_ym(String kizoku_ym) {
		this.kizoku_ym = kizoku_ym;
	}
	public int getKihon_pay() {
		return kihon_pay;
	}
	public void setKihon_pay(int kihon_pay) {
		this.kihon_pay = kihon_pay;
	}
	public int getKintai_pay() {
		return kintai_pay;
	}
	public void setKintai_pay(int kintai_pay) {
		this.kintai_pay = kintai_pay;
	}
	public int getShoku_pay() {
		return shoku_pay;
	}
	public void setShoku_pay(int shoku_pay) {
		this.shoku_pay = shoku_pay;
	}
	public int getNenkin() {
		return nenkin;
	}
	public void setNenkin(int nenkin) {
		this.nenkin = nenkin;
	}
	public int getKenko() {
		return kenko;
	}
	public void setKenko(int kenko) {
		this.kenko = kenko;
	}
	public int getKoyo() {
		return koyo;
	}
	public void setKoyo(int koyo) {
		this.koyo = koyo;
	}
	public int getShotoku() {
		return shotoku;
	}
	public void setShotoku(int shotoku) {
		this.shotoku = shotoku;
	}
	public int getEtc() {
		return etc;
	}
	public void setEtc(int etc) {
		this.etc = etc;
	}
	public KyuyoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KyuyoRequest(String shain_no, String kizoku_ym, int kihon_pay, int kintai_pay, int shoku_pay, int nenkin,
			int kenko, int koyo, int shotoku, int etc) {
		super();
		this.shain_no = shain_no;
		this.kizoku_ym = kizoku_ym;
		this.kihon_pay = kihon_pay;
		this.kintai_pay = kintai_pay;
		this.shoku_pay = shoku_pay;
		this.nenkin = nenkin;
		this.kenko = kenko;
		this.koyo = koyo;
		this.shotoku = shotoku;
		this.etc = etc;
	}
	
	
}
