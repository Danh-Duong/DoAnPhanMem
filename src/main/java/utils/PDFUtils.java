package utils;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.HoKhau;

public class PDFUtils {
	public static void exportToPDF(OutputStream outputStream, List<HoKhau> hoKhaus) throws DocumentException {
        // Tạo một đối tượng Document
        Document document = new Document();
        // Tạo một đối tượng PdfWriter để ghi dữ liệu vào document
        PdfWriter.getInstance(document, outputStream);
        document.open();
        // Thêm nội dung vào file PDF
        
        Paragraph paragraph = new Paragraph("HOKHAU");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);

       
        PdfPTable table = new PdfPTable(7);
        table.setSpacingBefore(10);
        // Thêm header cho bảng
        table.addCell("STT");
        table.addCell("Id");
        table.addCell("Address");
        table.addCell("Time");
        table.addCell("Status");
        table.addCell("Member");
        table.addCell("Note");
        
        // Thêm dữ liệu vào bảng
        for (int i = 0; i < hoKhaus.size(); i++) {
            HoKhau hoKhau = hoKhaus.get(i);
  
            table.addCell(i+1 +"");
            table.addCell(hoKhau.getIdHoKhau());
            table.addCell(hoKhau.getDiaChiThuongTru());
            table.addCell(hoKhau.getNgayDangKi()+"");
            table.addCell(hoKhau.isTrangThai()==true?"Đã xét duyệt":"Chưa xét duyệt");
            table.addCell(hoKhau.getSoLuong()+"");
            table.addCell(hoKhau.getGhiChu());
        }
        // Thêm bảng vào tài liệu
        document.add(table);
        document.close();
    }
}
