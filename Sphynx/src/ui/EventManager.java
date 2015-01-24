package ui;

import model.Challenge;

/**
 * Created by JD on 2015-01-23.
 */
public class EventManager {

    private SphynxGame sg;
    private ChallengeManager cm;
    private UIManager um;
    private State gameState;

    public EventManager(SphynxGame sg, ChallengeManager cm) {
        this.sg = sg;
        this.cm = cm;
        gameState = State.START_SCREEN;

    }

    //called when button is pressed on start screen
    // change game state to before-challenge
    public void handleStartButton(SphynxGame sg) {
        gameState = State.BEFORE_CHALLENGE;
        sg.openBeforeChallenge();
    }

    // called when easy button is pressed in before-challenge screen
    // change game state to easy challenge
    // call SG to start a easy Challenge
    public void handleEasyButton(SphynxGame sg) {
        gameState = State.EASY_CHALLENGE;
        Challenge c = cm.getEasyChallenge();
        sg.startEasyChallenge(c);
    }

    // called when hard button is pressed in before-challenge screen
    // change game state to hard challenge
    // call SG to start a hard Challenge
    public void handleHardButton(SphynxGame sg) {
        gameState = State.HARD_CHALLENGE;
        Challenge c = cm.getHardChallenge();
        sg.startHardChallenge(c);
    }

    // called when a challenged is finished
    // change game state to after-challenge
    // call sg to bring up after challenge screen todo from UImanager?
    public void handleChallengeEnd(SphynxGame sg) {
        gameState = State.AFTER_CHALLENGE;
        sg.challengeEnd();
    }

    public void handleNextChallenge(SphynxGame sg) {
        gameState = State.BEFORE_CHALLENGE;
        sg.openBeforeChallenge();
    }

    // called in end screen when replay button is pressed
    // change state to start
    // call sg to bring up start screen
    public void handleReplayButton(SphynxGame sg) {
        gameState = State.START_SCREEN;
        sg.replay();
    }
}



