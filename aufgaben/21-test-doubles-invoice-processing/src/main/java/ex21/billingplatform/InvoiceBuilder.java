package ex21.billingplatform;

/**
 * Assembles the final {@link InvoiceDocument} from request, tax and discount.
 * Internal helper of the UoW.
 */
public class InvoiceBuilder {

    public InvoiceDocument build(InvoiceRequest req, Tax tax, Discount discount) {
        int total = req.getSubtotal() + tax.getAmount() - discount.getAmount();
        return new InvoiceDocument(
                req.getInvoiceId(),
                req.getCustomerEmail(),
                req.getSubtotal(),
                tax.getAmount(),
                discount.getAmount(),
                total
        );
    }
}
