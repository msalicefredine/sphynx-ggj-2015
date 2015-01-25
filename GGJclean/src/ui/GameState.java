package ui;

import model.Path;

/**
 * Created by mohamedshaaban on 15-01-24.
 */
public class GameState {


    private boolean atFrontPage;
    private boolean atChallengeMenu;
    private boolean wonChallenge;
    private boolean lostChallenge;
    private boolean atEndPage;
    private boolean wonGame;
    private boolean lostGame;
    private Path path;

    public GameState() {

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
        atChallengeMenu = false;
    }

    public void setAtChallengeMenue() {
        atChallengeMenu = true;
        atFrontPage = false;
        atEndPage = false;
    }



    public void setLostChallenge() {
        lostChallenge = true;
        wonChallenge = false;

    }

    public void setWonChallenge() {
        lostChallenge = false;
        wonChallenge = true;

    }


    public void setAtEnd() {
        atEndPage = true;
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

    public boolean atChallengeMenu() {
        return atChallengeMenu;
    }

    // return true if the user has won
    public boolean wonChallenge() {
        return wonChallenge;
    }

    // return true if the user has lost Challenge
    public boolean lostChallenge() {
        return lostChallenge;
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
