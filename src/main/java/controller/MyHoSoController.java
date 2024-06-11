package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HoSo;
import model.KhaiSinh;
import repository.KhaiSinhRepository;
import utils.CookieUtils;

/**
 * Servlet implementation class MyHoSoController
 */
@WebServlet("/myhoso")
public class MyHoSoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyHoSoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhaiSinhRepository khaiSinhRepository = new KhaiSinhRepository();
		List<KhaiSinh> khaiSinhs = khaiSinhRepository.getAll(CookieUtils.getCookieByName(request, "cccd"));
		List<HoSo> hoSos = new  ArrayList<HoSo>();
		for (KhaiSinh ks: khaiSinhs) {
			hoSos.add(new HoSo(ks.getMaDangKiKhaiSinh(), "Khai sinh", ks.getNgayDangKy(), ks.getTrangThaiDuyet()));
		}
		
		request.setAttribute("hoso", hoSos);
		request.getRequestDispatcher("myhoso.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
