package project.model.bean;

public class Zeikin {
	private int nenkin;
	private int kenko;
	private int koyo;
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
	public Zeikin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Zeikin(int nenkin, int kenko, int koyo) {
		super();
		this.nenkin = nenkin;
		this.kenko = kenko;
		this.koyo = koyo;
	}
	
	
}


