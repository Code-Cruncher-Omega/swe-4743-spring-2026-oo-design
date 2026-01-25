package edu.kennesaw.crazy8s.game;

import edu.kennesaw.crazy8s.player.Player;

public class TurnAction {
    private TurnContext context;

    public TurnAction(TurnContext context) {
        this.context = context;
    }

    public boolean play() {
        Player previous = context.upNext();
        context.status();
        Player player = context.upNext();

        String suitOverride = player.decision(context.getDeck());

        if(suitOverride.equals("WIN")) {
            System.out.println("***** " + player.getName() + " wins the game! *****");
            System.out.println();
            System.out.println("==================================================");
            System.out.println();

            previous.lose();

            return false;
        }

        if(suitOverride.equals("TIE")) {
            System.out.println("***** Tie, nobody wins the game... *****");
            System.out.println();
            System.out.println("==================================================");
            System.out.println();

            previous.lose();
            player.lose();

            return false;
        }

        context.setSuitOverride(suitOverride);

        return true;
    }
}
