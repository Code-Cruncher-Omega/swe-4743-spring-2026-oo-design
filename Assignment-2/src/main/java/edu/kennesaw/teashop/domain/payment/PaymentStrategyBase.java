package edu.kennesaw.teashop.domain.payment;

public abstract class PaymentStrategyBase implements PaymentStrategy {
    private final String PROMPT;


    protected PaymentStrategyBase(String prompt) {
        PROMPT = prompt;
    }
}
