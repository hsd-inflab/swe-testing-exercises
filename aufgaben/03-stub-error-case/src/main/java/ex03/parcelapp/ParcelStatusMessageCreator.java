package ex03.parcelapp;

import ex03.trackingservice.ParcelTrackingClient;

/**
 * Owned by our team and may be tested directly.
 */
public class ParcelStatusMessageCreator {

    private final ParcelTrackingClient trackingClient;

    public ParcelStatusMessageCreator(ParcelTrackingClient trackingClient) {
        this.trackingClient = trackingClient;
    }

    public String createStatusMessage(String trackingNumber) {
        System.out.println("[ParcelApp] Creating status message for parcel " + trackingNumber + "...");

        String status = trackingClient.currentStatusFor(trackingNumber);
        String message = "Parcel " + trackingNumber + ": " + humanReadableStatus(status);

        System.out.println("[ParcelApp] Status message created.");
        return message;
    }

    private String humanReadableStatus(String status) {
        return switch (status) {
            case "CREATED" -> "order has been created";
            case "IN_DELIVERY" -> "parcel is currently in delivery";
            case "DELIVERED" -> "parcel has been delivered";
            default -> "status is unknown";
        };
    }
}
