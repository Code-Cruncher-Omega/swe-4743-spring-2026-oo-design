package edu.kennesaw.crazy8s.domain;

public class Suit {
    private final String SYMBOL;

    public Suit(String suit) {
        SYMBOL = suit;
    }

    public String getSuit() {
        return SYMBOL;
    }
}
