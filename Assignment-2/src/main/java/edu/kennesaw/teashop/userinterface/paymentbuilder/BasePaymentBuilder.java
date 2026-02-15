package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.PaymentStrategy;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class BasePaymentBuilder {
    protected String name;
    protected Scanner scan;
    protected PrintStream console;
    protected double amount;

    public BasePaymentBuilder(String name) {
        this.name = name;
    }

    public BasePaymentBuilder(InputStream input, PrintStream output, double amount) {
        scan = new Scanner(input);
        console = output;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setScan(InputStream input) {
        scan = new Scanner(input);
    }

    public void setConsole(PrintStream output) {
        console = output;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract PaymentStrategy process();
}
