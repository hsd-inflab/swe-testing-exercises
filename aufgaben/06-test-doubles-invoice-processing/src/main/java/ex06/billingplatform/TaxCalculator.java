package ex06.billingplatform;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculates the tax part of an invoice request. Internal helper of the UoW.
 */
public class TaxCalculator {

    private static final BigDecimal VAT_RATE = new BigDecimal("0.19");

    public Tax calculate(InvoiceRequest req) {
        BigDecimal amount = req.getSubtotal()
                .multiply(VAT_RATE)
                .setScale(2, RoundingMode.HALF_UP);
        return new Tax(amount, VAT_RATE);
    }
}
