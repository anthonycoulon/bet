package fr.valtech.bet.service.mail;

public interface MailService {
    void send(String subject, String body, String to);
}
