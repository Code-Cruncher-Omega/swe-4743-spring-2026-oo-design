package edu.kennesaw.crazy8s.game;

import edu.kennesaw.crazy8s.cardDeck.Deck;
import edu.kennesaw.crazy8s.player.Player;

import java.util.Scanner;

public class CrazyEightsGame {
    private Deck deck;
    private Player playerOne;
    private Player playerTwo;
    private TurnAction action;
    private TurnContext context;

    public CrazyEightsGame(Deck deck, Player p1, Player p2) {
        this.deck = deck;
        playerOne = p1;
        playerTwo = p2;
        context = new TurnContext(deck, playerOne, playerTwo);
        action = new TurnAction(context);
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        char input = 'y';
        boolean running = true;

        while(input != 'n') {
            while(running) {
                running = action.play();
            }

            System.out.print("Do you want to play again? (Y/N): ");
            input = scan.nextLine().toLowerCase().charAt(0);

            if(input == 'y') {
                running = true;
                deck = new Deck();
                context = new TurnContext(deck, playerOne, playerTwo);
                action = new TurnAction(context);
            }
        }
        System.out.println();
        System.out.println("Thanks for playing :)");
    }
}
