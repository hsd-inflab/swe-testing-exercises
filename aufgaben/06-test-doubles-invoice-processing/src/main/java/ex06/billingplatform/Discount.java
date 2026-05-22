package ex06.billingplatform;

import java.math.BigDecimal;

/**
 * Value type. Would normally be a Java record (see project README).
 */
public class Discount {

    private BigDecimal amount;

    public Discount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Discount[amount=" + amount + "]";
    }
}
