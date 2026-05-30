package ex21.billingplatform;

/**
 * Value type with one piece of logic: {@link #toRenderableContent()}.
 * Would normally be a Java record (see project README).
 *
 * <p>All monetary amounts are expressed in cents.
 */
public class InvoiceDocument {

    private String invoiceId;
    private String customerEmail;
    private int subtotal;
    private int tax;
    private int discount;
    private int total;

    public InvoiceDocument(String invoiceId,
                           String customerEmail,
                           int subtotal,
                           int tax,
                           int discount,
                           int total) {
        this.invoiceId = invoiceId;
        this.customerEmail = customerEmail;
        this.subtotal = subtotal;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
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

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Serializes the invoice into a plain-text representation that can be
     * handed to a generic renderer that does not know our domain model.
     */
    public String toRenderableContent() {
        return String.format(
                "INVOICE %s%n"
                        + "Customer: %s%n"
                        + "Subtotal: %d%n"
                        + "Tax:      %d%n"
                        + "Discount: %d%n"
                        + "Total:    %d%n",
                invoiceId, customerEmail, subtotal, tax, discount, total
        );
    }

    @Override
    public String toString() {
        return "InvoiceDocument[invoiceId=" + invoiceId
                + ", customerEmail=" + customerEmail
                + ", subtotal=" + subtotal
                + ", tax=" + tax
                + ", discount=" + discount
                + ", total=" + total + "]";
    }
}
