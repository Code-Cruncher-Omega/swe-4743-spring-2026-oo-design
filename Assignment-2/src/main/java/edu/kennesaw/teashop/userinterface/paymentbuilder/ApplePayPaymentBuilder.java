package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.ApplePayStrategy;
import edu.kennesaw.teashop.domain.payment.PaymentStrategy;

import java.io.InputStream;
import java.io.PrintStream;

public class ApplePayPaymentBuilder extends BasePaymentBuilder {
    public ApplePayPaymentBuilder(String name) {
        super(name);
    }

    public ApplePayPaymentBuilder(InputStream input, PrintStream output, double amount) {
        super(input, output, amount);
    }

    public PaymentStrategy process() {
        while(true) {
            console.print("Use Face ID, Touch ID, or enter password: ");
            String password = scan.nextLine();
            if(!password.isEmpty()) {
                return new ApplePayStrategy(amount, password);
            }
            console.println("Error - Empty input");
            console.println();
        }
    }
}
