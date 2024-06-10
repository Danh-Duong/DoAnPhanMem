package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.KhaiSinh;
import model.NhanKhau;
import model.NhanKhau;
import model.TamTru;
import repository.NhanKhauRepository;
import repository.TamTruRepository;


@WebServlet(name = "DuyetTamTruController", urlPatterns = {"/duyetTamTru"})
public class DuyetTamTruController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public DuyetTamTruController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TamTruRepository tamTruRepository = new TamTruRepository();

        String mahs = request.getParameter("mahs");
        String trangthai = request.getParameter("trangthai");

        String tt = "";

        if (mahs == null) {
            if (trangthai == null || trangthai.equals("1")) {
                tt = "?ã duy?t";
                trangthai = "1";
            } else if (trangthai.equals("0"))
                tt = "Ch? xét duy?t";
            else
                tt = "?ã h?y";

            request.setAttribute("hoso", tamTruRepository.getDanhsachHoso(tt));
            request.setAttribute("slhoso", tamTruRepository.getDanhsachHoso(tt).size());
            request.setAttribute("trangthai", trangthai);
            request.getRequestDispatcher("DuyetTamTru.jsp").forward(request, response);
        } else {
            String type = request.getParameter("type");
            TamTru tt = tamTruRepository.getHosoById(mahs);
            NhanKhauRepository nhanKhauRepository = new NhanKhauRepository();

            if (type == null) {
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                String nbd = outputFormat.format(tt.getNgayBatDau());
                String nkt = outputFormat.format(tt.getNgayKetThuc());
                String ndk = outputFormat.format(tt.getNgayDangKi());
                request.setAttribute("nbd", nbd);
                request.setAttribute("nkt", nkt);
                request.setAttribute("ndk", ndk);
                request.setAttribute("tamtru", tt);

                if (tt.getTrangThaiDuyet().equals("Ch? xét duy?t"))
                    request.setAttribute("trangthai", "0");

                NhanKhau nhanKhau = nhanKhauRepository.getNhanKhauById(tt.getIdNhanKhau());
                request.setAttribute("nhankhau", nhanKhau);
                String ns = outputFormat.format(nhanKhauRepository.getNhanKhauById(tt.getIdNhanKhau()).getNgaySinh());
                request.setAttribute("ns", ns);
                request.getRequestDispatcher("ChitietTamTru.jsp").forward(request, response);
            } else if (type.equals("yes")) {
                tamTruRepository.updateTrangthai(mahs, "?ã duy?t");
                request.setAttribute("success", "Duy?t h? s? thành công!");
                request.setAttribute("hoso", tamTruRepository.getDanhsachHoso("?ã duy?t"));
                request.setAttribute("slhoso", tamTruRepository.getDanhsachHoso("?ã duy?t").size());
                request.setAttribute("trangthai", 1);
                request.getRequestDispatcher("DuyetTamTru.jsp").forward(request, response);
            } else {
                tamTruRepository.updateTrangthai(mahs, "?ã h?y");
                request.setAttribute("success", "H?y h? s? thành công!");
                request.setAttribute("hoso", tamTruRepository.getDanhsachHoso("?ã duy?t"));
                request.setAttribute("slhoso", tamTruRepository.getDanhsachHoso("?ã duy?t").size());
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
