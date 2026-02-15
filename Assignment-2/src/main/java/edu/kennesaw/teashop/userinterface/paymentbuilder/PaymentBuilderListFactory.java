package edu.kennesaw.teashop.userinterface.paymentbuilder;

import java.util.List;

public class PaymentBuilderListFactory {
    private final List<BasePaymentBuilder> PAY_BUILDERS = List.of(
            new CreditCardPaymentBuilder("Credit Card"),
            new ApplePayPaymentBuilder("Apple Pay"),
            new CryptoCurrencyPaymentBuilder("Crypto Currency")
    );

    public List<BasePaymentBuilder> getBuilders() {
        return PAY_BUILDERS;
    }
}
