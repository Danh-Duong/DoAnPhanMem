package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaiKhoan;
import repository.TaiKhoanRepository;
import utils.CookieUtils;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cccd =request.getParameter("cccd");
		String mk = request.getParameter("mk");
		
		TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();
		
		TaiKhoan taiKhoan = taiKhoanRepository.getTkByCccdAndMk(cccd, mk);
		if (taiKhoan==null) {
			request.setAttribute("error", "Tài khoản không tồn tại");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (taiKhoan.getMaQuyen().equals("M05")) {
			CookieUtils.addCookie(response, "cccd", cccd);
			response.sendRedirect("/DoAnPhanMem/");
		}
		else {
			CookieUtils.addCookie(response, "cccd", cccd);
			response.sendRedirect("admin");
		}
	}

}
