package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.KhaiTu;

public class KhaiTuRepository {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean saveKhaiTu(KhaiTu khaitu) {
		String query = "INSERT tbKHAITU VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?,?,?,?,?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, khaitu.getMaKhaiTu());
			ps.setString(2, khaitu.getIdNhanKhau());
			ps.setString(3, khaitu.getHoTenNguoiKhai());
			ps.setString(4, khaitu.getNoiCuTruNguoiKhai());
			ps.setString(5, khaitu.getHoTenNguoiMat());
			java.sql.Date sqlNgaysinh = new java.sql.Date(khaitu.getNgaySinh().getTime());
	        ps.setDate(6, sqlNgaysinh);
	        ps.setString(7, khaitu.getNoiSinh());
			ps.setString(8, khaitu.getGioiTinh());
			ps.setString(9, khaitu.getQuocTich());
			ps.setString(10, khaitu.getDanToc());
			ps.setString(11, khaitu.getNoiCuTruCuoiCung());
			java.sql.Date sqlNgaymat = new java.sql.Date(khaitu.getNgayMat().getTime());
	        ps.setDate(12, sqlNgaymat);
	        Time sqlGioMat = Time.valueOf(khaitu.getGioMat());
	        ps.setTime(13,sqlGioMat);
			ps.setString(14, khaitu.getNguyenNhan());
			ps.setString(15, khaitu.getNoiDangKi());
			java.sql.Date sqlNgayDK = new java.sql.Date(khaitu.getNgayDangKi().getTime());
	        ps.setDate(16, sqlNgayDK);
	        ps.setString(17, khaitu.getQuanHeVoiNguoiMat());
			ps.setString(18, "Chờ xét duyệt");

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public String getNewMaKhaiTu() {
		String query = "select top 1 maKhaiTu\r\n"
				+ "from tbKHAITU\r\n"
				+ "order by maKhaiTu desc";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				String maks=rs.getString(1);
				int somaks = Integer.parseInt(maks.substring(2))+1;
				DecimalFormat format =  new DecimalFormat("0000");
				return "KT" + format.format(somaks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public List<KhaiTu> getDanhsachHosoKhaiTu() {
		String query = "select * from tbKHAITU where trangThaiDuyet=N'Chờ duyệt'";
		List<KhaiTu> result = new ArrayList<KhaiTu>();
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new KhaiTu(rs.getString(1), rs.getString(2)));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public KhaiTu getHosoById(String mahs) {
		String query = "select * from tbKHAITU where maKhaiTu=N'"+mahs+"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new KhaiTu(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						new java.util.Date(rs.getDate(6).getTime()),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						new java.util.Date(rs.getDate(12).getTime()),
						rs.getTime(13).toLocalTime(),
						rs.getString(14),
						rs.getString(15),
						new java.util.Date(rs.getDate(16).getTime()),
						rs.getString(17),
						rs.getString(18));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public boolean updateTrangthai(String mahs) {
		String query = "update tbKHAITU set trangThaiDuyet = N'Đã duyệt' where maKhaiTu=N'" + mahs+"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}