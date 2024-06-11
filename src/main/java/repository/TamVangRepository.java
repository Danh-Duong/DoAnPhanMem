package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.KhaiSinh;
import model.TamVang;

public class TamVangRepository {
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
				+ "FROM tbTAMVANG\r\n"
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
	
	
	public boolean saveTamVang(TamVang tamVang) {
		String query = "INSERT tbTAMVANG VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tamVang.getMaTamVang());
			ps.setDate(2, new java.sql.Date(tamVang.getNgayDangKi().getTime()));
			ps.setString(3, tamVang.getDiaChiDen());
			ps.setString(4, tamVang.getLyDo());
			ps.setString(5, tamVang.getIdNhanKhau());
			ps.setDate(6, new java.sql.Date(tamVang.getNgayBatDau().getTime()));
			ps.setDate(7, new java.sql.Date(tamVang.getNgayKetThuc().getTime()));
			ps.setString(8, "Chờ xét duyệt");
			ps.setString(9, tamVang.getCccdNdk());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public String getNewMaTamVang() {
		String query = "select top 1 maTamVang\r\n"
				+ "from tbTAMVANG\r\n"
				+ "order by maTamVang desc";

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
				return "TV" + format.format(somaks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<TamVang> getDanhsachHoso(String trangthai) {
		String query = "select * from tbTAMVANG where trangThaiDuyet=N'"+ trangthai + "'";
		List<TamVang> result = new ArrayList<TamVang>();
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new TamVang(rs.getString(1), new java.util.Date(rs.getDate(2).getTime()), rs.getString(4), rs.getString(5)));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public TamVang getHosoById(String mahs) {
		String query = "select * from tbTAMVANG where maTamVang=N'"+mahs+"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new TamVang(rs.getString(1), new java.util.Date(rs.getDate(2).getTime()),rs.getString(3), rs.getString(4), rs.getString(5),new java.util.Date(rs.getDate(6).getTime()),new java.util.Date(rs.getDate(7).getTime()),rs.getString(8),rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public boolean updateTrangthai(String mahs, String trangthai) {
		String query = "update tbTAMVANG set trangThaiDuyet = N'" + trangthai + "' where maTamVang=N'" + mahs+"'";
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
