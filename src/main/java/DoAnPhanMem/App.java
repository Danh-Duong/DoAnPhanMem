package DoAnPhanMem;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Dao.NhanKhauDAO;
import Utils.HibernateUtil;
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
