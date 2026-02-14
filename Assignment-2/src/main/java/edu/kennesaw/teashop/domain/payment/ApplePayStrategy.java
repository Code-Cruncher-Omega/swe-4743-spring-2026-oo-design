package edu.kennesaw.teashop.domain.payment;

public class ApplePayStrategy extends PaymentStrategyBase {
    private final String PASSWORD;

    public ApplePayStrategy(double amount, String password) {
        super(amount);
        PASSWORD = password;
    }

    public void pay() {
        /*
        Painful Apple Pay stuff going on here :/
         */
    }
}
