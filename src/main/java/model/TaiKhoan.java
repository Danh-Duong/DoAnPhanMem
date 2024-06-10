package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaiKhoan {
	private String cccd;
	private String matKhau;
	private String maQuyen;
	private boolean trangThai;
	private Date ngayCap;
	private String hoten;
	private String email;
	private String ngayCapStr;
	
	
	public TaiKhoan(String cccd, String matKhau, String maQuyen, boolean trangThai, Date ngayCap, String hoten,
			String email) {
		super();
		this.cccd = cccd;
		this.matKhau = matKhau;
		this.maQuyen = maQuyen;
		this.trangThai = trangThai;
		this.ngayCap = ngayCap;
		this.hoten = hoten;
		this.email = email;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.ngayCapStr = sdf.format(ngayCap);
	}
	
	
	public String getNgayCapStr() {
		return ngayCapStr;
	}


	public void setNgayCapStr(String ngayCapStr) {
		this.ngayCapStr = ngayCapStr;
	}


	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayCap() {
		return ngayCap;
	}
	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
