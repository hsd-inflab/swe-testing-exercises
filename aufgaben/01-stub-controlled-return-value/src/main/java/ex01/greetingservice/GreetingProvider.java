package ex01.greetingservice;

/**
 * Dependency API published by the greeting service.
 */
public interface GreetingProvider {

    String currentGreeting();
}
