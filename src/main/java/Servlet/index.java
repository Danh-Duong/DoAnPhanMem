package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HoKhau;
import model.NhanKhau;
import model.TamVang;

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
import Dao.TamVangDAO;

@WebServlet({ "/account/list", "/account/create", "/account/add", "/account/delete", "/account/edit/*",
		"/account/update", "/account/tamvang" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<HoKhau> hoKhaus = null;

	public index() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		NhanKhauDAO nhanKhauDAO = new NhanKhauDAO();
		HoKhauDAO hoKhauDAO = new HoKhauDAO();
		TamVangDAO tamVangDAO = new TamVangDAO();
		HttpSession session = request.getSession();
		NhanKhau user = new NhanKhau();

		if (uri.contains("list")) {
			session.setAttribute("listUser", nhanKhauDAO.selectAll());
			session.setAttribute("listHoKhau", hoKhauDAO.selectAll());
			getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
		} else if (uri.contains("create")) {
			try {
				session.setAttribute("listUser", nhanKhauDAO.selectAll());
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
				nhanKhauDAO.insert(user);
				request.setAttribute("mess", "Tạo thành công");
				getServletContext().getRequestDispatcher("/views/form.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("delete")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				nhanKhauDAO.delete(user);
				response.sendRedirect(request.getContextPath() + "/account/list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("edit")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				user = nhanKhauDAO.selectById(user);
				session.setAttribute("edit", user);
				getServletContext().getRequestDispatcher("/views/form.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
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
				nhanKhauDAO.update(user);
				response.sendRedirect(request.getContextPath() + "/account/list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("tamvang")) {
			try {
				TamVang tamVang = new TamVang();
				if (request.getParameter("maTamVang") != null) {
					String dateStr = request.getParameter("ngayDangKi");
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					DateTimeConverter dtc = new DateConverter(date);
					ConvertUtils.register(dtc, Date.class);
					
					BeanUtils.populate(tamVang, request.getParameterMap());
					String idNhanKhau = request.getParameter("idNhanKhau");
					NhanKhau exist = new NhanKhau();
					exist.setIdNhanKhau(idNhanKhau);
					NhanKhau nhanKhau = nhanKhauDAO.selectById(exist);
					tamVang.setNhanKhau(nhanKhau);
					tamVangDAO.insert(tamVang);
					request.setAttribute("mess", "Gửi thành công");
				}
				session.setAttribute("listNhanKhau", nhanKhauDAO.selectAll());
				getServletContext().getRequestDispatcher("/views/tamvang.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public Date convertStringToDate(String dateString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.parse(dateString);
	}
}
