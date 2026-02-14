package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.PaymentStrategy;

public interface PaymentBuilder {
    PaymentStrategy process();
}
