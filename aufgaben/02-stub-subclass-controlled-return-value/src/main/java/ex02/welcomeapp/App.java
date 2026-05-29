package ex02.welcomeapp;

import ex02.greetingservice.TimeBasedGreetingProvider;

public class App {

    public static void main(String[] args) {
        System.out.println("[App] Starting welcome message demo...");

        WelcomeMessageCreator creator = new WelcomeMessageCreator(new TimeBasedGreetingProvider());

        System.out.println(creator.createMessage("Ada"));
        System.out.println("[App] Demo finished.");
    }
}
