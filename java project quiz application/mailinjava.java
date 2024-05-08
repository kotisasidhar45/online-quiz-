import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class mailinjava{
    mailinjava(int scorecard,String username1) throws MessagingException {
        Rules obj = null;
        String username =username1;
        String password = "xxxxgg";
        String recipient = "abc.14@gmail.com";


        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.from", "myemail@gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.debug", "true");

        Session session = Session.getInstance(props, null);
        MimeMessage msg = new MimeMessage(session);

        msg.setRecipients(Message.RecipientType.TO, recipient);
        msg.setSubject("JavaMail hello world example");
        msg.setSentDate(new Date());
        msg.setText("Congratulations...you have achieved  "+scorecard+"/"+"10");
        Transport transport = session.getTransport("smtp");

        transport.connect(username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }
}