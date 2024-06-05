package model;

import java.sql.Time;
import java.util.Date;

public class KhaiTu {
    private String maKhaiTu;
    private String idNhanKhau;
    private String hoTenNguoiKhai;
    private String noiCuTruNguoiKhai;
    private String hoTenNguoiMat;
    private Date ngaySinh;
    private String noiSinh;
    private String gioiTinh;
    private String quocTich;
    private String danToc;
    private String noiCuTruCuoiCung;
    private Date ngayMat;
    private Time gioMat;
    private String nguyenNhan;
    private String noiDangKi;
    private Date ngayDangKi;
    private String quanHeVoiNguoiMat;
    private String trangThaiDuyet;
    
    
    
	public KhaiTu(String maKhaiTu, String idNhanKhau, String hoTenNguoiKhai, String noiCuTruNguoiKhai,
			String hoTenNguoiMat, Date ngaySinh, String noiSinh, String gioiTinh, String quocTich, String danToc,
			String noiCuTruCuoiCung, Date ngayMat, Time gioMat, String nguyenNhan, String noiDangKi, Date ngayDangKi,
			String quanHeVoiNguoiMat, String trangThaiDuyet) {
		super();
		this.maKhaiTu = maKhaiTu;
		this.idNhanKhau = idNhanKhau;
		this.hoTenNguoiKhai = hoTenNguoiKhai;
		this.noiCuTruNguoiKhai = noiCuTruNguoiKhai;
		this.hoTenNguoiMat = hoTenNguoiMat;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.gioiTinh = gioiTinh;
		this.quocTich = quocTich;
		this.danToc = danToc;
		this.noiCuTruCuoiCung = noiCuTruCuoiCung;
		this.ngayMat = ngayMat;
		this.gioMat = gioMat;
		this.nguyenNhan = nguyenNhan;
		this.noiDangKi = noiDangKi;
		this.ngayDangKi = ngayDangKi;
		this.quanHeVoiNguoiMat = quanHeVoiNguoiMat;
		this.trangThaiDuyet = trangThaiDuyet;
	}
	public KhaiTu() {
		
	}
	public KhaiTu(String maKhaiTu, String idNhanKhau) {
		super();
		this.maKhaiTu = maKhaiTu;
		this.idNhanKhau = idNhanKhau;
	}

	public String getMaKhaiTu() {
		return maKhaiTu;
	}
	public void setMaKhaiTu(String maKhaiTu) {
		this.maKhaiTu = maKhaiTu;
	}
	public String getIdNhanKhau() {
		return idNhanKhau;
	}
	public void setIdNhanKhau(String idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}
	public String getHoTenNguoiKhai() {
		return hoTenNguoiKhai;
	}
	public void setHoTenNguoiKhai(String hoTenNguoiKhai) {
		this.hoTenNguoiKhai = hoTenNguoiKhai;
	}
	public String getNoiCuTruNguoiKhai() {
		return noiCuTruNguoiKhai;
	}
	public void setNoiCuTruNguoiKhai(String noiCuTruNguoiKhai) {
		this.noiCuTruNguoiKhai = noiCuTruNguoiKhai;
	}
	public String getHoTenNguoiMat() {
		return hoTenNguoiMat;
	}
	public void setHoTenNguoiMat(String hoTenNguoiMat) {
		this.hoTenNguoiMat = hoTenNguoiMat;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getNoiSinh() {
		return noiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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
	public String getNoiCuTruCuoiCung() {
		return noiCuTruCuoiCung;
	}
	public void setNoiCuTruCuoiCung(String noiCuTruCuoiCung) {
		this.noiCuTruCuoiCung = noiCuTruCuoiCung;
	}
	public Date getNgayMat() {
		return ngayMat;
	}
	public void setNgayMat(Date ngayMat) {
		this.ngayMat = ngayMat;
	}
	public Time getGioMat() {
		return gioMat;
	}
	public void setGioMat(Time gioMat) {
		this.gioMat = gioMat;
	}
	public String getNguyenNhan() {
		return nguyenNhan;
	}
	public void setNguyenNhan(String nguyenNhan) {
		this.nguyenNhan = nguyenNhan;
	}
	public String getNoiDangKi() {
		return noiDangKi;
	}
	public void setNoiDangKi(String noiDangKi) {
		this.noiDangKi = noiDangKi;
	}
	public Date getNgayDangKi() {
		return ngayDangKi;
	}
	public void setNgayDangKi(Date ngayDangKi) {
		this.ngayDangKi = ngayDangKi;
	}
	public String getQuanHeVoiNguoiMat() {
		return quanHeVoiNguoiMat;
	}
	public void setQuanHeVoiNguoiMat(String quanHeVoiNguoiMat) {
		this.quanHeVoiNguoiMat = quanHeVoiNguoiMat;
	}
	public String getTrangThaiDuyet() {
		return trangThaiDuyet;
	}
	public void setTrangThaiDuyet(String trangThaiDuyet) {
		this.trangThaiDuyet = trangThaiDuyet;
	}
	@Override
	public String toString() {
		return "KhaiTu [maKhaiTu=" + maKhaiTu + ", idNhanKhau=" + idNhanKhau + ", hoTenNguoiKhai=" + hoTenNguoiKhai
				+ ", noiCuTruNguoiKhai=" + noiCuTruNguoiKhai + ", hoTenNguoiMat=" + hoTenNguoiMat + ", ngaySinh="
				+ ngaySinh + ", noiSinh=" + noiSinh + ", gioiTinh=" + gioiTinh + ", quocTich=" + quocTich + ", danToc="
				+ danToc + ", noiCuTruCuoiCung=" + noiCuTruCuoiCung + ", ngayMat=" + ngayMat + ", gioMat=" + gioMat
				+ ", nguyenNhan=" + nguyenNhan + ", noiDangKi=" + noiDangKi + ", ngayDangKi=" + ngayDangKi
				+ ", quanHeVoiNguoiMat=" + quanHeVoiNguoiMat + ", trangThaiDuyet=" + trangThaiDuyet + "]";
	}
    
    
    
    
}