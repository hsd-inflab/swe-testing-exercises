package de.company1.approval;

/**
 * Approver API published by company1 alongside their concrete implementation.
 */
public interface Approver {

    boolean isApproved(String orderId);
}
