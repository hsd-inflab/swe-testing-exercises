package ex01.welcomeapp;

import ex01.greetingservice.GreetingProvider;

/**
 * Owned by our team and may be tested directly.
 */
public class WelcomeMessageCreator {

    private final GreetingProvider greetingProvider;

    public WelcomeMessageCreator(GreetingProvider greetingProvider) {
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
