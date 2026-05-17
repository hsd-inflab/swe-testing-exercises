package de.hsd.swe.testing.lending;

/**
 * Sends lending confirmations to users by email.
 *
 * <p>Legacy class from an older module of the system. Used by other components
 * as well and MUST NOT be modified — neither its signature nor its behavior.
 *
 * <p>In production this class would contact a mail server. The body is left
 * empty here on purpose; even so, it should not be invoked for real in tests.
 */
public class ConfirmationSender {

    public void sendConfirmation(String recipientEmail, String message) {
        // In production: open SMTP connection, send mail.
    }
}
