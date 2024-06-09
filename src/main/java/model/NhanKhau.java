package model;

import java.util.Date;

public class NhanKhau {

	private String idNhanKhau;

	private HoKhau hoKhau;

	private String tenCongDan;

	private String cccd;

	private Date ngaySinh;

	private String email;

	private String gioiTinh;

	private String sdt;

	private String diaChiThuongTru;

	private String noiOHienTai;

	private String noiSinh;

	private String quanHe;

	private String quocTich;

	private String danToc;

	private String ngheNghiep;

	private String tinhTrangCuTru;

	private String tinhTrangHocVan;

	private String tinhTrangHonNhan;

	private Date ngayCapNhat;

	private String ghiChu;

	public NhanKhau() {

	}

	public String getIdNhanKhau() {
		return idNhanKhau;
	}

	public void setIdNhanKhau(String idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}

	public HoKhau getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(HoKhau hoKhau) {
		this.hoKhau = hoKhau;
	}

	public String getTenCongDan() {
		return tenCongDan;
	}

	public void setTenCongDan(String tenCongDan) {
		this.tenCongDan = tenCongDan;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	}

	public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	}

	public String getNoiOHienTai() {
		return noiOHienTai;
	}

	public void setNoiOHienTai(String noiOHienTai) {
		this.noiOHienTai = noiOHienTai;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getQuanHe() {
		return quanHe;
	}

	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getTinhTrangCuTru() {
		return tinhTrangCuTru;
	}

	public void setTinhTrangCuTru(String tinhTrangCuTru) {
		this.tinhTrangCuTru = tinhTrangCuTru;
	}

	public String getTinhTrangHocVan() {
		return tinhTrangHocVan;
	}

	public void setTinhTrangHocVan(String tinhTrangHocVan) {
		this.tinhTrangHocVan = tinhTrangHocVan;
	}

	public String getTinhTrangHonNhan() {
		return tinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(String tinhTrangHonNhan) {
		this.tinhTrangHonNhan = tinhTrangHonNhan;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public NhanKhau(String idNhanKhau, HoKhau hoKhau, String tenCongDan, String cccd, Date ngaySinh, String email,
			String gioiTinh, String sdt, String diaChiThuongTru, String noiOHienTai, String noiSinh, String quanHe,
			String quocTich, String danToc, String ngheNghiep, String tinhTrangCuTru, String tinhTrangHocVan,
			String tinhTrangHonNhan, Date ngayCapNhat, String ghiChu) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.hoKhau = hoKhau;
		this.tenCongDan = tenCongDan;
		this.cccd = cccd;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.diaChiThuongTru = diaChiThuongTru;
		this.noiOHienTai = noiOHienTai;
		this.noiSinh = noiSinh;
		this.quanHe = quanHe;
		this.quocTich = quocTich;
		this.danToc = danToc;
		this.ngheNghiep = ngheNghiep;
		this.tinhTrangCuTru = tinhTrangCuTru;
		this.tinhTrangHocVan = tinhTrangHocVan;
		this.tinhTrangHonNhan = tinhTrangHonNhan;
		this.ngayCapNhat = ngayCapNhat;
		this.ghiChu = ghiChu;
	}

}
