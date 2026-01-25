package edu.kennesaw.crazy8s;

import edu.kennesaw.crazy8s.cardDeck.Deck;
import edu.kennesaw.crazy8s.game.CrazyEightsGame;
import edu.kennesaw.crazy8s.player.CpuPlayer;
import edu.kennesaw.crazy8s.player.HumanPlayer;
import edu.kennesaw.crazy8s.player.Player;

public class Main {
    public static void main(String[] args) {
        Player human = new HumanPlayer();
        Player cpu = new CpuPlayer("CPU");

        Deck deck = new Deck();
        CrazyEightsGame game = new CrazyEightsGame(deck, human, cpu);

        game.run();
    }
}