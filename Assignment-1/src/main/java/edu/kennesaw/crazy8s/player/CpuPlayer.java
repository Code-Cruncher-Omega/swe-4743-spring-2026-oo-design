package edu.kennesaw.crazy8s.player;

import edu.kennesaw.crazy8s.cardDeck.Deck;
import edu.kennesaw.crazy8s.cards.StandardCard;

import java.util.ArrayList;
import java.util.Collections;

public class CpuPlayer extends PlayerBase {
    public CpuPlayer() {
        super();
    }

    public CpuPlayer(String name) {
        super(name);
    }

    @Override
    public String decision(Deck deck) {
        ArrayList<StandardCard> playable = playable(deck.lastPlayed());

        int hearts = 0;
        int diamonds = 0;
        int clubs = 0;
        int spades = 0;

        if(playable.isEmpty()) {
            return draw(deck);
        }

        for(StandardCard card : playable) {
            if(card.getSuit().contains("Hearts")) { hearts++; }
            if(card.getSuit().contains("Diamonds")) { diamonds++; }
            if(card.getSuit().contains("Clubs")) { clubs++; }
            if(card.getSuit().contains("Spades")) { spades++; }
        }

        StandardCard played = null;

        if(hearts > diamonds && hearts > clubs && hearts > spades) {
            for(StandardCard card : playable) {
                if(card.getSuit().contains("Hearts")) {
                    playCard(card, deck);
                    played = card;
                    break;
                }
            }
        } else if(diamonds > hearts && diamonds > clubs && diamonds > spades) {
            for(StandardCard card : playable) {
                if(card.getSuit().contains("Diamonds")) {
                    playCard(card, deck);
                    played = card;
                    break;
                }
            }
        } else if(clubs > hearts && clubs > diamonds && clubs > spades) {
            for(StandardCard card : playable) {
                if(card.getSuit().contains("Clubs")) {
                    playCard(card, deck);
                    played = card;
                    break;
                }
            }
        } else if(spades > hearts && spades > diamonds && spades > clubs) {
            for(StandardCard card : playable) {
                if(card.getSuit().contains("Spades")) {
                    playCard(card, deck);
                    played = card;
                    break;
                }
            }
        } else {
            Collections.shuffle(playable);
            played = playable.getFirst();
            playCard(played, deck);
        }

        System.out.println("** " + getName() + " selected " + played);
        System.out.println();
        if(played.getRank().equals("Eight")) {
            System.out.println();

            String temp = crazyEight();

            System.out.println("** " + getName() + " changed suit to " + temp);
            System.out.println();
            if(handSize() != 0) { return temp; }
        }

        return win();
    }

    private String crazyEight() {
        System.out.println(getName() + " played a wildcard!");
        ArrayList<String> suits = new ArrayList<>();
        suits.add("Hearts");
        suits.add("Diamonds");
        suits.add("Clubs");
        suits.add("Spades");
        Collections.shuffle(suits);

        return suits.getFirst();
    }
}
