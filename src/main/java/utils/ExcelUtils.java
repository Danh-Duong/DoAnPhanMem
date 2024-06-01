package utils;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.HoKhau;

public class ExcelUtils {
	    public static String exportToExcel(List<String> titles, List<HoKhau> hoKhaus) {
	        try {
	            XSSFWorkbook workbook = new XSSFWorkbook();
	            Sheet sheet = workbook.createSheet("Report");

	            SimpleDateFormat format= new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	            int id=0;
	            sheet.createRow(id++).createCell(0).setCellValue("DANH SÁCH HỘ KHẨU");
	            if (titles.size()>0)
	            	for (String title: titles)
	            		sheet.createRow(id++).createCell(0).setCellValue(title);
	            sheet.createRow(id++).createCell(0).setCellValue("Thời gian: " + format.format(new Date()));
	            
	            Row header = sheet.createRow(id++);
	            header.createCell(0).setCellValue("STT");
	            header.createCell(1).setCellValue("Mã hộ khẩu");
	            header.createCell(2).setCellValue("Địa chỉ thường trú");
	            header.createCell(3).setCellValue("Ngày đăng ký");
	            header.createCell(4).setCellValue("Trạng thái");
	            header.createCell(5).setCellValue("Số lượng");
	            header.createCell(6).setCellValue("Ghi chú");                   
	            
	            // Đưa dữ liệu vào data sheet
	            for (int i = 0; i < hoKhaus.size(); i++) {
	                Row row = sheet.createRow(i+id);
	                HoKhau hoKhau = hoKhaus.get(i);
	      
	                row.createCell(0).setCellValue(i+1);
	                row.createCell(1).setCellValue(hoKhau.getIdHoKhau());
	                row.createCell(2).setCellValue(hoKhau.getDiaChiThuongTru());
	                row.createCell(3).setCellValue(hoKhau.getNgayDangKi()+"");
	                row.createCell(4).setCellValue(hoKhau.isTrangThai()==true?"Đã xét duyệt":"Chưa xét duyệt");
	                row.createCell(5).setCellValue(hoKhau.getSoLuong());
	                row.createCell(6).setCellValue(hoKhau.getGhiChu());
	           
	            }
	            
	            File file = new File("HoKhau.xlsx");
	            // Tạo file để lưu trữ workbook
	            FileOutputStream fos = new FileOutputStream(file);
	            workbook.write(fos);
	            fos.close();
	            workbook.close();
	            return file.getAbsolutePath();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

}
