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
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import Dao.HoKhauDAO;
import Dao.NhanKhauDAO;

/**
 * Servlet implementation class index_bai4
 */ 
@WebServlet({ "/account/list", "/account/create", "/account/add", "/account/delete", "/account/edit/*",
		"/account/update" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<NhanKhau> list = null;
	ArrayList<HoKhau> hoKhaus = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		NhanKhauDAO userDAO = new NhanKhauDAO();
		HoKhauDAO hoKhauDAO = new HoKhauDAO();
		HttpSession session = request.getSession();
		NhanKhau user = new NhanKhau();
		if (uri.contains("list")) {
			list = userDAO.selectAll();
			session.setAttribute("listUser", list);
			session.setAttribute("listHoKhau", hoKhauDAO.selectAll());
			getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
		} else if (uri.contains("create")) {
			try {
				session.setAttribute("listUser", userDAO.selectAll());
				session.setAttribute("listHoKhau", hoKhauDAO.selectAll());
				getServletContext().getRequestDispatcher("/views/form.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("add")) {
			try {
				String dateStr = request.getParameter("ngaySinh");
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
				DateTimeConverter dtc = new DateConverter(date);
				ConvertUtils.register(dtc, Date.class);
				String idHoKhau = request.getParameter("idHoKhau");
				BeanUtils.populate(user, request.getParameterMap());
				HoKhau hoKhau = new HoKhau();
				hoKhau.setIdHoKhau(idHoKhau);
				user.setHoKhau(hoKhauDAO.selectById(hoKhau));

				Date ngaySinh = convertStringToDate((request.getParameter("ngaySinh")));
				user.setNgaySinh(ngaySinh);
				userDAO.insert(user);
				request.setAttribute("mess", "Tạo thành công");
				getServletContext().getRequestDispatcher("/views/form.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("delete")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				userDAO.delete(user);
				response.sendRedirect(request.getContextPath() + "/account/list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("edit")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				user = userDAO.selectById(user);
				session.setAttribute("edit", user);
				getServletContext().getRequestDispatcher("/views/form.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		} else if (uri.contains("update")) {
			try {
				String dateStr = request.getParameter("ngaySinh");
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
				DateTimeConverter dtc = new DateConverter(date);
				ConvertUtils.register(dtc, Date.class);
				BeanUtils.populate(user, request.getParameterMap());
				String idHoKhau = request.getParameter("idHoKhau");
				HoKhau exist = new HoKhau();
				exist.setIdHoKhau(idHoKhau);
				HoKhau hoKhau = hoKhauDAO.selectById(exist);
				user.setHoKhau(hoKhau);
				userDAO.update(user);
				response.sendRedirect(request.getContextPath() + "/account/list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

	public Date convertStringToDate(String dateString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.parse(dateString);
	}

}
