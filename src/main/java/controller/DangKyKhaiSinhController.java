package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import model.KhaiSinh;
import model.NhanKhau;
import repository.KhaiSinhRepository;
import repository.NhanKhauRepository;
import repository.TaiKhoanRepository;
import utils.CookieUtils;
import utils.EmailUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class ThemKhaiSinh
 */
@WebServlet("/khaisinh")
public class DangKyKhaiSinhController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyKhaiSinhController() {
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
			List<String> ETHNIC = getData(
					"http://api.nosomovo.xyz/ethnic/getalllist?_gl=1*zcyui6*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..",
					"name");

			request.setAttribute("ETHNIC", ETHNIC);
			request.setAttribute("COUNTRY", COUNTRY);
			request.getRequestDispatcher("DangkyKhaiSinh.jsp").forward(request, response);
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		KhaiSinhRepository khaiSinhRepository = new KhaiSinhRepository();
		NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();

		String maDangKiKhaiSinh = khaiSinhRepository.getNewMaKhaiSinh();
		String idHoKhau = nhanKhauRepository.getIdHoKhauByCCCD(CookieUtils.getCookieByName(request, "cccd"));
		String hoTen = request.getParameter("hoTen");
		Date ngaySinh = null;
		try {
			if (!request.getParameter("ngaySinh").equals(""))
				ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gioiTinh = request.getParameter("gioiTinh");
		String quocTich = request.getParameter("quocTich");
		String danToc = request.getParameter("danToc");
		String noiSinh = request.getParameter("noiSinh");
		String queQuan = request.getParameter("queQuan");
		String nguoidangky = request.getParameter("nguoidangky");
		String idNhanKhauCha = nhanKhauRepository.getIdByCCCD(request.getParameter("cccdCha"));
		String idNhanKhauMe = nhanKhauRepository.getIdByCCCD(request.getParameter("cccdMe"));

		String quanHeNguoiKhaiSinh = request.getParameter("quanHeNguoiKhaiSinh");

		if (hoTen == null || ngaySinh == null || gioiTinh == null || quocTich == null || danToc == null
				|| noiSinh == null || queQuan == null || idNhanKhauCha == null || idNhanKhauMe == null) {
			request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin cần thiết");
			request.getRequestDispatcher("DangkyKhaiSinh.jsp").forward(request, response);
		} else {
			KhaiSinh khaiSinh = new KhaiSinh(maDangKiKhaiSinh, idHoKhau, nguoidangky, new Date(), hoTen, ngaySinh,
					gioiTinh, quocTich, danToc, noiSinh, queQuan, "Đà Nẵng", idNhanKhauCha, idNhanKhauMe,
					quanHeNguoiKhaiSinh, "Chờ xét duyệt", CookieUtils.getCookieByName(request, "cccd"));
			if (khaiSinhRepository.saveKhaiSinh(khaiSinh)) {
				TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();
				EmailUtils.sendEmail(request.getParameter("nguoiyeucau"),
						taiKhoanRepository.getEmailByCCCD(CookieUtils.getCookieByName(request, "cccd")),
						maDangKiKhaiSinh, "khai sinh");

				request.setAttribute("madangky", maDangKiKhaiSinh);
				request.setAttribute("hoso", "khai sinh");
				request.getRequestDispatcher("DangkyThanhCong.jsp").forward(request, response);
			} else {
				List<String> COUNTRY = getData(
						"http://api.nosomovo.xyz/country/getalllist?_gl=1*1jgm3in*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..",
						"name_vi");
				List<String> ETHNIC = getData(
						"http://api.nosomovo.xyz/ethnic/getalllist?_gl=1*zcyui6*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..",
						"name");

				request.setAttribute("ETHNIC", ETHNIC);
				request.setAttribute("COUNTRY", COUNTRY);
				request.setAttribute("error", "Có lỗi xảy ra. Vui lòng thử lại.");
				request.getRequestDispatcher("DangkyKhaiSinh.jsp").forward(request, response);
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
