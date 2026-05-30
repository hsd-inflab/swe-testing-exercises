package ex06.notificationservice;

/**
 * Sends password reset mails through an external mail provider. Owned by
 * NotificationService and must not be modified by us.
 */
public class RemotePasswordResetMailSender implements PasswordResetMailSender {

    @Override
    public void sendPasswordResetMail(String recipientEmail, String subject, String body) {
        System.out.println("[MailService] Opening connection to mail-service.example...");
        System.out.println("[MailService] Recipient: " + recipientEmail);
        System.out.println("[MailService] Subject: " + subject);
        System.out.println("[MailService] Body: " + body);
        System.out.println("[MailService] Sending password reset mail... done.");
    }
}
