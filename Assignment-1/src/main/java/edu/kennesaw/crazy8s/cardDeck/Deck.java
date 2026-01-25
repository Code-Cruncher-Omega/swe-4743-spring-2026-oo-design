package edu.kennesaw.crazy8s.cardDeck;

import edu.kennesaw.crazy8s.domain.Rank;
import edu.kennesaw.crazy8s.domain.Suit;
import edu.kennesaw.crazy8s.cards.StandardCard;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<StandardCard> deck;
    private DiscardPile trash;

    public Deck() {
        deck = createShuffledDeck();
        trash = new DiscardPile();
    }

    public StandardCard draw() {
        return deck.pop();
    }

    public void discard(StandardCard throwaway) {
        trash.dump(throwaway);
    }

    public int cardsLeft() { return deck.size(); }

    public StandardCard lastPlayed() {
        return trash.topCard();
    }

    private static Stack<StandardCard> createShuffledDeck() {
        Rank[] ranks = getRanks();
        Suit[] suits = getSuits();

        Stack<StandardCard> shuffled = new Stack<>();

        for(Rank rank : ranks)
            for(Suit suit : suits)
                shuffled.push(new StandardCard(rank, suit));

        Collections.shuffle(shuffled);

        return shuffled;
    }

    private static Rank[] getRanks() {
        Rank ace = new Rank("Ace");
        Rank two = new Rank("Two");
        Rank three = new Rank("Three");
        Rank four = new Rank("Four");
        Rank five = new Rank("Five");
        Rank six = new Rank("Six");
        Rank seven = new Rank("Seven");
        Rank eight = new Rank("Eight");
        Rank nine = new Rank("Nine");
        Rank ten = new Rank("Ten");
        Rank jack = new Rank("Jack");
        Rank queen = new Rank("Queen");
        Rank king = new Rank("King");

        return new Rank[] {ace, two, three, four, five, six, seven, eight, nine, ten, jack, queen, king};
    }

    private static Suit[] getSuits() {
        Suit clubs = new Suit("Clubs ♣");
        Suit diamonds = new Suit("Diamonds ♦");
        Suit hearts = new Suit("Hearts ♥");
        Suit spades = new Suit("Spades ♠");

        return new Suit[] {clubs, diamonds, hearts, spades};
    }
}
