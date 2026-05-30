package ex06.notificationservice;

public interface PasswordResetMailSender {

    void sendPasswordResetMail(String recipientEmail, String subject, String body);
}
