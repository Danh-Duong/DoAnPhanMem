package DoAnPhanMem;

import java.util.GregorianCalendar;
import java.util.List;


import Dao.NhanKhauDAO;
import model.NhanKhau;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		NhanKhauDAO nhanKhauDAO = new NhanKhauDAO();
		List<NhanKhau> list = nhanKhauDAO.selectAll();
		for (NhanKhau x : list) {
			System.out.println(x);
		}
	}

}
