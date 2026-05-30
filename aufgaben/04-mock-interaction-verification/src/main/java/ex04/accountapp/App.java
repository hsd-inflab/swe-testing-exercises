package ex04.accountapp;

import ex04.auditservice.RemoteAuditLog;

public class App {

    public static void main(String[] args) {
        RemoteAuditLog auditLog = new RemoteAuditLog();
        AccountCreationReporter reporter = new AccountCreationReporter(auditLog);

        reporter.reportAccountCreated("ACC-123", "Ada");
    }
}
