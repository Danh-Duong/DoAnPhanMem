package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.jdbcHelper;
import model.HoKhau;
import model.NhanKhau;

public class NhanKhauDAO implements DaoInterface<NhanKhau, String> {

	String insertNhanKhau = "INSERT INTO dbo.tbNhanKhau (idNhanKhau, idHoKhau, tenCongDan, cccd, ngaySinh, email, gioiTinh, sdt, diaChiThuongTru, noiOHienTai, noiSinh, quanHe, quocTich, danToc, ngheNghiep, tinhTrangCuTru, tinhTrangHocVan, tinhTrangHonNhan, ngayCapNhat, ghiChu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String updateNhanKhau = "UPDATE dbo.tbNhanKhau SET idHoKhau = ?, tenCongDan = ?, cccd = ?, ngaySinh = ?, email = ?, gioiTinh = ?, sdt = ?, diaChiThuongTru = ?, noiOHienTai = ?, noiSinh = ?, quanHe = ?, quocTich = ?, danToc = ?, ngheNghiep = ?, tinhTrangCuTru = ?, tinhTrangHocVan = ?, tinhTrangHonNhan = ?, ngayCapNhat = ?, ghiChu = ? WHERE idNhanKhau = ?";
	String deleteNhanKhau = "DELETE FROM dbo.tbNhanKhau WHERE idNhanKhau = ?";
	String selectAllNhanKhau = "SELECT * FROM dbo.tbNHANKHAU";
	String selectByIdNhanKhau = "SELECT * FROM dbo.tbNhanKhau WHERE idNhanKhau = ?";

	@Override
	public void insert(NhanKhau entity) {
		try {
			jdbcHelper.update(insertNhanKhau, entity.getIdNhanKhau(), entity.getHoKhau().getIdHoKhau(),
					entity.getTenCongDan(), entity.getCccd(), entity.getNgaySinh(), entity.getEmail(),
					entity.getGioiTinh(), entity.getSdt(), entity.getDiaChiThuongTru(), entity.getNoiOHienTai(),
					entity.getNoiSinh(), entity.getQuanHe(), entity.getQuocTich(), entity.getDanToc(),
					entity.getNgheNghiep(), entity.getTinhTrangCuTru(), entity.getTinhTrangHocVan(),
					entity.getTinhTrangHonNhan(), entity.getNgayCapNhat(), entity.getGhiChu());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int update(NhanKhau entity) {
		try {
			return jdbcHelper.update(updateNhanKhau, entity.getHoKhau().getIdHoKhau(), entity.getTenCongDan(),
					entity.getCccd(), entity.getNgaySinh(), entity.getEmail(), entity.getGioiTinh(), entity.getSdt(),
					entity.getDiaChiThuongTru(), entity.getNoiOHienTai(), entity.getNoiSinh(), entity.getQuanHe(),
					entity.getQuocTich(), entity.getDanToc(), entity.getNgheNghiep(), entity.getTinhTrangCuTru(),
					entity.getTinhTrangHocVan(), entity.getTinhTrangHonNhan(), entity.getNgayCapNhat(),
					entity.getGhiChu(), entity.getIdNhanKhau());
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int delete(String id) {
		try {
			return jdbcHelper.update(deleteNhanKhau, id);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public NhanKhau selectById(String id) {
		List<NhanKhau> list = this.selectBySQL(selectByIdNhanKhau, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<NhanKhau> selectAll() {
		return this.selectBySQL(selectAllNhanKhau);
	}

	@Override
	public List<NhanKhau> selectBySQL(String sql, Object... args) {
		List<NhanKhau> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = jdbcHelper.query(sql, args);
				while (rs.next()) {
					HoKhau hoKhau = new HoKhau();
					hoKhau.setIdHoKhau(rs.getString("idHoKhau"));
					// Assuming the HoKhau object only needs the id for now, or you can load the
					// full HoKhau object as needed.

					NhanKhau nk = new NhanKhau(rs.getString("idNhanKhau"), hoKhau, rs.getString("tenCongDan"),
							rs.getString("cccd"), rs.getDate("ngaySinh"), rs.getString("email"),
							rs.getString("gioiTinh"), rs.getString("sdt"), rs.getString("diaChiThuongTru"),
							rs.getString("noiOHienTai"), rs.getString("noiSinh"), rs.getString("quanHe"),
							rs.getString("quocTich"), rs.getString("danToc"), rs.getString("ngheNghiep"),
							rs.getString("tinhTrangCuTru"), rs.getString("tinhTrangHocVan"),
							rs.getString("tinhTrangHonNhan"), rs.getDate("ngayCapNhat"), rs.getString("ghiChu"));
					list.add(nk);
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
