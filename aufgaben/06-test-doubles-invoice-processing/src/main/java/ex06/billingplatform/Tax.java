package ex06.billingplatform;

import java.math.BigDecimal;

/**
 * Value type. Would normally be a Java record (see project README).
 */
public class Tax {

    private BigDecimal amount;
    private BigDecimal rate;

    public Tax(BigDecimal amount, BigDecimal rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Tax[amount=" + amount + ", rate=" + rate + "]";
    }
}
