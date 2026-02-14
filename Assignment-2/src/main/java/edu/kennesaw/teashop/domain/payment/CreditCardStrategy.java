package edu.kennesaw.teashop.domain.payment;

public class CreditCardStrategy extends PaymentStrategyBase {
    private final String CREDIT_CARD_NUMBER;

    public CreditCardStrategy(double amount, String CCNumber) {
        super(amount);
        CREDIT_CARD_NUMBER = CCNumber;
    }

    public void pay() {
        /*
        Boring and lame credit card api stuff going on here
         */
    }
}
