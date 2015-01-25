package ui;

import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Sultan on 15-01-24.
 */
public class SphynxGame extends JFrame {

    private static final int INTERVAL = 200;
    private Game game;
    private UIManager uiManager;
    private GameState gameState;


    public SphynxGame() {

        super("Sphynx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        game = new Game();
        gameState = new GameState();
        gameState.setAtStart();
        uiManager = new UIManager(this, gameState);

        add(uiManager);
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
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
