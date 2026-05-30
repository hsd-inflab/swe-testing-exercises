package ex06.accountapp;

import ex06.notificationservice.PasswordResetMailSender;
import ex06.notificationservice.RemotePasswordResetMailSender;

public class App {

    public static void main(String[] args) {
        PasswordResetMailSender mailSender = new RemotePasswordResetMailSender();
        PasswordResetRequester requester = new PasswordResetRequester(mailSender);

        requester.requestPasswordReset("CUST-123", "ada@example.test");
    }
}
