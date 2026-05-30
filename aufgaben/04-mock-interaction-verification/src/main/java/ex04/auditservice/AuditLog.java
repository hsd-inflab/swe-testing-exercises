package ex04.auditservice;

public interface AuditLog {

    void record(String eventType, String entityId, String details);
}
