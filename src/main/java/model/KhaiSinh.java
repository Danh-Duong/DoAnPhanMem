package model;

import java.util.Date;

public class KhaiSinh {
    private String maDangKiKhaiSinh;
    private String idHoKhau;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String quocTich;
    private String danToc;
    private String noiSinh;
    private String queQuan;
    private String noiCuTru;
    private String idNhanKhauCha;
    private String idNhanKhauMe;
    private String quanHeNguoiKhaiSinh;
    private String trangThaiDuyet;
    
    public KhaiSinh() {
    	
    }
    
    
	public KhaiSinh(String maDangKiKhaiSinh, String idHoKhau, String hoTen, Date ngaySinh, String gioiTinh,
			String quocTich, String danToc, String noiSinh, String queQuan, String noiCuTru, String idNhanKhauCha,
			String idNhanKhauMe, String quanHeNguoiKhaiSinh, String trangthai) {
		super();
		this.maDangKiKhaiSinh = maDangKiKhaiSinh;
		this.idHoKhau = idHoKhau;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.quocTich = quocTich;
		this.danToc = danToc;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.noiCuTru = noiCuTru;
		this.idNhanKhauCha = idNhanKhauCha;
		this.idNhanKhauMe = idNhanKhauMe;
		this.quanHeNguoiKhaiSinh = quanHeNguoiKhaiSinh;
		this.trangThaiDuyet=trangthai;
	}


	public KhaiSinh(String maDangKiKhaiSinh, String idHoKhau) {
		super();
		this.maDangKiKhaiSinh = maDangKiKhaiSinh;
		this.idHoKhau = idHoKhau;
	}


	public String getMaDangKiKhaiSinh() {
		return maDangKiKhaiSinh;
	}
	public void setMaDangKiKhaiSinh(String maDangKiKhaiSinh) {
		this.maDangKiKhaiSinh = maDangKiKhaiSinh;
	}
	public String getIdHoKhau() {
		return idHoKhau;
	}
	public void setIdHoKhau(String idHoKhau) {
		this.idHoKhau = idHoKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
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
	public String getNoiSinh() {
		return noiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getNoiCuTru() {
		return noiCuTru;
	}
	public void setNoiCuTru(String noiCuTru) {
		this.noiCuTru = noiCuTru;
	}
	public String getIdNhanKhauCha() {
		return idNhanKhauCha;
	}
	public void setIdNhanKhauCha(String idNhanKhauCha) {
		this.idNhanKhauCha = idNhanKhauCha;
	}
	public String getIdNhanKhauMe() {
		return idNhanKhauMe;
	}
	public void setIdNhanKhauMe(String idNhanKhauMe) {
		this.idNhanKhauMe = idNhanKhauMe;
	}
	public String getQuanHeNguoiKhaiSinh() {
		return quanHeNguoiKhaiSinh;
	}
	public void setQuanHeNguoiKhaiSinh(String quanHeNguoiKhaiSinh) {
		this.quanHeNguoiKhaiSinh = quanHeNguoiKhaiSinh;
	}
	public String getTrangThaiDuyet() {
		return trangThaiDuyet;
	}
	public void setTrangThaiDuyet(String trangThaiDuyet) {
		this.trangThaiDuyet = trangThaiDuyet;
	}


	@Override
	public String toString() {
		return "KhaiSinh [maDangKiKhaiSinh=" + maDangKiKhaiSinh + ", idHoKhau=" + idHoKhau + ", hoTen=" + hoTen
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", quocTich=" + quocTich + ", danToc=" + danToc
				+ ", noiSinh=" + noiSinh + ", queQuan=" + queQuan + ", noiCuTru=" + noiCuTru + ", idNhanKhauCha="
				+ idNhanKhauCha + ", idNhanKhauMe=" + idNhanKhauMe + ", quanHeNguoiKhaiSinh=" + quanHeNguoiKhaiSinh
				+ ", trangThaiDuyet=" + trangThaiDuyet + "]";
	}
    
    
}
