package model;

import java.util.Date;

public class TamVang {

	private String maTamVang;

	private Date ngayDangKi;

	private String diaChiDen;
	private String lyDo;
	private NhanKhau nhanKhau;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private String trangThaiDuyet;

	public String getMaTamVang() {
		return maTamVang;
	}

	public void setMaTamVang(String maTamVang) {
		this.maTamVang = maTamVang;
	}

	public Date getNgayDangKi() {
		return ngayDangKi;
	}

	public void setNgayDangKi(Date ngayDangKi) {
		this.ngayDangKi = ngayDangKi;
	}

	public String getDiaChiDen() {
		return diaChiDen;
	}

	public void setDiaChiDen(String diaChiDen) {
		this.diaChiDen = diaChiDen;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public NhanKhau getNhanKhau() {
		return nhanKhau;
	}

	public void setNhanKhau(NhanKhau nhanKhau) {
		this.nhanKhau = nhanKhau;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getTrangThaiDuyet() {
		return trangThaiDuyet;
	}

	public void setTrangThaiDuyet(String trangThaiDuyet) {
		this.trangThaiDuyet = trangThaiDuyet;
	}

	public TamVang(String maTamVang, Date ngayDangKi, String diaChiDen, String lyDo, NhanKhau nhanKhau, Date ngayBatDau,
			Date ngayKetThuc, String trangThaiDuyet) {
		this.maTamVang = maTamVang;
		this.ngayDangKi = ngayDangKi;
		this.diaChiDen = diaChiDen;
		this.lyDo = lyDo;
		this.nhanKhau = nhanKhau;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThaiDuyet = trangThaiDuyet;
	}

	public TamVang() {

	}
}
