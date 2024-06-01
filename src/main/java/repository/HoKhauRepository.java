package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HoKhau;

public class HoKhauRepository {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public List<HoKhau> getAll() {
		String query = "SELECT * FROM tbHOKHAU";
		List<HoKhau> HoKhaus;
		try {
			HoKhaus = new ArrayList<>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				HoKhaus.add(new HoKhau(rs.getString(1),
						rs.getString(2),
						rs.getDate(3),
						rs.getBoolean(4),
						rs.getInt(5),
						rs.getString(6)));
			}
			
			return HoKhaus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<HoKhau> getHoKhausByPage(int offset, int pageSize) {
		String query = ("select * from tbHoKhau ORDER BY idHoKhau OFFSET " + offset
				+ " ROWS FETCH NEXT " + pageSize + " ROWS ONLY");
		List<HoKhau> HoKhaus;
		try {
			HoKhaus = new ArrayList<>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				HoKhaus.add(new HoKhau(rs.getString(1),
						rs.getString(2),
						rs.getDate(3),
						rs.getBoolean(4),
						rs.getInt(5),
						rs.getString(6)));
			}
			
			return HoKhaus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int countFromHoKhaus() {
		String query = "SELECT COUNT(*) FROM tbHoKhau";
		
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
	
	public HoKhau getHoKhauById(String idHoKhau) {
		String query = "SELECT * FROM tbHoKhau where idHoKhau=N'" + idHoKhau+"'";
		HoKhau HoKhau=null;
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return new HoKhau(rs.getString(1),
						rs.getString(2),
						rs.getDate(3),
						rs.getBoolean(4),
						rs.getInt(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return HoKhau;
	}
	

}
