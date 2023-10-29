package project.model.bean;

public class KyuyoList {
	private String kizoku_ym;
	private int pay_cnt;
	private int sousikyu;
	private int soukojyo;
	public String getKizoku_ym() {
		return kizoku_ym;
	}
	public void setKizoku_ym(String kizoku_ym) {
		this.kizoku_ym = kizoku_ym;
	}
	public int getPay_cnt() {
		return pay_cnt;
	}
	public void setPay_cnt(int pay_cnt) {
		this.pay_cnt = pay_cnt;
	}
	public int getSousikyu() {
		return sousikyu;
	}
	public void setSousikyu(int sousikyu) {
		this.sousikyu = sousikyu;
	}
	public int getSoukojyo() {
		return soukojyo;
	}
	public void setSoukojyo(int soukojyo) {
		this.soukojyo = soukojyo;
	}
	public KyuyoList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KyuyoList(String kizoku_ym, int pay_cnt, int sousikyu, int soukojyo) {
		super();
		this.kizoku_ym = kizoku_ym;
		this.pay_cnt = pay_cnt;
		this.sousikyu = sousikyu;
		this.soukojyo = soukojyo;
	}
	
	
}
