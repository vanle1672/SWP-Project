package Control.Auth;

import jakarta.servlet.http.HttpServletRequest;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Mail {
    public static String getHost(HttpServletRequest request) {
        String domain = request.getServerName();
        String protocol = request.getScheme();
        int port = request.getServerPort();
        String context = request.getContextPath();
        return protocol + "://" + domain + ":" + port + context;
    }

    public static boolean verify_email(String mailto, String name, String uuid, String host) {
        System.out.println("vao ham send mail");
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true"); // if authentication is required
        properties.put("mail.smtp.starttls.enable", "true"); // if using TLS
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("phongkhamantam23@gmail.com", "mjfzwgjyhgjexbhs");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("phongkhamantam23@gmail.com", "PHÒNG KHÁM AN TÂM"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailto));
            message.setSubject("Verify Email.");
            String html = "<h1>Xin chào " + name + ", chào mừng bạn đến với An Tâm. Để kích hoạt tài khoản vui lòng nhấn vào <a href='" + host + "/active/" + uuid + "'>đây.</a></h1>";
            message.setContent(html, "text/html; charset=UTF-8");

            // Send the email
            Transport.send(message);
            System.out.println("mail sent");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean forgot_password(String mailto, String uuid, String host) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true"); // if authentication is required
        properties.put("mail.smtp.starttls.enable", "true"); // if using TLS
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("phongkhamantam23@gmail.com", "mjfzwgjyhgjexbhs");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("phongkhamantam23@gmail.com", "PHÒNG KHÁM AN TÂM"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailto));
            message.setSubject("Reset Password");
            String html = "<h1>Vui lòng nhấn vào <a href='" + host + "/get-password?verify_key=" + uuid + "'> đây </a>để đặt mật khẩu mới.</h1>";
            message.setContent(html, "text/html; charset=UTF-8");

            // Send the email
            Transport.send(message);
            System.out.println("mail sent");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
