package ex01.greetingservice;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Real implementation maintained by the greeting service.
 */
public class TimeBasedGreetingProvider implements GreetingProvider {

    @Override
    public String currentGreeting() {
        System.out.println("[GreetingService] Opening connection to greeting-service.example...");
        System.out.println("[GreetingService] Loading time-based greeting rules...");

        int hour = LocalTime.now().getHour();

        someLatency();

        System.out.println("[GreetingService] Local hour is " + hour + ".");

        if (hour < 12) {
            System.out.println("[GreetingService] Selected greeting: Good morning");
            return "Good morning";
        }
        if (hour < 18) {
            System.out.println("[GreetingService] Selected greeting: Good afternoon");
            return "Good afternoon";
        }
        System.out.println("[GreetingService] Selected greeting: Good evening");
        return "Good evening";
    }

    private void someLatency() {
        int latencyMs = ThreadLocalRandom.current().nextInt(10000, 20001);
        System.out.println("[GreetingService] Waiting for response (" + latencyMs + " ms)...");
        try {
            Thread.sleep(latencyMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted while waiting for greeting response", e);
        }
        System.out.println("[GreetingService] Response received.");
    }
}
