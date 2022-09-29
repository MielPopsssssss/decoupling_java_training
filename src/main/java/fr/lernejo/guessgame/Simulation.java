package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long number = player.askNextGuess();
        logger.log("User typed " + number);
        if (number < numberToGuess) {
            player.respond(true);
            return false;
        }
        else if (number > numberToGuess) {
            player.respond(false);
            return false;
        }
        return true;
    }

    public void loopUntilPlayerSucceed() {
        boolean done = false;
        while (!done) {
            done = nextRound();
        }
    }
}