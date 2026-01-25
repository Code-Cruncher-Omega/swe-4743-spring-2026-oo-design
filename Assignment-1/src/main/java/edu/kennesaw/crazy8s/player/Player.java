package edu.kennesaw.crazy8s.player;

import edu.kennesaw.crazy8s.cardDeck.Deck;
import edu.kennesaw.crazy8s.cards.StandardCard;

public interface Player {
    String decision(Deck deck);
    String getName();
    String draw(Deck deck);
    String win();
    void lose();
    void playCard(StandardCard card, Deck deck);
    int handSize();
}
