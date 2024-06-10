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

import model.HoKhau;
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
	
	public String getIdByNameAndHk(String name, String mahk) {
		String query = "SELECT idNhanKhau FROM tbNHANKHAU where idHoKhau=N'" + mahk+"' and tenCongDan=N'" + name+"'";
		
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
						rs.getString("idNhanKhau"),
						rs.getString("idHoKhau"),
	                    rs.getString("tenCongDan"),
	                    rs.getString("cccd"),
	                    rs.getDate("ngaySinh"),
	                    rs.getString("gioiTinh"),
	                    rs.getString("noiOHienTai"),
	                    rs.getString("noiSinh"),
	                    rs.getString("quanHe"),
	                    rs.getString("quocTich"),
	                    rs.getString("danToc"),
	                    rs.getString("ngheNghiep"),
	                    rs.getString("tinhTrangHocVan"),
	                    rs.getString("tinhTrangHonNhan"),
	                    rs.getString("image"));
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
	
	public boolean saveNhanKhau1(NhanKhau nhanKhau, String idNhanKhau) {
		String query = "INSERT into tbNHANKHAU(idNhanKhau,idHoKhau,tenCongDan,cccd, ngaySinh,gioiTinh,diaChiThuongTru,noiOHienTai,noiSinh,quanHe, quocTich,danToc, ngheNghiep,tinhTrangCuTru ,tinhTrangHocVan,tinhTrangHonNhan ,ngayCapNhat ,image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idNhanKhau);
			ps.setString(2, nhanKhau.getIdHoKhau());
			ps.setString(3, nhanKhau.getTenCongDan());
			ps.setString(4, nhanKhau.getCccd());
			java.sql.Date sqlDate = new java.sql.Date(nhanKhau.getNgaySinh().getTime());
	        ps.setDate(5, sqlDate);
			ps.setString(6, nhanKhau.getGioiTinh());
			ps.setString(7, nhanKhau.getDiaChiThuongTru());
			ps.setString(8, nhanKhau.getNoiOHienTai());
			ps.setString(9, nhanKhau.getNoiSinh());
			ps.setString(10, nhanKhau.getQuanHe());
			ps.setString(11, nhanKhau.getQuocTich());
			ps.setString(12, nhanKhau.getDanToc());
			ps.setString(13, nhanKhau.getNgheNghiep());
			ps.setString(14, nhanKhau.getTinhTrangCuTru());
			ps.setString(15, nhanKhau.getTinhTrangHocVan());
			ps.setString(16, nhanKhau.getTinhTrangHonNhan());
			ps.setDate(17, new java.sql.Date(new Date().getTime()));
			ps.setString(18, nhanKhau.getImage());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean updateNhankhau(NhanKhau nhanKhau, String idNhanKhau) {
		String query = "update tbNHANKHAU set idHoKhau =?,tenCongDan=?,cccd=?, ngaySinh=?,gioiTinh=?,diaChiThuongTru=?,noiOHienTai=?,noiSinh=?,quanHe=?, quocTich=?,danToc=?, ngheNghiep=?,tinhTrangCuTru=? ,tinhTrangHocVan =?,tinhTrangHonNhan =?,ngayCapNhat =?,image=? where idNhanKhau=?";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, nhanKhau.getIdHoKhau());
			ps.setString(2, nhanKhau.getTenCongDan());
			ps.setString(3, nhanKhau.getCccd());
			java.sql.Date sqlDate = new java.sql.Date(nhanKhau.getNgaySinh().getTime());
	        ps.setDate(4, sqlDate);
			ps.setString(5, nhanKhau.getGioiTinh());
			ps.setString(6, nhanKhau.getDiaChiThuongTru());
			ps.setString(7, nhanKhau.getNoiOHienTai());
			ps.setString(8, nhanKhau.getNoiSinh());
			ps.setString(9, nhanKhau.getQuanHe());
			ps.setString(10, nhanKhau.getQuocTich());
			ps.setString(11, nhanKhau.getDanToc());
			ps.setString(12, nhanKhau.getNgheNghiep());
			ps.setString(13, nhanKhau.getTinhTrangCuTru());
			ps.setString(14, nhanKhau.getTinhTrangHocVan());
			ps.setString(15, nhanKhau.getTinhTrangHonNhan());
			ps.setDate(16, new java.sql.Date(new Date().getTime()));
			ps.setString(17, nhanKhau.getImage());
			ps.setString(18, idNhanKhau);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public int countFromNhanKhaus() {
		String query = "SELECT COUNT(*) FROM tbNhanKhau";
		
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
	
	public boolean deleteNhanKhau(String idNhanKhau) {
		String query = "delete from tbNhanKhau where idNhanKhau = '" + idNhanKhau +"'";
		
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
	
	
	public List<NhanKhau> getNhanKhausByPage(int offset, int pageSize) {
		String query = ("select * from tbNHANKHAU ORDER BY idNhanKhau OFFSET " + offset
				+ " ROWS FETCH NEXT " + pageSize + " ROWS ONLY");
		List<NhanKhau> nhanKhaus;
		try {
			nhanKhaus = new ArrayList<>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nhanKhaus.add(new NhanKhau(rs.getString(1),
						rs.getString(3),
						rs.getString(4),
						new java.util.Date(rs.getDate(5).getTime()),
						rs.getString(7)));
			}
			
			return nhanKhaus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
