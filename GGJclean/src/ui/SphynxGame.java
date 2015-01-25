package ui;

import model.Game;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by Sultan on 15-01-24.
 */
public class SphynxGame extends JFrame {

    private Game game;
    private UIManager uiManager;
    private GameState gameState;
    private ChallengeManager challengeManager;
    private TimeManager timeManager;


    public SphynxGame() {

        super("Sphynx");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        game = new Game(this);

        gameState = new GameState();
        gameState.setAtStart();

        challengeManager = new ChallengeManager();

        timeManager = new TimeManager();

        uiManager = new UIManager(this, gameState);

        add(uiManager);
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
    }

    public GameState getGameState() {
        return gameState;
    }

    public ChallengeManager getChallengeManager() {
        return challengeManager;
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }


    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e);
        }
    }

    public static void main(String[] args) {
        new SphynxGame();
    }
}
