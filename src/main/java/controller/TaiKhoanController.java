package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.TaiKhoanRepository;

/**
 * Servlet implementation class TaiKhoanController
 */
@WebServlet("/taikhoan")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaiKhoanController() {
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
		TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

//		lấy thông tin cần thiết cho việc cập nhập, xóa tài khoản
		String action = request.getParameter("action");
		String matk = request.getParameter("matk");
//		xóa tài khoản
		if (matk != null && action.equals("delete")) {
			if (taiKhoanRepository.deleteTaiKhoan(matk)) {
				request.setAttribute("success", "Xóa tài khoản có CCCD: " + matk + " thành công");
			} else {
				request.setAttribute("error", "Không thể xóa tài khoản có CCCD: " + matk);
			}
		}
//		cập nhập trạng thái tài khoản
		else if (matk != null && action.equals("update")) {
			int type = Integer.parseInt(request.getParameter("type"));
			if (taiKhoanRepository.updateStatus(matk, type)) {
				request.setAttribute("success", "Cập nhập tài khoản có CCCD: " + matk + " thành công");
			} else {
				request.setAttribute("error",  "Cập nhập tài khoản có CCCD: " + matk + " không thành công");
			}
		}
		request.setAttribute("taikhoans", taiKhoanRepository.getAll());
		request.getRequestDispatcher("QuanLyTaiKhoan.jsp").forward(request, response);
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
