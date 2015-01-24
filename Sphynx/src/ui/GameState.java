package ui;

import model.Path;

/**
 * Created by mohamedshaaban on 15-01-24.
 */
public class GameState {


    private boolean atFrontPage;
    private boolean atEndPage;
    private boolean atChallenge;
    private boolean wonChallenge;
    private boolean lostChallenge;
    private boolean wonGame;
    private boolean lostGame;
    private Path path;

    public GameState() {

        atFrontPage = false;
        atChallenge = false;
        wonChallenge = false;
        lostChallenge = false;
        atEndPage = false;
        wonGame = false;
        lostGame = false;

        path = new Path();
    }

    public Path getPath() {
        return path;
    }

    //================================================================================================================
    // Game State setters to be called at any change of state (basically an accumulator that is a class)

    public void atFrontPage() {
        atFrontPage = true;
        atEndPage = false;
        atChallenge = false;
    }

    public void atChallenge() {
        atChallenge = true;
        atFrontPage = false;
        atEndPage = false;
    }

    public void wonChallenge() {
        wonChallenge = true;
        lostChallenge = false;

    }

    public void lostChallenge() {
        lostChallenge = true;
        wonChallenge = false;
    }

    public void atEndPage() {
        atEndPage = true;
        atChallenge = false;
        atFrontPage = false;
    }

    public void wonGame() {
        wonGame = true;
        lostGame = false;
    }

    public void lostGame() {
        lostGame = true;
        wonGame = false;
    }

    //================================================================================================================
    // Game State checkers to check current state

    // return true if the game is on the start page
    public boolean isAtStart() {
        return atFrontPage;
    }

    // return true if the game is presenting a challenge to the user
    public boolean isAtChallenge() {
        return atChallenge;
    }

    // return true if the user has won
    public boolean isWonChallenge() {
        return wonChallenge;
    }

    // return true if the user has lost
    public boolean isLostChallenge() {
        return lostChallenge;
    }

    public boolean isAtEnd() {
        return atEndPage;
    }

    public boolean isWonGame() {
        return wonGame;
    }

    public boolean isLostGame() {
        return lostGame;
    }
}
