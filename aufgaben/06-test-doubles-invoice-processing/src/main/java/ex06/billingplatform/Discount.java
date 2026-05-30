package ex06.billingplatform;

/**
 * Value type. Would normally be a Java record (see project README).
 *
 * <p>{@code amount} is expressed in cents.
 */
public class Discount {

    private int amount;

    public Discount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Discount[amount=" + amount + "]";
    }
}
