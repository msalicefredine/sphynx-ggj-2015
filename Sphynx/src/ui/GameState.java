package ui;

import model.Path;

/**
 * Created by mohamedshaaban on 15-01-24.
 */
public class GameState {


    private boolean atFrontPage;
    private boolean atEndPage;
    private boolean atHardChallenge;
    private boolean wonHardChallenge;
    private boolean lostHardChallenge;
    private boolean atEasyChallenge;
    private boolean wonEasyChallenge;
    private boolean lostEasyChallenge;
    private boolean wonGame;
    private boolean lostGame;
    private Path path;

    public GameState() {

        atFrontPage = false;
        atHardChallenge = false;
        wonHardChallenge = false;
        lostHardChallenge = false;
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

    public void setAtStart() {
        atFrontPage = true;
        atEndPage = false;
        atHardChallenge = false;
        atEasyChallenge = false;
    }

    public void setAtHardChallenge() {
        atHardChallenge = true;
        atEasyChallenge = false;
        atFrontPage = false;
        atEndPage = false;
    }

    public void setWonHardChallenge() {
        wonHardChallenge = true;
        lostHardChallenge = false;
        wonEasyChallenge = false;
        lostEasyChallenge = false;

    }

    public void setLostHardChallenge() {
        lostHardChallenge = true;
        wonHardChallenge = false;
        wonEasyChallenge = false;
        lostEasyChallenge = false;

    }

    public void setAtEasyChallenge() {
        atHardChallenge = false;
        atEasyChallenge = true;
        atFrontPage = false;
        atEndPage = false;
    }

    public void setWonEasyChallenge() {
        wonHardChallenge = false;
        lostHardChallenge = false;
        wonEasyChallenge = true;
        lostEasyChallenge = false;

    }

    public void setLostEasyChallenge() {
        wonHardChallenge = false;
        lostHardChallenge = false;
        wonEasyChallenge = false;
        lostEasyChallenge = true;

    }

    public void setAtEnd() {
        atEndPage = true;
        atHardChallenge = false;
        atEasyChallenge = false;
        atFrontPage = false;
    }

    public void setWonGame() {
        wonGame = true;
        lostGame = false;
    }

    public void setLostGame() {
        lostGame = true;
        wonGame = false;
    }

    //================================================================================================================
    // Game State checkers to check current state

    // return true if the game is on the start page
    public boolean atStart() {
        return atFrontPage;
    }

    // return true if the game is presenting a challenge to the user
    public boolean atHardChallenge() {
        return atHardChallenge;
    }

    // return true if the user has won
    public boolean wonHardChallenge() {
        return wonHardChallenge;
    }

    // return true if the user has lost
    public boolean lostHardChallenge() {
        return lostHardChallenge;
    }

    // return true if the game is presenting a challenge to the user
    public boolean atEasyChallenge() {
        return atEasyChallenge;
    }

    // return true if the user has won
    public boolean wonEasyChallenge() {
        return wonEasyChallenge;
    }

    // return true if the user has lost
    public boolean lostEasyChallenge() {
        return lostEasyChallenge;
    }

    public boolean atEnd() {
        return atEndPage;
    }

    public boolean wonGame() {
        return wonGame;
    }

    public boolean lostGame() {
        return lostGame;
    }


}
