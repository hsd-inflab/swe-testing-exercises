package ex06.billingplatform;

/**
 * Value type. Would normally be a Java record (see project README).
 *
 * <p>{@code total} is expressed in cents.
 */
public class InvoiceResult {

    private String invoiceId;
    private int total;

    public InvoiceResult(String invoiceId, int total) {
        this.invoiceId = invoiceId;
        this.total = total;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "InvoiceResult[invoiceId=" + invoiceId + ", total=" + total + "]";
    }
}
