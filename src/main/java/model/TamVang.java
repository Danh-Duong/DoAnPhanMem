package model;

import java.util.Date;

public class TamVang {
    private String maTamVang;
    private Date ngayDangKi;
    private String diaChiDen;
    private String lyDo;
    private String idNhanKhau;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String trangThaiDuyet;
    private String cccdNdk;
	public String getCccdNdk() {
		return cccdNdk;
	}

	public void setCccdNdk(String cccdNdk) {
		this.cccdNdk = cccdNdk;
	}

	public TamVang(String maTamVang, Date ngayDangKi, String diaChiDen, String lyDo, String idNhanKhau, Date ngayBatDau,
			Date ngayKetThuc, String trangThaiDuyet, String cccdNdk) {
		super();
		this.maTamVang = maTamVang;
		this.ngayDangKi = ngayDangKi;
		this.diaChiDen = diaChiDen;
		this.lyDo = lyDo;
		this.idNhanKhau = idNhanKhau;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThaiDuyet = trangThaiDuyet;
		this.cccdNdk=cccdNdk;
	}
	
	public TamVang(String maTamVang, Date ngayDangKi, String lyDo, String idNhanKhau) {
		super();
		this.maTamVang = maTamVang;
		this.ngayDangKi = ngayDangKi;
		this.lyDo = lyDo;
		this.idNhanKhau = idNhanKhau;
	}


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
	public String getIdNhanKhau() {
		return idNhanKhau;
	}
	public void setIdNhanKhau(String idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
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
    
}
