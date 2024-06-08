package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
	
	public static void sendEmail(String name, String email, String madk, String hoso) {
		Properties props = new Properties();
        props.put("mail.smtp.host", MailConfig.HOST_NAME);
        props.put("mail.smtp.port", MailConfig.PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
 
        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
            }
        });
 
        // compose message
        try {
        	MimeMessage message = new MimeMessage(session);

            // Đặt người nhận
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            // Đặt chủ đề email
            message.setSubject("THÔNG BÁO", "UTF-8");

            // Đặt nội dung email với định dạng HTML
            String htmlContent = "<h1>Xin chào, "+ name +"</h1>"
            		+ "<h2 style='color: green;'>Đăng ký " + hoso + " thành công</h2>"
            		+ "<h3>Mã hồ sơ của bạn là: <span style='color: green; font-size: 28px; font-weight: 600;'>"+ madk+"</span></h3>"
            		+ "<p>Hồ sơ sẽ được giải quyết trong vòng từ 3 - 5 ngày. Chúng tôi sẽ thông báo đến bạn khi hồ sơ hoàn tất.</p>"
            		+ "<p>Xin cảm ơn!</p>";
            message.setContent(htmlContent, "text/html; charset=UTF-8");

            // Gửi email
            Transport.send(message);

            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
        	e.printStackTrace();
            throw new RuntimeException(e);
        }
		
	}

	
}
