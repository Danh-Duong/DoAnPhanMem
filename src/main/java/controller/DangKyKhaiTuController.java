package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
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

import model.KhaiTu;
import repository.KhaiTuRepository;

@WebServlet("/khaitu")
public class DangKyKhaiTuController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DangKyKhaiTuController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> COUNTRY= getData("http://api.nosomovo.xyz/country/getalllist?_gl=1*1jgm3in*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..", "name_vi");
		List<String> ETHNIC = getData("http://api.nosomovo.xyz/ethnic/getalllist?_gl=1*zcyui6*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..", "name");
		
		request.setAttribute("ETHNIC", ETHNIC);
		request.setAttribute("COUNTRY", COUNTRY);
		request.getRequestDispatcher("DangKiKhaiTu.jsp").forward(request, response);
	}


    

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        KhaiTuRepository khaiTuRepository = new KhaiTuRepository();

        // Get information from the registration form
        String maKhaiTu = khaiTuRepository.getNewMaKhaiTu();
        String idNhanKhau = "NK0005"; // Placeholder, should be retrieved properly
        String hoTenNguoiKhai = request.getParameter("hoTenNguoiKhai");
        String noiCuTruNguoiKhai = request.getParameter("noiCuTruNguoiKhai");
        String hoTenNguoiMat = request.getParameter("hoTenNguoiMat");
        Date ngaySinh = null;
        try {
            ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String noiSinh = request.getParameter("noiSinh");
        String gioiTinh = request.getParameter("gioiTinh");
        String quocTich = request.getParameter("quocTich");
        String danToc = request.getParameter("danToc");
        String noiCuTruCuoiCung = request.getParameter("noiCuTruCuoiCung");
        Date ngayMat = null;
        try {
            ngayMat = sdf.parse(request.getParameter("ngayMat"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String gioMatStr = request.getParameter("gioMat");
        Time gioMat = Time.valueOf(gioMatStr);
        String nguyenNhan = request.getParameter("nguyenNhan");
        String noiDangKi = request.getParameter("noiDangKi");
        Date ngayDangKi = null;
        try {
            ngayDangKi = sdf.parse(request.getParameter("ngayDangKi"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String quanHeVoiNguoiMat = request.getParameter("quanHeVoiNguoiMat");
        String trangThaiDuyet = "Chờ duyệt";

        // Validate input data
        if (maKhaiTu == null || idNhanKhau == null || hoTenNguoiKhai == null || noiCuTruNguoiKhai == null ||
            hoTenNguoiMat == null || ngaySinh == null || noiSinh == null || gioiTinh == null || quocTich == null ||
            danToc == null || noiCuTruCuoiCung == null || ngayMat == null || gioMat == null || nguyenNhan == null ||
            noiDangKi == null || ngayDangKi == null || quanHeVoiNguoiMat == null) {
            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin cần thiết");
            request.getRequestDispatcher("DangKiKhaiTu.jsp").forward(request, response);
        } else {
            // Create a KhaiTu object from the information obtained
            KhaiTu khaiTu = new KhaiTu(maKhaiTu, idNhanKhau, hoTenNguoiKhai, noiCuTruNguoiKhai, hoTenNguoiMat, ngaySinh,
                    noiSinh, gioiTinh, quocTich, danToc, noiCuTruCuoiCung, ngayMat, gioMat, nguyenNhan, noiDangKi,
                    ngayDangKi, quanHeVoiNguoiMat, trangThaiDuyet);

            // Save the death registration information to the database
            boolean result = khaiTuRepository.saveKhaiTu(khaiTu);

            if (result) {
                // If saved successfully, redirect to the success notification page
                request.setAttribute("maKhaiTu", maKhaiTu);
                request.getRequestDispatcher("KhaiTuThanhCong.jsp").forward(request, response);
            } else {
                // If not successful, return to the registration page with an error message
                request.setAttribute("error", "Có lỗi xảy ra. Vui lòng thử lại.");
                request.getRequestDispatcher("DangKiKhaiTu.jsp").forward(request, response);
            }
        }
    }
	
	public static List<String> getData(String urlString, String atr) {
		try {
            // Đường dẫn URL cần lấy dữ liệu JSON
//            String urlString = "http://api.nosomovo.xyz/ethnic/getalllist?_gl=1*lj2iun*_ga*MjQ1MTcwNjMyLjE3MTcwODQzODg.*_ga_XW6CMNCYH8*MTcxNzA4NDM4Ny4xLjEuMTcxNzA4NDQwNS4wLjAuMA..";

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

                // Lặp qua từng phần tử của mảng JSON và thêm giá trị của thuộc tính name vào List
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