package edu.kennesaw.crazy8s.cardDeck;

import edu.kennesaw.crazy8s.cards.StandardCard;

import java.util.Stack;

public class DiscardPile {
    private Stack<StandardCard> trash;

    public DiscardPile() {
        trash = new Stack<>();
    }

    public void dump(StandardCard throwaway) {
        trash.push(throwaway);
    }

    public StandardCard topCard() {
        return trash.peek();
    }
}
