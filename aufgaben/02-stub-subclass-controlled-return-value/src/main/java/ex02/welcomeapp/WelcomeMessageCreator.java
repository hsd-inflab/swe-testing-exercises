package ex02.welcomeapp;

import ex02.greetingservice.TimeBasedGreetingProvider;

/**
 * Owned by our team and may be tested directly.
 */
public class WelcomeMessageCreator {

    private final TimeBasedGreetingProvider greetingProvider;

    public WelcomeMessageCreator(TimeBasedGreetingProvider greetingProvider) {
        this.greetingProvider = greetingProvider;
    }

    public String createMessage(String customerName) {
        System.out.println("[WelcomeApp] Creating welcome message for customer " + customerName + "...");

        String greeting = greetingProvider.currentGreeting();
        String message = greeting + ", " + customerName + "!";

        System.out.println("[WelcomeApp] Welcome message created.");
        return message;
    }
}
