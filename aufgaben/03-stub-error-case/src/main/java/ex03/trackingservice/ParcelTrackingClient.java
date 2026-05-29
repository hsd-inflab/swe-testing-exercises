package ex03.trackingservice;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Real implementation maintained by the tracking service team.
 */
public class ParcelTrackingClient {

    public String currentStatusFor(String trackingNumber) {
        System.out.println("[TrackingService] Opening connection to tracking-service.example...");
        System.out.println("[TrackingService] Loading status for parcel " + trackingNumber + "...");

        if (connectionFails()) {
            System.out.println("[TrackingService] Connection failed.");
            throw new IllegalStateException("connection to tracking service failed");
        }

        String status = randomStatus();

        System.out.println("[TrackingService] Selected status: " + status);
        return status;
    }

    private boolean connectionFails() {
        return ThreadLocalRandom.current().nextInt(20) == 0;
    }

    private String randomStatus() {
        String[] statuses = {"CREATED", "IN_DELIVERY", "DELIVERED"};
        int index = ThreadLocalRandom.current().nextInt(statuses.length);
        return statuses[index];
    }
}
