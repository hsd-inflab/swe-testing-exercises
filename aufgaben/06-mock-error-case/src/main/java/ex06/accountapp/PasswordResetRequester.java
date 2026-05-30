package ex06.accountapp;

import ex06.notificationservice.PasswordResetMailSender;

/**
 * Owned by our team and may be tested directly.
 */
public class PasswordResetRequester {

    private final PasswordResetMailSender mailSender;

    public PasswordResetRequester(PasswordResetMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void requestPasswordReset(String customerId, String emailAddress) {
        System.out.println("[AccountApp] Preparing password reset for account " + customerId + "...");

        if (!isValidEmailAddress(emailAddress)) {
            System.out.println("[AccountApp] Email address is invalid. No reset mail will be sent.");
            throw new IllegalArgumentException("email address is invalid");
        }

        String subject = "Reset your password";
        String body = "Use this link to reset the password for account "
                + customerId
                + ": https://account.example/reset?customerId="
                + customerId;

        mailSender.sendPasswordResetMail(emailAddress, subject, body);

        System.out.println("[AccountApp] Password reset mail handed over.");
    }

    private boolean isValidEmailAddress(String emailAddress) {
        return emailAddress != null
                && emailAddress.contains("@")
                && emailAddress.contains(".");
    }
}
