package edu.kennesaw.teashop.domain.payment;

public abstract class PaymentStrategyBase implements PaymentStrategy {
    protected final double amount;

    protected PaymentStrategyBase(double amount) {
        this.amount = amount;
    }

    public abstract void pay();
}
