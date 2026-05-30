package ex21.billingplatform;

/**
 * Value type. Would normally be a Java record (see project README).
 *
 * <p>{@code amount} is expressed in cents. {@code rate} is the percentage
 * applied (e.g., 19 for 19 %).
 */
public class Tax {

    private int amount;
    private int rate;

    public Tax(int amount, int rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Tax[amount=" + amount + ", rate=" + rate + "]";
    }
}
