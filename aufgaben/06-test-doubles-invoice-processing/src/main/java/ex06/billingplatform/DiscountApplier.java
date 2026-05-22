package ex06.billingplatform;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Applies a discount based on the gross amount (subtotal + tax). Internal
 * helper of the UoW.
 */
public class DiscountApplier {

    private static final BigDecimal GROSS_THRESHOLD = new BigDecimal("100.00");
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.05");

    public Discount apply(InvoiceRequest req, Tax tax) {
        BigDecimal gross = req.getSubtotal().add(tax.getAmount());
        if (gross.compareTo(GROSS_THRESHOLD) < 0) {
            return new Discount(BigDecimal.ZERO.setScale(2));
        }
        BigDecimal amount = gross
                .multiply(DISCOUNT_RATE)
                .setScale(2, RoundingMode.HALF_UP);
        return new Discount(amount);
    }
}
