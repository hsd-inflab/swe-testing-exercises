package ex06.billingplatform;

import java.math.BigDecimal;

/**
 * Value type with one piece of logic: {@link #toRenderableContent()}.
 * Would normally be a Java record (see project README).
 */
public class InvoiceDocument {

    private String invoiceId;
    private String customerEmail;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal total;

    public InvoiceDocument(String invoiceId,
                           String customerEmail,
                           BigDecimal subtotal,
                           BigDecimal tax,
                           BigDecimal discount,
                           BigDecimal total) {
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
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
                        + "Subtotal: %s%n"
                        + "Tax:      %s%n"
                        + "Discount: %s%n"
                        + "Total:    %s%n",
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
