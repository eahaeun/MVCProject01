package project.model.bean;

public class Kyuyo {
	private String shain_no;
	private String kizoku_ym;
	private int sikyu_pay;
	private int kojyo_pay;
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
	public Kyuyo(String shain_no, String kizoku_ym, int sikyu_pay, int kojyo_pay) {
		super();
		this.shain_no = shain_no;
		this.kizoku_ym = kizoku_ym;
		this.sikyu_pay = sikyu_pay;
		this.kojyo_pay = kojyo_pay;
	}
	public Kyuyo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
