package ex06.billingplatform;

/**
 * Applies a discount based on the gross amount (subtotal + tax). Internal
 * helper of the UoW. All amounts in cents.
 */
public class DiscountApplier {

    private static final int GROSS_THRESHOLD = 10000;
    private static final int DISCOUNT_PERCENT = 5;

    public Discount apply(InvoiceRequest req, Tax tax) {
        int gross = req.getSubtotal() + tax.getAmount();
        if (gross < GROSS_THRESHOLD) {
            return new Discount(0);
        }
        int amount = gross * DISCOUNT_PERCENT / 100;
        return new Discount(amount);
    }
}
