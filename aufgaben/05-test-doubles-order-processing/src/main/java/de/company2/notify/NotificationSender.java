package de.company2.notify;

/**
 * Sends notifications about processed orders. Owned by company2 and MUST NOT
 * be modified by us. Company2 does not publish an interface for this service.
 */
public class NotificationSender {

    public void send(String orderId) {
        // Production: dispatch a real notification.
    }
}
