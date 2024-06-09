package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.jdbcHelper;
import model.HoKhau;

public class HoKhauDAO implements DaoInterface<HoKhau, String> {
	String insertHoKhau = "INSERT INTO dbo.tbHoKhau (idHoKhau, diaChiThuongTru, ngayDangKi, trangThai, soLuong, ghiChu) VALUES (?, ?, ?, ?, ?, ?)";
	String updateHoKhau = "UPDATE dbo.tbHoKhau SET diaChiThuongTru = ?, ngayDangKi = ?, trangThai = ?, soLuong = ?, ghiChu = ? WHERE idHoKhau = ?";
	String deleteHoKhau = "DELETE FROM dbo.tbHoKhau WHERE idHoKhau = ?";
	String selectAllHoKhau = "SELECT * FROM dbo.tbHoKhau";
	String selectByIdHoKhau = "SELECT * FROM dbo.tbHoKhau WHERE idHoKhau = ?";

	@Override
	public void insert(HoKhau entity) {
	    try {
	        jdbcHelper.update(insertHoKhau, entity.getIdHoKhau(), entity.getDiaChiThuongTru(), entity.getNgayDangKi(), entity.getTrangThai(), entity.getSoLuong(), entity.getGhiChu());
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	}

	@Override
	public int update(HoKhau entity) {
	    try {
	        return jdbcHelper.update(updateHoKhau, entity.getDiaChiThuongTru(), entity.getNgayDangKi(), entity.getTrangThai(), entity.getSoLuong(), entity.getGhiChu(), entity.getIdHoKhau());
	    } catch (Exception e) {
	        return 0;
	    }
	}

	@Override
	public int delete(String id) {
	    try {
	        return jdbcHelper.update(deleteHoKhau, id);
	    } catch (Exception e) {
	        return 0;
	    }
	}

	@Override
	public HoKhau selectById(String id) {
	    List<HoKhau> list = this.selectBySQL(selectByIdHoKhau, id);
	    return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<HoKhau> selectAll() {
	    return this.selectBySQL(selectAllHoKhau);
	}

	@Override
	public List<HoKhau> selectBySQL(String sql, Object... arr) {
	    List<HoKhau> list = new ArrayList<>();
	    try {
	        ResultSet rs = null;
	        try {
	            rs = jdbcHelper.query(sql, arr);
	            while (rs.next()) {
	                HoKhau hk = new HoKhau(rs.getString("idHoKhau"), 
	                                        rs.getString("diaChiThuongTru"), 
	                                        rs.getDate("ngayDangKi"), 
	                                        rs.getString("trangThai"), 
	                                        rs.getInt("soLuong"), 
	                                        rs.getString("ghiChu"));
	                list.add(hk);
	            }
	        } finally {
	            if (rs != null) {
	                rs.getStatement().getConnection().close();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	
}
