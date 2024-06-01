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
import model.NhanKhau;

public class NhanKhauRepository {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public String getIdByCCCD(String cccd) {
		String query = "SELECT idNhanKhau FROM tbNHANKHAU where cccd=N'" + cccd+"'";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getEmailByCCCD(String cccd) {
		String query = "SELECT email FROM tbNHANKHAU where cccd=N'" + cccd+"'";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getIdHoKhauByCCCD(String cccd) {
		String query = "SELECT idHoKhau FROM tbNHANKHAU where cccd=N'" + cccd+"'";
		
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public NhanKhau getNhanKhauById(String id) {
		String query = "select * from tbNHANKHAU where idNhanKhau=N'"+id+"'";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new NhanKhau(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(10),
						rs.getString(13),
						rs.getString(14));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String getNewMaNhanKhau() {
		String query = "select top 1 idNhanKhau\r\n"
				+ "from tbNHANKHAU\r\n"
				+ "order by idNhanKhau desc";

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
				return "NK" + format.format(somaks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	public boolean saveNhanKhau(KhaiSinh khaisinh, String idNhanKhau) {
		String query = "INSERT into tbNHANKHAU(idNhanKhau,idHoKhau,tenCongDan,ngaySinh,gioiTinh,diaChiThuongTru,noiOHienTai,noiSinh,quanHe, quocTich,danToc, ngayCapNhat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idNhanKhau);
			ps.setString(2, khaisinh.getIdHoKhau());
			ps.setString(3, khaisinh.getHoTen());
			java.sql.Date sqlDate = new java.sql.Date(khaisinh.getNgaySinh().getTime());
	        ps.setDate(4, sqlDate);
			ps.setString(5, khaisinh.getGioiTinh());
			ps.setString(6, khaisinh.getQueQuan());
			ps.setString(7, khaisinh.getNoiSinh());
			ps.setString(8, khaisinh.getNoiSinh());
			ps.setString(9, "Con");
			ps.setString(10, khaisinh.getQuocTich());
			ps.setString(11, khaisinh.getDanToc());
			ps.setDate(12, new java.sql.Date(new Date().getTime()));
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	

}
