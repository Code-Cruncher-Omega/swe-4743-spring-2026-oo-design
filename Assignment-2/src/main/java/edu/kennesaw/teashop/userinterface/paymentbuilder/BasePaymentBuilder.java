package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.PaymentStrategy;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class BasePaymentBuilder implements PaymentBuilder {
    protected Scanner scan;
    protected PrintStream console;
    protected final double AMOUNT;

    public BasePaymentBuilder(InputStream input, PrintStream output, double price) {
        scan = new Scanner(input);
        console = output;
        this.AMOUNT = price;
    }

    public abstract PaymentStrategy process();
}
