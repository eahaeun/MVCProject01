package project.model.request;

public class TaishokuRequest {
	private String shain_no;
	private String taishoku_jiyu;
	private String taishoku_renraku;
	private int taishoku_pay;

	public TaishokuRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaishokuRequest(String shain_no, String taishoku_jiyu, String taishoku_renraku, int taishoku_pay) {
		super();
		this.shain_no = shain_no;
		this.taishoku_jiyu = taishoku_jiyu;
		this.taishoku_renraku = taishoku_renraku;
		this.taishoku_pay = taishoku_pay;
	}

	public String getShain_no() {
		return shain_no;
	}

	public String getTaishoku_jiyu() {
		return taishoku_jiyu;
	}

	public String getTaishoku_renraku() {
		return taishoku_renraku;
	}

	public int getTaishoku_pay() {
		return taishoku_pay;
	}

	public void setShain_no(String shain_no) {
		this.shain_no = shain_no;
	}

	public void setTaishoku_jiyu(String taishoku_jiyu) {
		this.taishoku_jiyu = taishoku_jiyu;
	}

	public void setTaishoku_renraku(String taishoku_renraku) {
		this.taishoku_renraku = taishoku_renraku;
	}

	public void setTaishoku_pay(int taishoku_pay) {
		this.taishoku_pay = taishoku_pay;
	}

}