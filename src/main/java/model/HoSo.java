package model;

import java.util.Date;

public class HoSo {
	private String mahs;
	private String loaihs;
	private Date ngaydangky;
	private String trangthai;
	
	public HoSo(String mahs, String loaihs, Date ngaydangky, String trangthai) {
		super();
		this.mahs = mahs;
		this.loaihs = loaihs;
		this.ngaydangky = ngaydangky;
		this.trangthai = trangthai;
	}
	
	public String getMahs() {
		return mahs;
	}
	public void setMahs(String mahs) {
		this.mahs = mahs;
	}
	public String getLoaihs() {
		return loaihs;
	}
	public void setLoaihs(String loaihs) {
		this.loaihs = loaihs;
	}
	public Date getNgaydangky() {
		return ngaydangky;
	}
	public void setNgaydangky(Date ngaydangky) {
		this.ngaydangky = ngaydangky;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	
}
