package ex21.billingplatform;

/**
 * Value type. Would normally be a Java record (see project README).
 *
 * <p>Monetary amounts are expressed in cents (e.g., 25000 = 250.00 EUR).
 */
public class InvoiceRequest {

    private String invoiceId;
    private String customerEmail;
    private int subtotal;

    public InvoiceRequest(String invoiceId, String customerEmail, int subtotal) {
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

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "InvoiceRequest[invoiceId=" + invoiceId
                + ", customerEmail=" + customerEmail
                + ", subtotal=" + subtotal + "]";
    }
}
