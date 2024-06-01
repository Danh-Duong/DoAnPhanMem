package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.KhaiSinh;
import model.NhanKhau;
import repository.KhaiSinhRepository;
import repository.NhanKhauRepository;

/**
 * Servlet implementation class DuyetKhaiSinhController
 */
@WebServlet("/duyetKhaiSinh")
public class DuyetKhaiSinhController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DuyetKhaiSinhController() {
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
		KhaiSinhRepository khaiSinhRepository = new KhaiSinhRepository();

		String mahs = request.getParameter("mahs");
		if (mahs == null) {
			request.setAttribute("hoso", khaiSinhRepository.getDanhsachHoso());
			request.setAttribute("slhoso", khaiSinhRepository.getDanhsachHoso().size());
			request.getRequestDispatcher("DuyetKhaiSinh.jsp").forward(request, response);
		} else {
			String type = request.getParameter("type");
			KhaiSinh ks = khaiSinhRepository.getHosoById(mahs);
			NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();

			if (type == null) {
				SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
				String outputDateStr = outputFormat.format(ks.getNgaySinh());
				request.setAttribute("ngaysinh", outputDateStr);
				request.setAttribute("khaisinh", ks);
				
				request.setAttribute("me", nhanKhauRepository.getNhanKhauById(ks.getIdNhanKhauMe()));
				request.setAttribute("cha", nhanKhauRepository.getNhanKhauById(ks.getIdNhanKhauCha()));
				request.getRequestDispatcher("ChitietKhaiSinh.jsp").forward(request, response);
			}
			
			else if (type.equals("yes")) {
				khaiSinhRepository.updateTrangthai(mahs);
				nhanKhauRepository.saveNhanKhau(ks, nhanKhauRepository.getNewMaNhanKhau());
				request.setAttribute("success", "Duyệt hồ sơ thành công!");
				request.getRequestDispatcher("DuyetKhaiSinh.jsp").forward(request, response);
			}
			
			else {
				khaiSinhRepository.deleteKhaiSinh(mahs);
				request.setAttribute("success", "Xóa hồ sơ thành công!");
				request.getRequestDispatcher("DuyetKhaiSinh.jsp").forward(request, response);
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

}
