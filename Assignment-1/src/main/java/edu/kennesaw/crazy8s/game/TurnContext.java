package edu.kennesaw.crazy8s.game;

import edu.kennesaw.crazy8s.cardDeck.Deck;
import edu.kennesaw.crazy8s.cards.StandardCard;
import edu.kennesaw.crazy8s.domain.Rank;
import edu.kennesaw.crazy8s.domain.Suit;
import edu.kennesaw.crazy8s.player.Player;

public class TurnContext {
    private int turn;
    private Deck deck;
    private Player playerOne;
    private Player playerTwo;
    private int displacement;
    private String suitOverride;

    public TurnContext(Deck deck, Player p1, Player p2) {
        turn = 0;
        this.deck = deck;
        playerOne = p1;
        playerTwo = p2;
        displacement = (int) (Math.random() * 10);
        suitOverride = "";
    }

    public void status() {
        if(turn == 0) {
            StandardCard start = deck.draw();
            deck.discard(start);

            System.out.println("==================================================");
            System.out.println("Crazy Eights (Simplified)");
            System.out.println("==================================================");
            System.out.println("Starting discard: " + start);
            System.out.println();

            for(int i = 0 ; i < 5 ; i++) {
                playerOne.draw(deck);
                playerTwo.draw(deck);
            }
        }
        turn++;

        System.out.println("----- TURN " + turn + " -----");
        System.out.print("Top discard: " + deck.lastPlayed());
        if(!suitOverride.isEmpty()) {
            System.out.print(" (Suit to match: " + suitOverride + ")");

            String suit = "";

            if("Clubs ♣".contains(suitOverride)) { suit = "Clubs ♣"; }
            if("Diamonds ♦".contains(suitOverride)) { suit = "Diamonds ♦"; }
            if("Hearts ♥".contains(suitOverride)) { suit = "Hearts ♥"; }
            if("Spades ♠".contains(suitOverride)) { suit = "Spades ♠"; }

            StandardCard fakeCard = new StandardCard(new Rank("Eight"), new Suit(suit));
            deck.discard(fakeCard); // This is so decision() works seamlessly with the change in suit
        }
        System.out.println();
        System.out.println("Deck remaining: " + deck.cardsLeft() + " cards");
        System.out.println(playerOne.getName() + ": " + playerOne.handSize()
                + " | " + playerTwo.getName() + ": " + playerTwo.handSize());
        System.out.println();

        String upNext = upNext().getName().toUpperCase();

        System.out.println("** " + upNext + "'S TURN");
        System.out.println();
    }

    public void setSuitOverride(String suitOverride) {
        this.suitOverride = suitOverride;
    }

    public Player upNext() {
        if((turn + displacement) % 2 == 0) {
            return playerOne;
        }
        return playerTwo;
    }

    public Deck getDeck() { return deck; }
}
