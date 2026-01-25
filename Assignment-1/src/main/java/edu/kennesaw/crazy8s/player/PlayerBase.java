package edu.kennesaw.crazy8s.player;

import edu.kennesaw.crazy8s.cardDeck.Deck;
import edu.kennesaw.crazy8s.cards.StandardCard;

import java.util.ArrayList;
import java.util.Scanner;


abstract class PlayerBase implements Player {
    private ArrayList<StandardCard> hand;
    private final String NAME;

    public PlayerBase() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name (or press Enter for 'Player'): ");
        String name = scan.nextLine();

        hand = new ArrayList<>();
        if(name.isEmpty()) {
            NAME = "Player";
        } else {
            NAME = name;
        }

        System.out.println();
    }

    public PlayerBase(String name) {
        hand = new ArrayList<>();
        NAME = name;
    }

    public String draw(Deck deck) {
        if(deck.cardsLeft() == 0) {
            hand = new ArrayList<>();
            return "TIE";
        }

        StandardCard drawn = deck.draw();
        hand.add(drawn);

        if(deck.cardsLeft() < 41) {
            System.out.println("** " + getName() + " has no playable cards. Drawing one card...");
            System.out.println("** " + getName() + " drew " + drawn);
            System.out.print("Press Enter to continue...");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            System.out.println();
        }

        return "";
    }

    public int handSize() { return hand.size(); }

    public String win() {
        if(handSize() == 0) {
            hand = new ArrayList<>();
            return "WIN";
        }

        return "";
    }

    public void lose() {
        hand = new ArrayList<>();
    }

    public void playCard(StandardCard card, Deck deck) {
        hand.remove(card);
        deck.discard(card);
    }

    public ArrayList<StandardCard> playable(StandardCard lastPlayed) {
        ArrayList<StandardCard> playable = new ArrayList<>();
        for(StandardCard card : hand) {
            if(card.getRank().equals("Eight")
                    || card.getRank().equals(lastPlayed.getRank())
                    || card.getSuit().equals(lastPlayed.getSuit())) {
                playable.add(card);
            }
        }

        return playable;
    }

    public String getName() { return NAME; }

    public ArrayList<StandardCard> getHand() { return hand; }
}
