package ex04.accountapp;

import ex04.auditservice.AuditLog;

/**
 * Owned by our team and may be tested directly.
 */
public class AccountCreationReporter {

    private final AuditLog auditLog;

    public AccountCreationReporter(AuditLog auditLog) {
        this.auditLog = auditLog;
    }

    public void reportAccountCreated(String accountId, String customerName) {
        System.out.println("[AccountApp] Creating audit entry for account " + accountId + "...");

        String eventType = "ACCOUNT_CREATED";
        String details = "Account for " + customerName + " was created.";

        auditLog.record(eventType, accountId, details);

        System.out.println("[AccountApp] Audit entry handed over.");
    }
}
