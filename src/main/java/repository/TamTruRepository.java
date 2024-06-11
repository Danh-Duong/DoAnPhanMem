package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.TamTru;
import model.TamVang;

public class TamTruRepository {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Integer> getNumberByYear(int year) {
		List<Integer> result= new ArrayList<Integer>();
		String query = "SELECT \r\n"
				+ "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 1 AND 3 THEN 1 END) AS count_Q1,\r\n"
				+ "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 4 AND 6 THEN 1 END) AS count_Q2,\r\n"
				+ "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 7 AND 9 THEN 1 END) AS count_Q3,\r\n"
				+ "    COUNT(CASE WHEN MONTH(ngayDangKi) BETWEEN 10 AND 12 THEN 1 END) AS count_Q4\r\n"
				+ "FROM tbTAMTRU\r\n"
				+ "WHERE YEAR(ngayDangKi) = " + year;
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
			{
				result= Arrays.asList(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
			}
			
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String getNewMaTamTru() {
		String query = "select top 1 maTamTru\r\n"
				+ "from tbTAMTRU\r\n"
				+ "order by maTamTru desc";

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
				return "TT" + format.format(somaks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public boolean saveTamTru(TamTru tamTru) {
		String query = "INSERT tbTAMTRU VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tamTru.getMaTamTru());
			ps.setString(2, tamTru.getHoten());
			ps.setDate(3, new java.sql.Date(tamTru.getNgaySinh().getTime()));
			ps.setString(4, tamTru.getGioiTinh());
			ps.setString(5, tamTru.getCccd());
			ps.setString(6, tamTru.getQuocTinh());
			ps.setString(7, tamTru.getSoDt());
			ps.setString(8, tamTru.getDiaChi());
			ps.setString(9, tamTru.getDiaChiDangKi());
			ps.setString(10, tamTru.getHoTenChuho());
			ps.setString(11, tamTru.getQuanHeChuHo());
			ps.setString(12, tamTru.getCccdChuHo());
			ps.setString(13, tamTru.getTrangThaiDuyet());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public List<TamTru> getDanhsachHoso(String trangthai) {
		String query = "select * from tbTAMTRU where trangThaiDuyet=N'"+ trangthai + "'";
		List<TamTru> result = new ArrayList<TamTru>();
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new TamTru(rs.getString(1),rs.getString(2), new java.util.Date(rs.getDate(3).getTime()),rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public TamTru getHosoById(String mahs) {
		String query = "select * from tbTAMTRU where maTamTru=N'"+mahs+"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return (new TamTru(rs.getString(1),rs.getString(2), new java.util.Date(rs.getDate(3).getTime()),rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public boolean updateTrangthai(String mahs, String trangthai) {
		String query = "update tbTAMTRU set trangThaiDuyet = N'" + trangthai + "' where maTamTru=N'" + mahs+"'";
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
