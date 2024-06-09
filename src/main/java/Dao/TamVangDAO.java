package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.jdbcHelper;
import model.NhanKhau;
import model.TamVang;

public class TamVangDAO implements DaoInterface<TamVang, String> {
	String insertTamVang = "INSERT INTO dbo.tbTamVang (maTamVang, ngayDangKi, diaChiDen, lyDo, idNhanKhau, ngayBatDau, ngayKetThuc, trangThaiDuyet) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	String updateTamVang = "UPDATE dbo.tbTamVang SET ngayDangKi = ?, diaChiDen = ?, lyDo = ?, idNhanKhau = ?, ngayBatDau = ?, ngayKetThuc = ?, trangThaiDuyet = ? WHERE maTamVang = ?";
	String deleteTamVang = "DELETE FROM dbo.tbTamVang WHERE maTamVang = ?";
	String selectAllTamVang = "SELECT * FROM dbo.tbTamVang";
	String selectByIdTamVang = "SELECT * FROM dbo.tbTamVang WHERE maTamVang = ?";

	@Override
	public void insert(TamVang entity) {
		try {
			jdbcHelper.update(insertTamVang, entity.getMaTamVang(), entity.getNgayDangKi(), entity.getDiaChiDen(),
					entity.getLyDo(), entity.getNhanKhau().getIdNhanKhau(), entity.getNgayBatDau(),
					entity.getNgayKetThuc(), entity.getTrangThaiDuyet());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int update(TamVang entity) {
		try {
			return jdbcHelper.update(updateTamVang, entity.getNgayDangKi(), entity.getDiaChiDen(), entity.getLyDo(),
					entity.getNhanKhau().getIdNhanKhau(), entity.getNgayBatDau(), entity.getNgayKetThuc(),
					entity.getTrangThaiDuyet(), entity.getMaTamVang());
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int delete(String id) {
		try {
			return jdbcHelper.update(deleteTamVang, id);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public TamVang selectById(String id) {
		List<TamVang> list = this.selectBySQL(selectByIdTamVang, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<TamVang> selectAll() {
		return this.selectBySQL(selectAllTamVang);
	}

	@Override
	public List<TamVang> selectBySQL(String sql, Object... args) {
		List<TamVang> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = jdbcHelper.query(sql, args);
				while (rs.next()) {
					NhanKhau nhanKhau = new NhanKhau();
					nhanKhau.setIdNhanKhau(rs.getString("idNhanKhau"));
					// Assuming the NhanKhau object only needs the id for now, or you can load the
					// full NhanKhau object as needed.

					TamVang tv = new TamVang(rs.getString("maTamVang"), rs.getDate("ngayDangKi"),
							rs.getString("diaChiDen"), rs.getString("lyDo"), nhanKhau, rs.getDate("ngayBatDau"),
							rs.getDate("ngayKetThuc"), rs.getString("trangThaiDuyet"));
					list.add(tv);
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
