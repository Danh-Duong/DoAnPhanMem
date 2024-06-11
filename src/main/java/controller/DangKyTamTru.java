package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.TamTru;
import model.TamVang;
import repository.NhanKhauRepository;
import repository.TamTruRepository;
import repository.TamVangRepository;
import utils.CookieUtils;

/**
 * Servlet implementation class DangKyTamTru
 */
@WebServlet("/tamtru")
public class DangKyTamTru extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyTamTru() {
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
		String cccd = CookieUtils.getCookieByName(request, "cccd");
		if (cccd == null) {
			response.sendRedirect("login");
		} else {
			List<String> COUNTRY = getData(
					"http://api.nosomovo.xyz/country/getalllist?_gl=1*1jgm3in*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..",
					"name_vi");
			request.setAttribute("COUNTRY", COUNTRY);
			request.getRequestDispatcher("DangKiTamTru.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String hoTen = request.getParameter("hoTen");
		String ngaySinh = request.getParameter("ngaySinh");
		String gioiTinh = request.getParameter("gioiTinh");
		String cccd = request.getParameter("cccd");
		String quocTich = request.getParameter("quocTich");
		String soDT = request.getParameter("soDT");
		String diaChiCuThe = request.getParameter("diaChiCuThe");
		String diaChiTamTru = request.getParameter("diaChiTamTru");
		String hoTenChuHo = request.getParameter("hoTenChuHo");
		String quanHeChuHo = request.getParameter("quanHeChuHo");
		String socccdChuHo = request.getParameter("socccdChuHo");
		
		TamTruRepository tamTruRepository = new TamTruRepository();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


		if (hoTen == null || ngaySinh == null || gioiTinh == null || cccd == null
				|| diaChiTamTru == null || hoTenChuHo == null|| quanHeChuHo == null|| socccdChuHo == null ) {
			request.setAttribute("error", "Vui lòng điền đầy đủ thông tin");
			request.getRequestDispatcher("DangKiTamTru.jsp").forward(request, response);
		} else {
			try {
				TamTru tamTru = new TamTru(tamTruRepository.getNewMaTamTru(), hoTen, sdf.parse(ngaySinh), gioiTinh, cccd, quocTich, soDT, diaChiCuThe, diaChiTamTru, hoTenChuHo, quanHeChuHo, socccdChuHo, "Chờ xét duyệt");
				tamTruRepository.saveTamTru(tamTru);
				response.sendRedirect("/DoAnPhanMem/");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static List<String> getData(String urlString, String atr) {
		try {
			// Tạo đối tượng URL
			URL url = new URL(urlString);

			// Mở kết nối tới URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Kiểm tra mã phản hồi HTTP
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // thành công
				// Đọc dữ liệu từ InputStream của kết nối
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();

				// Đóng kết nối
				connection.disconnect();

				JSONArray jsonArray = new JSONArray(content.toString());

				// Tạo List để lưu trữ giá trị của thuộc tính name
				List<String> names = new ArrayList<>();

				// Lặp qua từng phần tử của mảng JSON và thêm giá trị của thuộc tính name vào
				// List
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					String name = jsonObject.getString(atr);
					names.add(name);
				}
				return names;
			} else {
				System.out.println("GET request không thành công. Mã phản hồi: " + responseCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
