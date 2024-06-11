package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NhanKhau;
import model.TamTru;
import model.TamVang;
import repository.NhanKhauRepository;
import repository.TamTruRepository;
import repository.TamVangRepository;
import utils.EmailUtils;

/**
 * Servlet implementation class DuyetTamTruController
 */
@WebServlet("/duyetTamTru")
public class DuyetTamTruController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuyetTamTruController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TamTruRepository tamTruRepository = new TamTruRepository();

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
				
			
			request.setAttribute("hoso", tamTruRepository.getDanhsachHoso(tt));
			request.setAttribute("slhoso", tamTruRepository.getDanhsachHoso(tt).size());
			request.setAttribute("trangthai", trangthai);
			request.getRequestDispatcher("DuyetTamTru.jsp").forward(request, response);
		} 
		else {
			String type = request.getParameter("type");
			TamTru tamtru = tamTruRepository.getHosoById(mahs);

			if (type == null) {
				SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

				if (tamtru.getTrangThaiDuyet().equals("Chờ xét duyệt"))
					request.setAttribute("trangthai", "0");
				
				String ns = outputFormat.format(tamtru.getNgaySinh());
				request.setAttribute("ns", ns);
				request.setAttribute("tamtru", tamtru);
				request.getRequestDispatcher("ChitietTamTru.jsp").forward(request, response);
			}
			
			else if (type.equals("yes")) {
				tamTruRepository.updateTrangthai(mahs,"Đã duyệt");
				request.setAttribute("success", "Duyệt hồ sơ thành công!");
				EmailUtils.sendEmailNoti("testdanh26@gmail.com", "tạm trú", mahs, " đã được duyệt");
				request.setAttribute("hoso", tamTruRepository.getDanhsachHoso("Đã duyệt"));
				request.setAttribute("slhoso", tamTruRepository.getDanhsachHoso("Đã duyệt").size());
				request.setAttribute("trangthai", 1);
				request.getRequestDispatcher("DuyetTamTru.jsp").forward(request, response);
				
			}
			
			else {
				tamTruRepository.updateTrangthai(mahs,"Đã hủy");
				request.setAttribute("success", "Hủy hồ sơ thành công!");
				EmailUtils.sendEmailNoti("testdanh26@gmail.com", "tạm trú", mahs, " đã bị hủy");
				request.setAttribute("hoso", tamTruRepository.getDanhsachHoso("Đã duyệt"));
				request.setAttribute("slhoso", tamTruRepository.getDanhsachHoso("Đã duyệt").size());
				request.setAttribute("trangthai", 1);
				request.getRequestDispatcher("DuyetTamTru.jsp").forward(request, response);
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
