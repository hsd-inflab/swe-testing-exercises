package ex06.billingplatform;

import java.math.BigDecimal;

/**
 * Value type. Would normally be a Java record (see project README).
 */
public class InvoiceResult {

    private String invoiceId;
    private BigDecimal total;

    public InvoiceResult(String invoiceId, BigDecimal total) {
        this.invoiceId = invoiceId;
        this.total = total;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "InvoiceResult[invoiceId=" + invoiceId + ", total=" + total + "]";
    }
}
