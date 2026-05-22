package ex06.billingplatform;

import java.math.BigDecimal;

/**
 * Value type. Would normally be a Java record (see project README).
 */
public class InvoiceRequest {

    private String invoiceId;
    private String customerEmail;
    private BigDecimal subtotal;

    public InvoiceRequest(String invoiceId, String customerEmail, BigDecimal subtotal) {
        this.invoiceId = invoiceId;
        this.customerEmail = customerEmail;
        this.subtotal = subtotal;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "InvoiceRequest[invoiceId=" + invoiceId
                + ", customerEmail=" + customerEmail
                + ", subtotal=" + subtotal + "]";
    }
}
