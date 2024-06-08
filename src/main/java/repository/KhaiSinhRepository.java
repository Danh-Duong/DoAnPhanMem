package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.KhaiSinh;

public class KhaiSinhRepository {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean saveKhaiSinh(KhaiSinh khaisinh) {
		String query = "INSERT tbKHAISINH VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, khaisinh.getMaDangKiKhaiSinh());
			ps.setString(2, khaisinh.getIdHoKhau());
			ps.setString(3, khaisinh.getNguoiDangKy());
			ps.setDate(4, new java.sql.Date(khaisinh.getNgayDangKy().getTime()));
			ps.setString(5, khaisinh.getHoTen());
			java.sql.Date sqlDate = new java.sql.Date(khaisinh.getNgaySinh().getTime());
	        ps.setDate(6, sqlDate);
			ps.setString(7, khaisinh.getGioiTinh());
			ps.setString(8, khaisinh.getQuocTich());
			ps.setString(9, khaisinh.getDanToc());
			ps.setString(10, khaisinh.getNoiSinh());
			ps.setString(11, khaisinh.getQueQuan());
			ps.setString(12, "Đà Nẵng");
			ps.setString(13, khaisinh.getIdNhanKhauCha());
			ps.setString(14, khaisinh.getIdNhanKhauMe());
			ps.setString(15, khaisinh.getQuanHeNguoiKhaiSinh());
			ps.setString(16, "Chờ xét duyệt");

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public String getNewMaKhaiSinh() {
		String query = "select top 1 maDangKiKhaiSinh\r\n"
				+ "from tbKHAISINH\r\n"
				+ "order by maDangKiKhaiSinh desc";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				String maks=rs.getString(1);
				int somaks = Integer.parseInt(maks.substring(2))+1;
//				String formattedNumber = String.format("%04d", somaks);
				DecimalFormat format =  new DecimalFormat("0000");
				return "KS" + format.format(somaks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public List<KhaiSinh> getDanhsachHoso(String trangthai) {
		String query = "select * from tbKHAISINH where trangThaiDuyet=N'"+ trangthai + "'";
		List<KhaiSinh> result = new ArrayList<KhaiSinh>();
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new KhaiSinh(rs.getString(1), rs.getString(2), rs.getString(3), new java.util.Date(rs.getDate(4).getTime()) ));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public KhaiSinh getHosoById(String mahs) {
		String query = "select * from tbKHAISINH where maDangKiKhaiSinh=N'"+mahs+"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new KhaiSinh(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						new java.util.Date(rs.getDate(4).getTime()),
						rs.getString(5),
						new java.util.Date(rs.getDate(6).getTime()),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13),
						rs.getString(14),
						rs.getString(15),
						rs.getString(16));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public boolean updateTrangthai(String mahs, String trangthai) {
		String query = "update tbKHAISINH set trangThaiDuyet = N'" + trangthai + "' where maDangKiKhaiSinh=N'" + mahs+"'";
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
	
	public boolean deleteKhaiSinh(String mahs) {
		String query = "delete from tbKHAISINH where maDangKiKhaiSinh=N'" + mahs+"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int countFromKhaiSinhs() {
		String query = "SELECT COUNT(*) FROM tbKhaiSinh";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int countKhaiSinhByYear(int year) {
		String query = "SELECT COUNT(*) FROM tbKhaiSinh where year(ngayDangKy) = '" + year+"'";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
