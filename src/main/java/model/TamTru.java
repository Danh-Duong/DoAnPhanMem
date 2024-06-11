package model;

import java.util.Date;

public class TamTru {
    private String maTamTru;
    private String idNhanKhau;
    private String lyDo;
    private String diaChiDangKi;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Date ngayDangKi;
    private String ghiChu;

    // Constructor
    public TamTru(String maTamTru, Date ngayDangKi, String diaChiDangKi, String lyDo, String idNhanKhau, Date ngayBatDau, Date ngayKetThuc, String ghiChu) {
        this.maTamTru = maTamTru;
        this.ngayDangKi = ngayDangKi;
        this.diaChiDangKi = diaChiDangKi;
        this.lyDo = lyDo;
        this.idNhanKhau = idNhanKhau;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.ghiChu = ghiChu;
    }

    public TamTru() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getMaTamTru() {
        return maTamTru;
    }

    public void setMaTamTru(String maTamTru) {
        this.maTamTru = maTamTru;
    }

    public String getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(String idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getDiaChiDangKi() {
        return diaChiDangKi;
    }

    public void setDiaChiDangKi(String diaChiDangKi) {
        this.diaChiDangKi = diaChiDangKi;
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

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Object getTrangThaiDuyet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTrangThaiDuyet(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
