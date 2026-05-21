package orderprocessing.orderingplatform;

import orderprocessing.riskassessment.RemoteApprover;
import orderprocessing.logisticsprovider.NotificationSender;

/**
 * Owned by our team (OrderingPlatform) and may be modified.
 */
public class OrderProcessor {

    private final RemoteApprover approver;
    private final NotificationSender notificationSender;

    public OrderProcessor(RemoteApprover approver, NotificationSender notificationSender) {
        this.approver = approver;
        this.notificationSender = notificationSender;
    }

    public boolean process(String orderId) {
        if (!approver.isApproved(orderId)) {
            return false;
        }
        notificationSender.send(orderId);
        return true;
    }
}
