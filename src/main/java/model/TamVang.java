package model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tbTAMVANG")
public class TamVang {

	@Id
	@Column(name = "maTamVang")
	private String maTamVang;

	@Column(name = "ngayDangKi")
	private Date ngayDangKi;

	@Column(name = "diaChiDen")
	private String diaChiDen;

	@Column(name = "lyDo")
	private String lyDo;

	@ManyToOne
	@JoinColumn(name = "idNhanKhau")
	private NhanKhau nhanKhau;

	@Column(name = "ngayBatDau")
	private Date ngayBatDau;

	@Column(name = "ngayKetThuc")
	private Date ngayKetThuc;

	@Column(name = "trangThaiDuyet")
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
