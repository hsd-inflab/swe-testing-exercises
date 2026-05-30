package ex04.auditservice;

/**
 * Writes audit entries to a remote audit system. Owned by AuditService and must
 * not be modified by us.
 */
public class RemoteAuditLog implements AuditLog {

    @Override
    public void record(String eventType, String entityId, String details) {
        System.out.println("[RemoteAuditLog] Preparing audit entry...");
        System.out.println("[RemoteAuditLog] Event type: " + eventType);
        System.out.println("[RemoteAuditLog] Entity id: " + entityId);
        System.out.println("[RemoteAuditLog] Details: " + details);
        System.out.println("[RemoteAuditLog] Connecting to audit.example...");
        System.out.println("[RemoteAuditLog] Storing audit entry... done.");
    }
}
