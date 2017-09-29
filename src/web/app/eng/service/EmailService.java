package web.app.eng.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import web.app.eng.dto.User;

public class EmailService {
	
    public static void sendEmail(String toAddress, String title, String content) throws MessagingException {
        final Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        properties.put("mail.user", "unswbook.server@gmail.com");
        properties.put("mail.password", "zaq12345");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String user     = properties.getProperty("mail.user");
                String password = properties.getProperty("mail.password");
            	return new PasswordAuthentication(user, password);
            }
        };
        
        Session session = Session.getInstance(properties, authenticator);
        MimeMessage mimeMessage = new MimeMessage(session);
        InternetAddress from = new InternetAddress(properties.getProperty("mail.user"));
        mimeMessage.setFrom(from);
        InternetAddress to = new InternetAddress(toAddress);
        mimeMessage.setRecipient(RecipientType.TO, to);
        mimeMessage.setSubject(title);
        mimeMessage.setContent(content, "text/html;charset=UTF-8");
        Transport.send(mimeMessage);
    }
    
    public static void sendVerificationEmail(User user) throws MessagingException {
        String to = user.getEmail();
        String title = "UNSWBook Account: Email address verification";
        String content = "<p>" +
				"This is an automatically generated email from UNSWBook.<br/>" +
				"<br/>" +
				"--------------------------------------------------<br/>" +
				"Hi " + user.getFirstname() + " " + user.getSurname() + "<br/>" +
				"<br/>" +
				"Thank you for registering for a UNSWBook Account.<br/>" +
				"<br/>" +
				"Help us secure your account by verifying your email \n" +
				"<a href=\"http://localhost:8080/Ass2SocialMedia/control?username=" + user.getUsername() + "&action=confirm" + "\" target=\"_top\">" +
				"http://localhost:8080/Ass2SocialMedia/control?username=" + user.getUsername() + "&action=confirm" +
				"</a><br/>" +
				"<br/>" +
				"If you do not know why you have received this email, please delete this email.<br/>" +
				"<br/>" +
				"--------------------------------------------------<br/>" +
				"You cannot reply to this email address." +
				"</p>";
        sendEmail(to, title, content);
    }
    
}
