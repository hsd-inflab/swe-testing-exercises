package ex06.billingplatform;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Assembles the final {@link InvoiceDocument} from request, tax and discount.
 * Internal helper of the UoW.
 */
public class InvoiceBuilder {

    public InvoiceDocument build(InvoiceRequest req, Tax tax, Discount discount) {
        BigDecimal total = req.getSubtotal()
                .add(tax.getAmount())
                .subtract(discount.getAmount())
                .setScale(2, RoundingMode.HALF_UP);
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
