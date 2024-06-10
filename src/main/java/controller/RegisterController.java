package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaiKhoan;
import repository.TaiKhoanRepository;
import utils.CookieUtils;
import utils.EmailUtils;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
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
		String isOtp = request.getParameter("otp");
		String email = request.getParameter("email");
		if (isOtp != null && isOtp.equals("true") && email != null) {
			TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();
			if (taiKhoanRepository.getTkByEmail(email) != null) {
				request.setAttribute("error", "Email này đã được sử dụng");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				if (CookieUtils.getCookieByName(request, "otp") != null)
					CookieUtils.deleteCookieByName(response, "otp");
				String otp = CookieUtils.generateRandomString(5);
				CookieUtils.addCookie(response, "otp", CookieUtils.encodeObjectToBase64(otp));
				EmailUtils.sendEmailRegister(email, otp);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cccd = request.getParameter("cccd");
		String ten = request.getParameter("ten");
		String mk = request.getParameter("mk");
		String otp = request.getParameter("otp");
		String rmk = request.getParameter("rmk");
		String email = request.getParameter("email");
		String otpCk = null;
		if (CookieUtils.getCookieByName(request, "otp") != null)
			otpCk = CookieUtils.decodeBase64ToObject(CookieUtils.getCookieByName(request, "otp"), String.class);

		if (cccd == null || ten == null || mk == null || rmk == null || otp == null || email == null || otpCk == null) {
			request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		if (!otpCk.equals(otp)) {
			request.setAttribute("error", "Mã OTP không đúng");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (!mk.equals(rmk)) {
			request.setAttribute("error", "Mật khẩu không khớp");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

			TaiKhoan taiKhoan = new TaiKhoan(cccd, mk, "M05", true, new Date(), ten, email);
			taiKhoanRepository.saveTaiKhoan(taiKhoan);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}
