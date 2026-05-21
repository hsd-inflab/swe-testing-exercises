package de.company1.approval;

/**
 * Concrete approver maintained by company1. Implements {@link Approver}.
 * Owned by company1 and MUST NOT be modified by us.
 */
public class RemoteApprover implements Approver {

    @Override
    public boolean isApproved(String orderId) {
        // Production: contact company1's remote approval system.
        return true;
    }
}
