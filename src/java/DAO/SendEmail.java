/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ASUS
 */
public class SendEmail {
    String fromEmail;
    String pass;
    
    public String getRandom(){
        Random rnd = new Random();
        int otp = rnd.nextInt(999999);
        return String.format("%06d", otp);
    }
    
    public boolean sendEmail(String toEmail, String otp){
        boolean success = false;
        fromEmail = "phongkhamantam23@gmail.com";
        pass = "mjfzwgjyhgjexbhs";
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            
            Session session = Session.getInstance(props, new Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail, pass);
                }       
            });
            
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            
            message.setSubject("OTP đặt lại mật khẩu ");
            message.setText("Mã OTP của bạn là: " + otp);
            Transport.send(message);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
    

