package edu.kennesaw.crazy8s.player;

import edu.kennesaw.crazy8s.cardDeck.Deck;
import edu.kennesaw.crazy8s.cards.StandardCard;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends PlayerBase {
    public HumanPlayer() {
        super();
    }

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public String decision(Deck deck) {
        Scanner scan = new Scanner(System.in);
        ArrayList<StandardCard> playable = playable(deck.lastPlayed());

        String input;
        int choice = 0;

        printHand();

        if(playable.isEmpty()) {
            return draw(deck);
        }

        while(true) {
            printPlayable(playable, deck.lastPlayed());
            System.out.print("Choose a card number to play: ");
            input = scan.nextLine();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, enter a integer");
            }

            choice--;   // Undoes the +1 displacement present in printPlayable

            if (0 <= choice && choice < playable.size()) {
                System.out.println();
                System.out.println("** " + getName() + " selected " + playable.get(choice));
                System.out.println();
                break;
            } else {
                System.out.println("Error: Invalid choice, choose one of the cards listed");
            }
        }

        if(playable.get(choice).getRank().equals("Eight")) {
            String temp = crazyEight(deck);
            playCard(playable.get(choice), deck);
            System.out.println("** " + getName() + " changed suit to " + temp);
            System.out.println();

            if(handSize() != 0) { return temp; }
        } else { playCard(playable.get(choice), deck); }
        return win();
    }

    private void printHand() {
        System.out.println(getName() + "'s hand");
        for(StandardCard card : getHand()) {
            System.out.println("\t- " + card);
        }
        System.out.println();
    }

    private void printPlayable(ArrayList<StandardCard> playable, StandardCard lastPlayed) {
        System.out.println(getName() + "'s playable cards");
        for(int i = 0 ; i < playable.size() ; i++) {
            System.out.print("\t[" + (i + 1) + "] " + playable.get(i));
            if(playable.get(i).getRank().equals("Eight")) {
                System.out.print(" (Wildcard!)");
            } else if(playable.get(i).getRank().equals(lastPlayed.getRank())) {
                System.out.print(" (Matches Rank)");
            } else {
                System.out.print(" (Matches Suit)");
            }
            System.out.println();
        }
    }

    private String crazyEight(Deck deck) {
        Scanner scan = new Scanner(System.in);
        String currentSuit = deck.lastPlayed().getSuit();

        String[] suits = new String[] {"Hearts", "Diamonds", "Clubs", "Spades"};

        System.out.println(getName() + ", you played a wildcard! Choose a suit:");
        while(true) {
            for(String suit : suits) {
                System.out.print("\t[" + suit.charAt(0) + "] " + suit);
                if(currentSuit.contains(suit)) {
                    System.out.print(" (current suit)");
                }
                System.out.println();
            }
            System.out.print("Enter the letter of your chosen suit: ");
            char initial = scan.nextLine().toLowerCase().charAt(0);
            System.out.println();

            if(initial == 'h') {
                return "Hearts";
            }
            if(initial == 'd') {
                return "Diamonds";
            }
            if(initial == 'c') {
                return "Clubs";
            }
            if(initial == 's') {
                return "Spades";
            }

            System.out.println("Error: Enter one of the four letters to choose a suit");
        }
    }

}
