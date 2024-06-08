package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.HoKhauRepository;
import repository.KhaiSinhRepository;
import repository.KhaiTuRepository;
import repository.NhanKhauRepository;
import repository.TamTruRepository;
import repository.TamVangRepository;
import utils.CookieUtils;


/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		CustomerRepository customerRepository = new CustomerRepository();
//		String username = CookieUtils.getCookieByName(request, "username");
//		nếu người truy cập không phải là admin thì trở về trang home
//		if (username == null || !username.equals("admin"))
//			response.sendRedirect("home");
//		else {

			HoKhauRepository hoKhauRepository = new HoKhauRepository();
			NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();
			KhaiSinhRepository khaiSinhRepository= new KhaiSinhRepository();
			KhaiTuRepository khaiTuRepository = new KhaiTuRepository();
			TamTruRepository tamTruRepository = new TamTruRepository();
			TamVangRepository tamVangRepository = new TamVangRepository();

			request.setAttribute("hokhaus", hoKhauRepository.countFromHoKhaus()); // trả về số lượng hộ khẩu
			request.setAttribute("nhankhaus", nhanKhauRepository.countFromNhanKhaus()); // trả về số lượng nhân khẩu
			request.setAttribute("khaisinhs", khaiSinhRepository.countFromKhaiSinhs()); // trả về số lượng người sinh
			request.setAttribute("khaitus", khaiTuRepository.countFromKhaiTus()); // trả về số lượng người mất

			int year = request.getParameter("year") == null ? 2024 : Integer.parseInt(request.getParameter("year")); // lấy năm cần thống kê

			List<Integer> numbTamtru = tamTruRepository.getNumberByYear(year);
			for (int i=0;i<numbTamtru.size();i++)	
				request.setAttribute("tt"+(i+1), numbTamtru.get(i));

			List<Integer> numbTamvang = tamVangRepository.getNumberByYear(year);
			for (int i=0;i<numbTamvang.size();i++)	
				request.setAttribute("tv"+(i+1), numbTamvang.get(i));
			

			request.setAttribute("ks", khaiSinhRepository.countKhaiSinhByYear(year));
			request.setAttribute("kt", khaiTuRepository.countKhaiTuByYear(year));
			request.setAttribute("year", year);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
