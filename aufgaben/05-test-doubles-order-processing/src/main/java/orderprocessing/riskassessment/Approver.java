package orderprocessing.riskassessment;

/**
 * Approver API published by RiskAssessment alongside their concrete implementation.
 */
public interface Approver {

    boolean isApproved(String orderId);
}
