package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.KhaiSinh;
import model.KhaiTu;
import repository.KhaiSinhRepository;
import repository.KhaiTuRepository;
import repository.NhanKhauRepository;

/**
 * Servlet implementation class DuyetKhaiTuController
 */
@WebServlet("/duyetKhaiTu")
public class DuyetKhaiTuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuyetKhaiTuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhaiTuRepository khaiTuRepository = new KhaiTuRepository();

		String mahs = request.getParameter("mahs");
		String trangthai = request.getParameter("trangthai");

		String tt="";
		
		if (mahs == null) {
			if (trangthai==null || trangthai.equals("1")) {
				tt="Đã duyệt";
				trangthai ="1";
			}
			else if (trangthai.equals("0"))
				tt = "Chờ xét duyệt";
			else 
				tt = "Đã hủy";
				
			request.setAttribute("hoso", khaiTuRepository.getDanhsachHoso(tt));
			request.setAttribute("slhoso", khaiTuRepository.getDanhsachHoso(tt).size());
			request.setAttribute("trangthai", trangthai);
			request.getRequestDispatcher("DuyetKhaiTu.jsp").forward(request, response);
		} else {
			String type = request.getParameter("type");
			KhaiTu kt = khaiTuRepository.getHosoById(mahs);
			NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();

			if (type == null) {
				SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
				String outputDateStr = outputFormat.format(kt.getNgaySinh());
				request.setAttribute("ngaysinh", outputDateStr);
				request.setAttribute("ngaymat", outputFormat.format(kt.getNgayMat()));
				request.setAttribute("ngaydangky", outputFormat.format(kt.getNgayDangKi()));
				request.setAttribute("khaitu", kt);
				
				if (kt.getTrangThaiDuyet().equals("Chờ xét duyệt"))
					request.setAttribute("trangthai", "0");
				
				request.getRequestDispatcher("ChitietKhaiTu.jsp").forward(request, response);
			}
			
			else if (type.equals("yes")) {
				khaiTuRepository.updateTrangthai(mahs,"Đã duyệt");
				/* nhanKhauRepository.deleteNhanKhau(kt.getIdNhanKhau()); */
				request.setAttribute("success", "Duyệt hồ sơ thành công!");
				request.setAttribute("hoso", khaiTuRepository.getDanhsachHoso("Đã duyệt"));
				request.setAttribute("slhoso", khaiTuRepository.getDanhsachHoso("Đã duyệt").size());
				request.setAttribute("trangthai", 1);
				request.getRequestDispatcher("DuyetKhaiTu.jsp").forward(request, response);
				
			}
			
			else {
				khaiTuRepository.updateTrangthai(mahs,"Đã hủy");
				request.setAttribute("success", "Hủy hồ sơ thành công!");
				request.setAttribute("hoso", khaiTuRepository.getDanhsachHoso("Đã duyệt"));
				request.setAttribute("slhoso", khaiTuRepository.getDanhsachHoso("Đã duyệt").size());
				request.setAttribute("trangthai", 1);
				request.getRequestDispatcher("DuyetKhaiTu.jsp").forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
