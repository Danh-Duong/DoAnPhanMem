package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

import model.HoKhau;
import model.NhanKhau;
import repository.HoKhauRepository;
import repository.NhanKhauRepository;
import utils.ExcelUtils;
import utils.PDFUtils;

/**
 * Servlet implementation class NhanKhauController
 */
@WebServlet("/nhankhau")
public class NhanKhauController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhanKhauController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();

		String mank = request.getParameter("mank");
		String action = request.getParameter("action");

		System.out.println("MANK: " + mank);
		System.out.println("Action: " + action);
		if (mank != null && action != null && action.equals("delete")) {
			System.out.println("Danh");
			nhanKhauRepository.deleteNhanKhau(mank);
			response.sendRedirect("nhankhau");
		} else {

			String page = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			int pageInt = page == null ? 1 : Integer.parseInt(page); // lấy số trang hiện tại
			int pageSizeInt = pageSize == null ? 10 : Integer.parseInt(pageSize); // số hộ khẩu hiển thị trên 1 trang
			int offset = (pageInt - 1) * pageSizeInt; // vị trí bắt đầu lấy dữ liệu

			int totalRecords = nhanKhauRepository.countFromNhanKhaus();
			int totalPages = (int) Math.ceil(totalRecords / (double) pageSizeInt);

			List<NhanKhau> nhanKhaus = nhanKhauRepository.getNhanKhausByPage(offset, pageSizeInt);
			List<NhanKhau> result;
			if (mank != null && !mank.equals(""))
				result = nhanKhaus.stream().filter(nk -> nk.getIdNhanKhau().equalsIgnoreCase(mank))
						.collect(Collectors.toList());
			else
				result = nhanKhaus;
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("nhankhaus", result);
			request.setAttribute("currentPage", pageInt);
			request.setAttribute("currentPageSize", pageSizeInt);
			request.setAttribute("mank", mank);

			request.getRequestDispatcher("QuanLyNhanKhau.jsp").forward(request, response);
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

}
