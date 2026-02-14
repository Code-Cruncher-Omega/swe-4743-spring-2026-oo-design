package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.CreditCardStrategy;
import edu.kennesaw.teashop.domain.payment.PaymentStrategy;

import java.io.InputStream;
import java.io.PrintStream;

public class CreditCardPaymentBuilder extends BasePaymentBuilder {
    public CreditCardPaymentBuilder(InputStream input, PrintStream output, double amount) {
        super(input, output, amount);
    }

    public PaymentStrategy process() {
        while(true) {
            console.print("Enter Credit Card Number (no spaces, no dashes): ");
            String text = scan.nextLine();
            if(text.isEmpty()) {
                console.println("Error - Empty input");
                console.println();
                continue;
            }
            try {
                Integer.parseInt(text);
            } catch(NumberFormatException e) {
                console.println("Error - Invalid characters entered");
                console.println();
                continue;
            }
            return new CreditCardStrategy(AMOUNT, text);
        }
    }
}
