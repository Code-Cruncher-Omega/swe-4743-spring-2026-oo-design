package edu.kennesaw.crazy8s.cards;

import edu.kennesaw.crazy8s.domain.Rank;
import edu.kennesaw.crazy8s.domain.Suit;

public class StandardCard implements Card {
    final private Rank RANK;
    final private Suit SUIT;

    public StandardCard(Rank rank, Suit suit) {
        RANK = rank;
        SUIT = suit;
    }

    @Override
    public String getRank() {
        return RANK.getRank();
    }

    @Override
    public String getSuit() {
        return SUIT.getSuit();
    }

    @Override
    public String toString() {
        return RANK.getRank() + " of " + SUIT.getSuit();
    }
}
