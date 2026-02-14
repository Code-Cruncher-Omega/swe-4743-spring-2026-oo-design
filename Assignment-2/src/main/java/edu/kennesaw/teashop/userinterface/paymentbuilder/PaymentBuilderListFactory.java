package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.CreditCardStrategy;
import edu.kennesaw.teashop.domain.payment.CryptoCurrencyStrategy;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public final class PaymentBuilderListFactory {
    private List<PaymentBuilder> builders;
    private InputStream input;
    private PrintStream output;

    public PaymentBuilderListFactory(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public List<PaymentBuilder> newBuilders(double amount) {
        return List.of(
                new ApplePayPaymentBuilder(input, output, amount),
                new CreditCardPaymentBuilder(input, output, amount),
                new CryptoCurrencyPaymentBuilder(input, output, amount)
        );
    }
}
