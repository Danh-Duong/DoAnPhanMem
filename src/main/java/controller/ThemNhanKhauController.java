package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;

import model.NhanKhau;
import repository.HoKhauRepository;
import repository.NhanKhauRepository;

/**
 * Servlet implementation class ThemNhanKhauController
 */
@WebServlet("/nhan-khau")
public class ThemNhanKhauController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemNhanKhauController() {
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
		String mank = request.getParameter("mank");
		List<String> COUNTRY = getData(
				"http://api.nosomovo.xyz/country/getalllist?_gl=1*1jgm3in*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..",
				"name_vi");
		List<String> ETHNIC = getData(
				"http://api.nosomovo.xyz/ethnic/getalllist?_gl=1*zcyui6*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..",
				"name");

		request.setAttribute("ETHNIC", ETHNIC);
		request.setAttribute("COUNTRY", COUNTRY);

		HoKhauRepository hoKhauRepository = new HoKhauRepository();
		request.setAttribute("hokhaus", hoKhauRepository.getAll());

		if (mank != null) {
			NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();
			NhanKhau nhanKhau = nhanKhauRepository.getNhanKhauById(mank);
			request.setAttribute("nhankhau", nhanKhau);
		}
		request.getRequestDispatcher("TaoMoiNhanKhau.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();

		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/img"); // lấy đường dẫn để lưu hình ảnh
//		MultipartRequest multi = new MultipartRequest(request, realpath);
		MultipartRequest multi = new MultipartRequest(request, realpath, 10 * 1024 * 1024, "UTF-8");

//		khởi tạo biến lưu thông tin sản phẩm cần tạo mới hay cập nhập
		String image = null;
		String tenCongDan = null;
		String cccd = null;
		String gioiTinh = null;
		String quanHe = null;
		String ngaySinh = null;
		String mahk = null;
		String quocTich = null;
		String danToc = null;
		String noiOHienTai = null;
		String noiSinh = null;
		String tinhTrangHocVan = null;
		String tinhTrangHonNhan = null;
		String ngheNghiep = null;
		String mank = null;
		try {

			image = multi.getFilesystemName("avatar");
			tenCongDan = multi.getParameter("tenCongDan");
			cccd = multi.getParameter("cccd");
			gioiTinh = multi.getParameter("gioiTinh");
			quanHe = multi.getParameter("quanHe");
			ngaySinh = multi.getParameter("ngaySinh");
			mahk = multi.getParameter("mahk");
			quocTich = multi.getParameter("quocTich");
			danToc = multi.getParameter("danToc");
			noiOHienTai = multi.getParameter("noiOHienTai");
			noiSinh = multi.getParameter("noiSinh");
			tinhTrangHocVan = multi.getParameter("tinhTrangHocVan");
			tinhTrangHonNhan = multi.getParameter("tinhTrangHonNhan");
			ngheNghiep = multi.getParameter("ngheNghiep");
			mank = multi.getParameter("mank");
		} catch (Exception e) {
			e.printStackTrace();
		}

//		nếu tham số masp = null thì thực hiện việc tạo mới sản phẩm
		if (mank == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			NhanKhau nhanKhau;
			try {

				nhanKhau = new NhanKhau(mank, mahk, tenCongDan, cccd, sdf.parse(ngaySinh), gioiTinh, noiOHienTai,
						noiSinh, quanHe, quocTich, danToc, ngheNghiep, tinhTrangHocVan, tinhTrangHonNhan, image);
				System.out.println("Danh: " + nhanKhau.toString());
				if (nhanKhauRepository.saveNhanKhau1(nhanKhau, nhanKhauRepository.getNewMaNhanKhau())) {
					request.setAttribute("success", "Tạo mới nhân khẩu thành công"); // thông báo tạo sản phẩm thành
																						// công
					response.sendRedirect("nhankhau");
				}

				else {
					request.setAttribute("error", "Tạo mới nhân khẩu thất bại"); // thông báo tạo sản phẩm thất bại
					request.getRequestDispatcher("TaoMoiNhanKhau.jsp").forward(request, response);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else {
			if (image == null) {
				image = nhanKhauRepository.getNhanKhauById(mank).getImage();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			NhanKhau nhanKhau;
			try {
				nhanKhau = new NhanKhau(mank, mahk, tenCongDan, cccd, sdf.parse(ngaySinh), gioiTinh, noiOHienTai,
						noiSinh, quanHe, quocTich, danToc, ngheNghiep, tinhTrangHocVan, tinhTrangHonNhan, image);
				System.out.println("Danh: " + nhanKhau.toString());
				if (nhanKhauRepository.updateNhankhau(nhanKhau, mank)) {
					request.setAttribute("success", "Cập nhập thông tin nhân khẩu thành công"); // thông báo cập nhập
																								// sản phẩm thành công
					response.sendRedirect("nhankhau");
				} else {
					request.setAttribute("error", "Tạo sản phẩm thất baị"); // thông báo cập nhập sản phẩm thất bại
					request.getRequestDispatcher("TaoMoiNhanKhau.jsp").forward(request, response);
				}
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
