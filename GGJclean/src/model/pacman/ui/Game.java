package model.pacman.ui;

import model.pacman.model.Board;
import model.pacman.model.Pacman;
import ui.ChallengeManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Taken from UBC CPSC210 lab on 15-01-24.
 */
public class Game extends JFrame {

    private Board gameBoard;

    private BoardPanel gameViewPanel;

    private Timer gameTicker;

    private ChallengeManager cm;

    // Requires: nothing
    // Modifies: this
    // Effects:  Performs all initializing by creating the board model and graphic view of the board as well as the game ticker
    public Game(ChallengeManager challengeManager) {
        super("Pacman");
        cm = challengeManager;
        init();
    }

    // Requires: nothing
    // Modifies: this
    // Effects:  creates the Board for the game and sets up the GUI windows and buttons, the game timer, and begins the game
    private void init() {
        gameBoard = new Board();

        createMenus();
        setupViewPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        repaint();
        setVisible(true);

        setupGameTicker();

        setFocusable(true);
        addKeyListener(new KeyboardController());
    }

    // Requires: nothing
    // Modifies: this
    // Effects:  Sets up the game ticker.  If a ticker exists already it is turned off and discarded.
    private void setupGameTicker() {
        if (gameTicker != null) {
            gameTicker.stop();
        }
        gameTicker = new Timer(750, new GameTickerActionListener());
        gameTicker.start();
    }

    // Requires: nothing
    // Modifies: this
    // Effects:  creates the main game panel for board display
    private void setupViewPanel() {
        gameViewPanel = new BoardPanel(gameBoard);
        this.add(gameViewPanel);
    }

    // Requires: nothing
    // Modifies: this
    // Effects:  creates the menubar and menu items (only one, for resetting the game)
    private void createMenus() {
        JMenuBar menuBar = new JMenuBar();
        JMenu drawingMenu = new JMenu("Pacman");

        JMenuItem resetGame = new JMenuItem("Reset Game");
        resetGame.addActionListener(new ResetGameAction());
        drawingMenu.add(resetGame);

        menuBar.add(drawingMenu);
        this.setJMenuBar(menuBar);
    }

    private class ResetGameAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            init();
        }
    }

    private class GameTickerActionListener extends AbstractAction {
        int acc = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameBoard.isGameOver() || !gameBoard.isFoodOver()) {
                gameBoard.tickBoard();
                gameViewPanel.repaint();
                acc++;
            } else {
                if (acc == 750 || gameBoard.isGameOver()) {
                    cm.setWin(false);
                } else if (gameBoard.isFoodOver()) {
                    cm.setWin(true);
                }
                gameViewPanel.repaint();
                gameTicker.stop();
            }
        }
    }

    private class KeyboardController implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            Pacman p = gameBoard.getPacman();

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT: // Left
                    p.setDirection('L'); break;
                case KeyEvent.VK_UP: // Up
                    p.setDirection('U'); break;
                case KeyEvent.VK_RIGHT: // Right
                    p.setDirection('R'); break;
                case KeyEvent.VK_DOWN: // Down
                    p.setDirection('D'); break;
                case KeyEvent.VK_SPACE: // Space
                    p.setDirection('S'); break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
}
