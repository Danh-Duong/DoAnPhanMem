package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.KhaiSinh;
import model.NhanKhau;
import model.TamVang;
import repository.KhaiSinhRepository;
import repository.NhanKhauRepository;
import repository.TamVangRepository;
import utils.EmailUtils;

/**
 * Servlet implementation class DuyetTamVangController
 */
@WebServlet("/duyetTamVang")
public class DuyetTamVangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuyetTamVangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TamVangRepository tamVangRepository = new TamVangRepository();

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
				
			
			request.setAttribute("hoso", tamVangRepository.getDanhsachHoso(tt));
			request.setAttribute("slhoso", tamVangRepository.getDanhsachHoso(tt).size());
			request.setAttribute("trangthai", trangthai);
			request.getRequestDispatcher("DuyetTamVang.jsp").forward(request, response);
		} 
		else {
			String type = request.getParameter("type");
			TamVang tv = tamVangRepository.getHosoById(mahs);
			NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();

			if (type == null) {
				SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
				String nbd = outputFormat.format(tv.getNgayBatDau());
				String nkt = outputFormat.format(tv.getNgayKetThuc());
				String ndk = outputFormat.format(tv.getNgayDangKi());
				request.setAttribute("nbd", nbd);
				request.setAttribute("nkt", nkt);
				request.setAttribute("ndk", ndk);
				request.setAttribute("tamvang", tv);
				
				if (tv.getTrangThaiDuyet().equals("Chờ xét duyệt"))
					request.setAttribute("trangthai", "0");
				
	
				NhanKhau nhanKhau = nhanKhauRepository.getNhanKhauById(tv.getIdNhanKhau());
				request.setAttribute("nhankhau", nhanKhau);
				String ns = outputFormat.format(nhanKhauRepository.getNhanKhauById(tv.getIdNhanKhau()).getNgaySinh());
				request.setAttribute("ns", ns);
				request.getRequestDispatcher("ChitietTamVang.jsp").forward(request, response);
			}
			
			else if (type.equals("yes")) {
				tamVangRepository.updateTrangthai(mahs,"Đã duyệt");
				request.setAttribute("success", "Duyệt hồ sơ thành công!");
				EmailUtils.sendEmailNoti("testdanh26@gmail.com", "tạm vắng", mahs, " đã được duyệt");
				request.setAttribute("hoso", tamVangRepository.getDanhsachHoso("Đã duyệt"));
				request.setAttribute("slhoso", tamVangRepository.getDanhsachHoso("Đã duyệt").size());
				request.setAttribute("trangthai", 1);
				request.getRequestDispatcher("DuyetTamVang.jsp").forward(request, response);
				
			}
			
			else {
				tamVangRepository.updateTrangthai(mahs,"Đã hủy");
				request.setAttribute("success", "Hủy hồ sơ thành công!");
				EmailUtils.sendEmailNoti("testdanh26@gmail.com", "tạm vắng", mahs, " đã bị hủy");
				request.setAttribute("hoso", tamVangRepository.getDanhsachHoso("Đã duyệt"));
				request.setAttribute("slhoso", tamVangRepository.getDanhsachHoso("Đã duyệt").size());
				request.setAttribute("trangthai", 1);
				request.getRequestDispatcher("DuyetTamVang.jsp").forward(request, response);
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
