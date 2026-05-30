package ex20.logisticsprovider;

/**
 * Sends notifications about processed orders. Owned by LogisticsProvider and
 * MUST NOT be modified by us. LogisticsProvider does not publish an interface
 * for this service.
 */
public class NotificationSender {

    public void send(String orderId) {
        System.out.println("[NotificationSender] Preparing notification payload for order " + orderId + "...");
        System.out.println("[NotificationSender] Resolving recipient address via CRM lookup...");
        System.out.println("[NotificationSender] Rendering message template (locale=de_DE)...");
        System.out.println("[NotificationSender] Connecting to SMTP relay smtp.logisticsprovider.example...");
        System.out.println("[NotificationSender] Dispatching message... done.");
    }
}
