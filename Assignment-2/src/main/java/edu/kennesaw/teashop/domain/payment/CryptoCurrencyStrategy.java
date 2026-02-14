package edu.kennesaw.teashop.domain.payment;

public class CryptoCurrencyStrategy extends PaymentStrategyBase {
    private final String SENDER_WALLET;
    private final String RECEIVER_WALLET;
    private final String WALLET_KEY;

    public CryptoCurrencyStrategy(double amount, String sender, String receiver, String walletKey) {
        super(amount);
        SENDER_WALLET = sender;
        RECEIVER_WALLET = receiver;
        WALLET_KEY = walletKey;
    }

    public void pay() {
        /*
        SUPER COOL BLOCKCHAIN PAYMENT STUFF GOING ON IN THE BACKGROUND
         */
    }
}
