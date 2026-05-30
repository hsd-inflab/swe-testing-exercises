package ex05.notificationservice;

/**
 * Sends notifications through an external notification provider. Owned by
 * NotificationService and must not be modified by us.
 */
public class RemoteNotificationSender {

    public void send(String recipientEmail, String subject, String body) {
        System.out.println("[NotificationService] Opening connection to notification-service.example...");
        System.out.println("[NotificationService] Recipient: " + recipientEmail);
        System.out.println("[NotificationService] Subject: " + subject);
        System.out.println("[NotificationService] Body: " + body);
        System.out.println("[NotificationService] Sending notification... done.");
    }
}
