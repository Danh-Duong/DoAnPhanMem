/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet;

import Dao.TamVangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TamVang;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="TamVangServlet", urlPatterns={"/TamVangServlet"})
public class TamVangServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TamVangServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TamVangServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String maTamVang = request.getParameter("maTamVang");
        String ngayDangKi = request.getParameter("ngayDangKi");
        String diaChiDen = request.getParameter("diaChiDen");
        String lyDo = request.getParameter("lyDo");
        // X? lý các thông tin khác n?u c?n
        
        // T?o ??i t??ng TamVang
        TamVang tamVang = new TamVang();
        tamVang.setMaTamVang(maTamVang);
        // Set các thông tin khác cho ??i t??ng tamVang
        
        // G?i ph??ng th?c insert c?a l?p DAO ?? thêm vào c? s? d? li?u
        TamVangDAO tamVangDAO = new TamVangDAO();
        tamVangDAO.insert(tamVang);
        
        // Redirect ho?c forward ng??i dùng ??n trang thích h?p
        response.sendRedirect("info_tamvang.jsp");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
