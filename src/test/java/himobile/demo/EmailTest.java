package himobile.demo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailTest {

	public static void main(String[] args) {
		
		//xxx--i can't able to specify is my friends personal ids
		 
        String mailSmtpHost = "xxx.com";
 
        String mailTo = "xxx.j@xxx.com";
        String mailCc = "xxx.j@xxx.com";
        String mailFrom = "xxx.j@xxx.com";
        String mailSubject = "Email from Java";
        String mailText = "This is an email from Java";
 
        sendEmail(mailTo, mailCc, mailFrom, mailSubject, mailText, mailSmtpHost);
    }
 
    public static void sendEmail(String to, String cc, String from, String subject, String text, String smtpHost) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", smtpHost);
            Session emailSession = Session.getDefaultInstance(properties);
 
            Message emailMessage = new MimeMessage(emailSession);
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            emailMessage.setFrom(new InternetAddress(from));
            emailMessage.setSubject(subject);
            emailMessage.setText(text);
 
            emailSession.setDebug(true);
 
            Transport.send(emailMessage);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

	}

}
