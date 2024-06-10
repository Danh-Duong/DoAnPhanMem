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
 * Servlet implementation class ResetPassController
 */
@WebServlet("/reset-pass")
public class ResetPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPassController() {
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
		String cccd = request.getParameter("cccd");
		System.out.println(cccd + "," + isOtp);
		if (isOtp != null && isOtp.equals("true") && cccd != null) {
			if (CookieUtils.getCookieByName(request, "resetOtp") != null)
				CookieUtils.deleteCookieByName(response, "resetOtp");
			String otp = CookieUtils.generateRandomString(5);
			CookieUtils.addCookie(response, "resetOtp", CookieUtils.encodeObjectToBase64(otp));

			TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();
			String email = taiKhoanRepository.getEmailByCCCD(cccd);
			if (email == null) {
				request.setAttribute("error", "Không tồn tại tài khoản này!");
				request.getRequestDispatcher("resetPass.jsp").forward(request, response);
			} else {
				EmailUtils.sendEmailRegister(email, otp);
				request.getRequestDispatcher("resetPass.jsp").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("resetPass.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cccd = request.getParameter("cccd");
		String mk = request.getParameter("mk");
		String otp = request.getParameter("otp");
		
		System.out.println("OTP: " + otp);

		String otpCk = CookieUtils.decodeBase64ToObject(CookieUtils.getCookieByName(request, "resetOtp"), String.class);

		System.out.println("OTPCK: " + otpCk);
		
		if (cccd == null || mk == null || otp == null ) {
			System.out.println("1");
			request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			request.getRequestDispatcher("resetPass.jsp").forward(request, response);
		}
		else if (!otpCk.equals(otp)) {
			System.out.println("2");
			request.setAttribute("error", "Mã OTP không đúng");
			request.getRequestDispatcher("resetPass.jsp").forward(request, response);
		} else {
			System.out.println("3");
			TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();
			taiKhoanRepository.updatePassword(cccd, mk);
			request.getRequestDispatcher("resetPass.jsp").forward(request, response);
		}
	}

}
