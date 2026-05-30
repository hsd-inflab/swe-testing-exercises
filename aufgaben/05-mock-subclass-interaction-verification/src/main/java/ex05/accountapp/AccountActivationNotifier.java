package ex05.accountapp;

import ex05.notificationservice.RemoteNotificationSender;

/**
 * Owned by our team and may be tested directly.
 */
public class AccountActivationNotifier {

    private final RemoteNotificationSender notificationSender;

    public AccountActivationNotifier(RemoteNotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void notifyAccountActivated(String customerName, String recipientEmail) {
        System.out.println("[AccountApp] Preparing activation notification for " + customerName + "...");

        String subject = "Your account is active";
        String body = "Hello " + customerName + ", your account has been activated.";

        notificationSender.send(recipientEmail, subject, body);

        System.out.println("[AccountApp] Activation notification handed over.");
    }
}
