package ex21.billingplatform;

/**
 * Calculates the tax part of an invoice request. Internal helper of the UoW.
 */
public class TaxCalculator {

    private static final int VAT_PERCENT = 19;

    public Tax calculate(InvoiceRequest req) {
        int amount = req.getSubtotal() * VAT_PERCENT / 100;
        return new Tax(amount, VAT_PERCENT);
    }
}
