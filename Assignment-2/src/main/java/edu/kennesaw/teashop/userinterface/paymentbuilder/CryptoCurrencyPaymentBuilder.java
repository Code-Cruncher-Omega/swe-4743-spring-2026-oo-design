package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.CryptoCurrencyStrategy;
import edu.kennesaw.teashop.domain.payment.PaymentStrategy;

import java.io.InputStream;
import java.io.PrintStream;

public class CryptoCurrencyPaymentBuilder extends BasePaymentBuilder {
    public CryptoCurrencyPaymentBuilder(String name) {
        super(name);
    }

    public CryptoCurrencyPaymentBuilder(InputStream input, PrintStream output, double amount) {
        super(input, output, amount);
    }

    public PaymentStrategy process() {
        String senderWallet;
        String recipientWallet = "bc1qm34lsc65zpw79lxes39zkqmk6ee2ewf0j77s3h";
        String walletKey;
        while(true) {
            console.print("Enter your wallet address: ");
            senderWallet = scan.nextLine();
            if(senderWallet.isEmpty()) {
                console.println("Error - Empty input");
                console.println();
                continue;
            }
            break;
        }
        console.print("Enter recipient wallet address (default is teashop's address): ");
        String temp = scan.nextLine();
        if(!temp.isEmpty()) {
            recipientWallet = temp;
        }
        while(true) {
            console.print("Enter your wallet key: ");
            walletKey = scan.nextLine();
            if(walletKey.isEmpty()) {
                console.println("Error - Empty input");
                console.println();
                continue;
            }
            break;
        }
        return new CryptoCurrencyStrategy(amount, senderWallet, recipientWallet, walletKey);
    }
}
