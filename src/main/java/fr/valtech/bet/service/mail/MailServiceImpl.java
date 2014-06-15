package fr.valtech.bet.service.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailServiceImpl  implements MailService{

    public static final String USERNAME = "valtechbet@gmail.com";

    public static final String PASSWORD = "ZlatanBet10";

    public static final String SMTP_HOST = "smtp.gmail.com";

    public static final String SMTP_HOST_PORT = "587";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void send(String subject, String body, String to) {
        Session session = Session.getInstance(buildProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            logger.info("Email has been sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    private Properties buildProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_HOST_PORT);
        return properties;
    }
}
