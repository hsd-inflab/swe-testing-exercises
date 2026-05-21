package de.company1.approval;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Concrete approver maintained by company1. Implements {@link Approver}.
 * Owned by company1 and MUST NOT be modified by us.
 *
 * <p>Talks to a remote approval service, so calls take noticeable time.
 */
public class RemoteApprover implements Approver {

    @Override
    public boolean isApproved(String orderId) {
        System.out.println("[RemoteApprover] Opening TLS connection to approval-service.company1.example...");
        System.out.println("[RemoteApprover] Negotiating session token...");
        System.out.println("[RemoteApprover] Sending approval request for order " + orderId + "...");
        System.out.println("[RemoteApprover] Awaiting response from remote service (this can take a moment)...");

        int latencyMs = ThreadLocalRandom.current().nextInt(7000, 10001);
        try {
            Thread.sleep(latencyMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted while waiting for approval response", e);
        }

        System.out.println("[RemoteApprover] Response received after " + latencyMs + " ms: APPROVED");
        System.out.println("[RemoteApprover] Closing connection.");
        return true;
    }
}
