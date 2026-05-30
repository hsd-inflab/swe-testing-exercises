package ex21.maildelivery;

/**
 * Sends invoice mails with the rendered PDF attached. Owned by MailDelivery and
 * MUST NOT be modified by us. MailDelivery does not publish an interface for
 * this service.
 */
public class Mailer {

    public void send(String recipient, byte[] payload) {
        System.out.println("[Mailer] Preparing mail to " + recipient + "...");
        System.out.println("[Mailer] Attaching invoice PDF (" + payload.length + " bytes)...");
        System.out.println("[Mailer] Resolving SMTP relay smtp.maildelivery.example...");
        System.out.println("[Mailer] Negotiating TLS and authenticating...");
        System.out.println("[Mailer] Sending message... done.");
    }
}
