package ex05.accountapp;

import ex05.notificationservice.RemoteNotificationSender;

public class App {

    public static void main(String[] args) {
        RemoteNotificationSender notificationSender = new RemoteNotificationSender();
        AccountActivationNotifier notifier = new AccountActivationNotifier(notificationSender);

        notifier.notifyAccountActivated("Ada", "ada@example.test");
    }
}
