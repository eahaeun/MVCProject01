package project.model.bean;

public class Busho {

	private String busho_nm;
	private String tanto_nm;
	private String busho_renraku;

	public Busho() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Busho(String busho_nm, String tanto_nm, String busho_renraku) {
		super();
		this.busho_nm = busho_nm;
		this.tanto_nm = tanto_nm;
		this.busho_renraku = busho_renraku;
	}

	public String getBusho_nm() {
		return busho_nm;
	}

	public String getTanto_nm() {
		return tanto_nm;
	}

	public String getBusho_renraku() {
		return busho_renraku;
	}

	public void setBusho_nm(String busho_nm) {
		this.busho_nm = busho_nm;
	}

	public void setTanto_nm(String tanto_nm) {
		this.tanto_nm = tanto_nm;
	}

	public void setBusho_renraku(String busho_renraku) {
		this.busho_renraku = busho_renraku;
	}

}
