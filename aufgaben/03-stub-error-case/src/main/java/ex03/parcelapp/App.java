package ex03.parcelapp;

import ex03.trackingservice.ParcelTrackingClient;

public class App {

    public static void main(String[] args) {
        System.out.println("[App] Starting parcel status demo...");

        ParcelStatusMessageCreator creator = new ParcelStatusMessageCreator(new ParcelTrackingClient());

        System.out.println(creator.createStatusMessage("PKG-2026-042"));
        System.out.println("[App] Demo finished.");
    }
}
