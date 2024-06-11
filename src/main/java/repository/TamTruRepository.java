package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.TamTru;

public class TamTruRepository {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Integer> getNumberByYear(int year) {
        List<Integer> result = new ArrayList<Integer>();
        String query = "SELECT "
                + "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 1 AND 3 THEN 1 END) AS count_Q1, "
                + "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 4 AND 6 THEN 1 END) AS count_Q2, "
                + "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 7 AND 9 THEN 1 END) AS count_Q3, "
                + "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 10 AND 12 THEN 1 END) AS count_Q4 "
                + "FROM tbTAMTRU "
                + "WHERE YEAR(ngayDangKi) = " + year;
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = Arrays.asList(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TamTru> getDanhsachHoso(String tt) {
        List<TamTru> danhSachHoso = new ArrayList<>();
        String query = "SELECT * FROM tbTAMTRU WHERE trangThaiDuyet = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tt);
            rs = ps.executeQuery();
            while (rs.next()) {
                TamTru tamTru = new TamTru();
                    tamTru.setId(rs.getInt("id"));
                    /*tamTru.setIdNhanKhau(rs.getInt("idNhanKhau"));*/
                tamTru.setNgayBatDau(rs.getDate("ngayBatDau"));
                tamTru.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                tamTru.setNgayDangKi(rs.getDate("ngayDangKi"));
                tamTru.setTrangThaiDuyet(rs.getString("trangThaiDuyet"));
                danhSachHoso.add(tamTru);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return danhSachHoso;
    }

    public TamTru getHosoById(String mahs) {
        TamTru tamTru = null;
        String query = "SELECT * FROM tbTAMTRU WHERE id = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mahs);
            rs = ps.executeQuery();
            if (rs.next()) {
                tamTru = new TamTru();
                tamTru.setId(rs.getInt("id"));
                tamTru.setIdNhanKhau(rs.getString("idNhanKhau"));
                tamTru.setNgayBatDau(rs.getDate("ngayBatDau"));
                tamTru.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                tamTru.setNgayDangKi(rs.getDate("ngayDangKi"));
                tamTru.setTrangThaiDuyet(rs.getString("trangThaiDuyet"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return tamTru;
    }

    public void updateTrangthai(String mahs, String trangthai) {
        String query = "UPDATE tbTAMTRU SET trangThaiDuyet = ? WHERE id = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, trangthai);
            ps.setString(2, mahs);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public String getNewMaTamTru() {
        // Implement method to generate new MaTamTru if needed
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    public void saveTamTru(TamTru tamTru) {
        // Implement method to save a new TamTru record if needed
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
