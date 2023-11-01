package project.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ShainRequest {
	private String shain_no;
	private String shain_nm;
	private String address;
	private String busho_nm;
	private String yakushoku_nm;
	private int kihon_pay;
	private String renraku_tel;
	private String renraku_email;
	private Date nyusha_ymd;
	private Date taishoku_ymd;
	private String ginko_nm;
	private String koza_num;
	private String zaishoku_st;

	public ShainRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShainRequest(String shain_no, String shain_nm, String address, String busho_nm, String yakushoku_nm,
			int kihon_pay, String renraku_tel, String renraku_email, Date nyusha_ymd, Date taishoku_ymd,
			String ginko_nm, String koza_num, String zaishoku_st) {
		super();
		this.shain_no = shain_no;
		this.shain_nm = shain_nm;
		this.address = address;
		this.busho_nm = busho_nm;
		this.yakushoku_nm = yakushoku_nm;
		this.kihon_pay = kihon_pay;
		this.renraku_tel = renraku_tel;
		this.renraku_email = renraku_email;
		this.nyusha_ymd = nyusha_ymd;
		this.taishoku_ymd = taishoku_ymd;
		this.ginko_nm = ginko_nm;
		this.koza_num = koza_num;
		this.zaishoku_st = zaishoku_st;
	}

	public String getShain_no() {
		return shain_no;
	}

	public void setShain_no(String shain_no) {
		this.shain_no = shain_no;
	}

	public String getShain_nm() {
		return shain_nm;
	}

	public void setShain_nm(String shain_nm) {
		this.shain_nm = shain_nm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getRenraku_tel() {
		return renraku_tel;
	}

	public void setRenraku_tel(String renraku_tel) {
		this.renraku_tel = renraku_tel;
	}

	public String getRenraku_email() {
		return renraku_email;
	}

	public void setRenraku_email(String renraku_email) {
		this.renraku_email = renraku_email;
	}

	public Date getNyusha_ymd() {
		return nyusha_ymd;
	}

	public void setNyusha_ymd(Date nyusha_ymd) {
		this.nyusha_ymd = nyusha_ymd;
	}

	public Date getTaishoku_ymd() {
		return taishoku_ymd;
	}

	public void setTaishoku_ymd(Date taishoku_ymd) {
		this.taishoku_ymd = taishoku_ymd;
	}

	public String getGinko_nm() {
		return ginko_nm;
	}

	public void setGinko_nm(String ginko_nm) {
		this.ginko_nm = ginko_nm;
	}

	public String getKoza_num() {
		return koza_num;
	}

	public void setKoza_num(String koza_num) {
		this.koza_num = koza_num;
	}

	public String getZaishoku_st() {
		return zaishoku_st;
	}

	public void setZaishoku_st(String zaishoku_st) {
		this.zaishoku_st = zaishoku_st;
	}

}
