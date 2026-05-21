package orderprocessing.orderingplatform;

import orderprocessing.riskassessment.RemoteApprover;
import orderprocessing.logisticsprovider.NotificationSender;

public class App {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor(
                new RemoteApprover(),
                new NotificationSender()
        );

        String orderId = "ORDER-42";
        System.out.println(">>> Processing " + orderId + " ...");
        boolean ok = processor.process(orderId);
        System.out.println(">>> Result: " + ok);
    }
}
