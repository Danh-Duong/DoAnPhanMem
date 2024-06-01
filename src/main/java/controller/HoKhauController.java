package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.itextpdf.text.DocumentException;

import model.HoKhau;
import repository.HoKhauRepository;
import utils.ExcelUtils;
import utils.PDFUtils;

@WebServlet("/hokhau")
public class HoKhauController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HoKhauController() {
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
		HoKhauRepository hoKhauRepository = new HoKhauRepository();

		String mahk = request.getParameter("mahk");
		String trangthai = request.getParameter("tinhtrang");

		String tungay = request.getParameter("ngaybd");
		String denngay = request.getParameter("ngaykt");
		String export = request.getParameter("export");
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		int pageInt = page == null ? 1 : Integer.parseInt(page); // lấy số trang hiện tại
		int pageSizeInt = pageSize == null ? 10 : Integer.parseInt(pageSize); // số hộ khẩu hiển thị trên 1 trang
		int offset = (pageInt - 1) * pageSizeInt; // vị trí bắt đầu lấy dữ liệu

		int totalRecords = hoKhauRepository.countFromHoKhaus();
		int totalPages = (int) Math.ceil(totalRecords / (double) pageSizeInt);

		List<HoKhau> hoKhaus = hoKhauRepository.getHoKhausByPage(offset, pageSizeInt);
		
		List<HoKhau> result = new ArrayList<HoKhau>();
		for (HoKhau hk : hoKhaus) {
			if (matchesMaHK(hk, mahk) && matchesNgay(hk, tungay, denngay) && matchesTinhTrang(hk, trangthai)) {
				result.add(hk); // đưa dữ liệu lọc vào result để trả về
			}
		}
		
		if (export!=null && export.equals("excel")) {
			List<String> content=new ArrayList<String>();
			if (mahk!=null)
				content.add("Mã hộ khẩu: " + mahk);
			if (tungay!=null || denngay!=null)
				content.add("Từ ngày: " + tungay + " - Đến ngày: " + denngay);
			if (trangthai!=null)
				content.add("Trạng thái: " + (trangthai=="0"?"Chờ xét duyệt":"Đã xét duyệt"));
			String url = ExcelUtils.exportToExcel(content,result);
			request.setAttribute("success", "Xuất file excel thành công, đường dẫn: " + url);
		}
		if (export!=null && export.equals("pdf")) {
			OutputStream outputStream = response.getOutputStream();
          try {
				PDFUtils.exportToPDF(outputStream, result);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          outputStream.flush();
		}
		

		request.setAttribute("totalPages", totalPages);
		request.setAttribute("hokhaus", result);
		request.setAttribute("currentPage", pageInt);
		request.setAttribute("currentPageSize", pageSizeInt);
		request.setAttribute("mahk", mahk);
		request.setAttribute("trangthai", trangthai);
		request.setAttribute("tungay", tungay);
		request.setAttribute("denngay", denngay);
		
		request.getRequestDispatcher("HoKhauReport.jsp").forward(request, response);
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

	private boolean matchesMaHK(HoKhau hoKhau, String mahk) {
		if (mahk == null || mahk.isEmpty()) {
			return true;
		}
		return hoKhau.getIdHoKhau().equalsIgnoreCase(mahk);
	}

	private boolean matchesNgay(HoKhau hoKhau, String ngayBd, String ngayKT) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if ((ngayBd == null && ngayKT == null) || (ngayBd.isEmpty() && ngayKT.isEmpty())) {
				return true;
			} else if (ngayKT != null && ngayBd.isEmpty()) {
				return hoKhau.getNgayDangKi().before(sdf.parse(ngayKT));
			} else if (ngayBd != null && ngayKT.isEmpty()) {
				return hoKhau.getNgayDangKi().after(sdf.parse(ngayBd));
			}
			return (hoKhau.getNgayDangKi().after(sdf.parse(ngayBd))
					&& hoKhau.getNgayDangKi().before(sdf.parse(ngayKT)));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return false;
		}
	}
	
	private boolean matchesTinhTrang(HoKhau hoKhau, String tinhtrang) {
		if (tinhtrang == null || tinhtrang.isEmpty() || tinhtrang.equals("Tất cả")) {
			return true;
		}
		boolean tt = tinhtrang.equals("1")?true:false;
		return hoKhau.isTrangThai()==tt;
	}

}
