package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TamTru;
import repository.NhanKhauRepository;
import repository.TamTruRepository;

@WebServlet(name = "DangKyTamTru", urlPatterns = {"/DangKyTamTru"})
public class DangKyTamTru extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DangKyTamTru() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String soCCCD = request.getParameter("soCCCD");
        String diaChiCuThe = request.getParameter("diaChiCuThe");
        String ngayBatDauTru = request.getParameter("ngayBatDauTru");
        String ngayKetThucTru = request.getParameter("ngayKetThucTru");
        String lyDo = request.getParameter("lyDo");
        String idnk = null;

        NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (soCCCD != null) {
            idnk = nhanKhauRepository.getIdByCCCD(soCCCD);
        }

        if (soCCCD == null || diaChiCuThe == null || ngayBatDauTru == null || ngayKetThucTru == null || lyDo == null) {
            request.setAttribute("error", "Vui lòng ?i?n ??y ?? thông tin");
            request.getRequestDispatcher("DangKiTamTru.jsp").forward(request, response);
        } else {
            TamTruRepository tamTruRepository = new TamTruRepository();
            try {
                TamTru tamTru = new TamTru(tamTruRepository.getNewMaTamTru(), new Date(), diaChiCuThe, lyDo, idnk, sdf.parse(ngayBatDauTru), sdf.parse(ngayKetThucTru), "Ch? xét duy?t");
                tamTruRepository.saveTamTru(tamTru);
                response.sendRedirect("/DoAnPhanMem/");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for registering temporary residence";
    }
    
}
