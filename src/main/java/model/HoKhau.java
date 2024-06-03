package model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tbHOKHAU")
public class HoKhau {

    @Id
    @Column(name = "idHoKhau")
    private String idHoKhau;

    @Column(name = "diaChiThuongTru")
    private String diaChiThuongTru;

    @Column(name = "ngayDangKi")
    private Date ngayDangKi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "ghiChu", columnDefinition = "nvarchar(MAX)")
    private String ghiChu;

	public String getIdHoKhau() {
		return idHoKhau;
	}

	public void setIdHoKhau(String idHoKhau) {
		this.idHoKhau = idHoKhau;
	}

	public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	}

	public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	}

	public Date getNgayDangKi() {
		return ngayDangKi;
	}

	public void setNgayDangKi(Date ngayDangKi) {
		this.ngayDangKi = ngayDangKi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public HoKhau(String idHoKhau, String diaChiThuongTru, Date ngayDangKi, String trangThai, int soLuong,
			String ghiChu) {
		this.idHoKhau = idHoKhau;
		this.diaChiThuongTru = diaChiThuongTru;
		this.ngayDangKi = ngayDangKi;
		this.trangThai = trangThai;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
	}
	public HoKhau() {
	}
	@Override
	public String toString() {
		return getIdHoKhau();
	}
	
}

