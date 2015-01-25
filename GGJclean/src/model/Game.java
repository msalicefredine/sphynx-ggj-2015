package model;

import model.space_invaders.ui.SpaceInvaders;
import model.tetris.ui.Tetris;
import ui.ChallengeManager;
import ui.GameState;
import ui.SphynxGame;

import java.awt.event.KeyEvent;

/**
 * Created by Sultan on 15-01-24.
 */
public class Game {

    private static int STEP_EASY = 10;
    private static int STEP_HARD = 20;
    private boolean hardOn;
    private SphynxGame sphynxGame;

    public Game(SphynxGame sphynxGame) {
        this.sphynxGame = sphynxGame;

    }

    public void updateScore(boolean b) {

        if (b) {
            sphynxGame.getTimeManager().addBonusTime();
            sphynxGame.getGameState().setWonChallenge();

            if (hardOn) {
                sphynxGame.getGameState().getPath().moveBy(STEP_HARD);
            }
            else sphynxGame.getGameState().getPath().moveBy(STEP_EASY);
        }
        
        else sphynxGame.getGameState().setLostChallenge();
    }

    public void keyPressed(KeyEvent e) {

        if (sphynxGame.getGameState().atStart() && e.getKeyCode() == KeyEvent.VK_SPACE) {
            sphynxGame.getGameState().atChallengeMenu();
        }

        if (sphynxGame.getGameState().atChallengeMenu()) {

            if (e.getKeyCode() == KeyEvent.VK_H) {
                updateScore(sphynxGame.getChallengeManager().startChallenge(true));
                sphynxGame.getGameState().atChallengeMenu();
                hardOn = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_E) {
                updateScore(sphynxGame.getChallengeManager().startChallenge(false));
                sphynxGame.getGameState().atChallengeMenu();
                hardOn = false;
            }
        }

    }
}
