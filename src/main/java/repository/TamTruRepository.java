package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
