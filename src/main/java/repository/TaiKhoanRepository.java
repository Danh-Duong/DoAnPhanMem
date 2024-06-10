package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhaiSinh;
import model.TaiKhoan;

public class TaiKhoanRepository {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean saveTaiKhoan(TaiKhoan taiKhoan) {
		String query = "INSERT tbTAIKHOAN VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, taiKhoan.getCccd());
			ps.setString(2, taiKhoan.getMatKhau());
			ps.setString(3, taiKhoan.getMaQuyen());
			ps.setBoolean(4, taiKhoan.isTrangThai());
			java.sql.Date sqlDate = new java.sql.Date(taiKhoan.getNgayCap().getTime());
	        ps.setDate(5, sqlDate);
			ps.setString(6, taiKhoan.getHoten());
			ps.setString(7, taiKhoan.getEmail());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean deleteTaiKhoan(String matk) {
		String query = "delete from tbTAIKHOAN where cccd = '" + matk +"'";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			ps.executeUpdate();
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean updateStatus(String matk, int status) {
		String query = "update tbTAIKHOAN set trangThai = " + status + " where cccd = '" + matk + "'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updatePassword(String matk, String password) {
		String query = "update tbTAIKHOAN set matKhau = '" + password + "' where cccd = '" + matk + "'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	
	public List<TaiKhoan> getAll() {
		String query = "select * from tbTAIKHOAN";
		try {
			List<TaiKhoan> result = new ArrayList<TaiKhoan>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new TaiKhoan(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getBoolean(4),
						new java.util.Date(rs.getDate(5).getTime()),
						rs.getString(6),
						rs.getString(7)));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String getEmailByCCCD(String cccd) {
		String query = "select email from tbTAIKHOAN where cccd = '" + cccd +"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public TaiKhoan getTkByCccdAndMk(String cccd, String mk) {
		String query = "select * from tbTAIKHOAN where cccd = '" + cccd +"' and matKhau='" + mk +"'";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				return new TaiKhoan(cccd, mk, rs.getString(3), rs.getBoolean(4), new java.util.Date(rs.getDate(5).getTime()), rs.getString(6),rs.getString(7));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public TaiKhoan getTkByEmail(String email) {
		String query = "select * from tbTAIKHOAN where email = '" + email +"'";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				return new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), new java.util.Date(rs.getDate(5).getTime()), rs.getString(6),rs.getString(7));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
