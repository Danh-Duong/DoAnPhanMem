package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanKhau {
	private String idNhanKhau;
	private String idHoKhau;
	private String tenCongDan;
	private String cccd;
	private Date ngaySinh;
	private String ngaySinhStr;
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
	private String image;

	public NhanKhau() {

	}

	public NhanKhau(String idNhanKhau, String idHoKhau, String tenCongDan, String cccd, String noiOHienTai,
			String quocTich, String danToc) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.idHoKhau = idHoKhau;
		this.tenCongDan = tenCongDan;
		this.cccd = cccd;
		this.noiOHienTai = noiOHienTai;
		this.quocTich = quocTich;
		this.danToc = danToc;
	}

	public NhanKhau(String idNhanKhau, String idHoKhau, String tenCongDan, String cccd, Date ngaySinh, String gioiTinh,
			String noiOHienTai, String noiSinh, String quanHe, String quocTich, String danToc, String ngheNghiep,
			String tinhTrangHocVan, String tinhTrangHonNhan, String image) {
		super();
		this.idHoKhau = idHoKhau;
		this.tenCongDan = tenCongDan;
		this.cccd = cccd;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.noiOHienTai = noiOHienTai;
		this.noiSinh = noiSinh;
		this.quanHe = quanHe;
		this.quocTich = quocTich;
		this.danToc = danToc;
		this.ngheNghiep = ngheNghiep;
		this.tinhTrangHocVan = tinhTrangHocVan;
		this.tinhTrangHonNhan = tinhTrangHonNhan;
		this.image = image;
		this.idNhanKhau = idNhanKhau;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNgaySinhStr() {
		return ngaySinhStr;
	}

	public void setNgaySinhStr(String ngaySinhStr) {
		this.ngaySinhStr = ngaySinhStr;
	}

	public NhanKhau(String idNhanKhau, String tenCongDan, String cccd, Date ngaySinh, String gioiTinh) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.tenCongDan = tenCongDan;
		this.cccd = cccd;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.ngaySinhStr = sdf.format(ngaySinh);
	}

	public String getIdNhanKhau() {
		return idNhanKhau;
	}

	public void setIdNhanKhau(String idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}

	public String getIdHoKhau() {
		return idHoKhau;
	}

	public void setIdHoKhau(String idHoKhau) {
		this.idHoKhau = idHoKhau;
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

	@Override
	public String toString() {
		return "NhanKhau [idNhanKhau=" + idNhanKhau + ", idHoKhau=" + idHoKhau + ", tenCongDan=" + tenCongDan
				+ ", cccd=" + cccd + ", ngaySinh=" + ngaySinh + ", ngaySinhStr=" + ngaySinhStr + ", email=" + email
				+ ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", diaChiThuongTru=" + diaChiThuongTru + ", noiOHienTai="
				+ noiOHienTai + ", noiSinh=" + noiSinh + ", quanHe=" + quanHe + ", quocTich=" + quocTich + ", danToc="
				+ danToc + ", ngheNghiep=" + ngheNghiep + ", tinhTrangCuTru=" + tinhTrangCuTru + ", tinhTrangHocVan="
				+ tinhTrangHocVan + ", tinhTrangHonNhan=" + tinhTrangHonNhan + ", ngayCapNhat=" + ngayCapNhat
				+ ", ghiChu=" + ghiChu + ", image=" + image + ", getImage()=" + getImage() + ", getNgaySinhStr()="
				+ getNgaySinhStr() + ", getIdNhanKhau()=" + getIdNhanKhau() + ", getIdHoKhau()=" + getIdHoKhau()
				+ ", getTenCongDan()=" + getTenCongDan() + ", getCccd()=" + getCccd() + ", getNgaySinh()="
				+ getNgaySinh() + ", getEmail()=" + getEmail() + ", getGioiTinh()=" + getGioiTinh() + ", getSdt()="
				+ getSdt() + ", getDiaChiThuongTru()=" + getDiaChiThuongTru() + ", getNoiOHienTai()=" + getNoiOHienTai()
				+ ", getNoiSinh()=" + getNoiSinh() + ", getQuanHe()=" + getQuanHe() + ", getQuocTich()=" + getQuocTich()
				+ ", getDanToc()=" + getDanToc() + ", getNgheNghiep()=" + getNgheNghiep() + ", getTinhTrangCuTru()="
				+ getTinhTrangCuTru() + ", getTinhTrangHocVan()=" + getTinhTrangHocVan() + ", getTinhTrangHonNhan()="
				+ getTinhTrangHonNhan() + ", getNgayCapNhat()=" + getNgayCapNhat() + ", getGhiChu()=" + getGhiChu()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
