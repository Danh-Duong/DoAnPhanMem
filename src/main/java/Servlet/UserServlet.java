package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HoKhau;
import model.NhanKhau;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import Dao.HoKhauDAO;
import Dao.NhanKhauDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/demo/aaaaaaaaaaaaa"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<NhanKhau> nhanKhaus = null;
	ArrayList<HoKhau> hoKhaus = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HoKhauDAO hoKhauDAO = new HoKhauDAO();
		NhanKhauDAO userDAO = new NhanKhauDAO();
		NhanKhau user = new NhanKhau();
		String uri = request.getRequestURI();
		if (uri.contains("edit")) {

		} else if (uri.contains("create")) {

		} else if (uri.contains("delete")) {
			try {
				String dateStr = request.getParameter("ngaySinh");
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
				DateTimeConverter dtc = new DateConverter(date);
				ConvertUtils.register(dtc, Date.class);
				BeanUtils.populate(user, request.getParameterMap());
				userDAO.delete(user);
				request.setAttribute("mess", "Xóa thành công");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("update")) {
			
		}
		
		getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
