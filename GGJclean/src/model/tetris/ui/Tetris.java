package model.tetris.ui;

import model.tetris.model.TetrisGame;
import ui.ChallengeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Sultan on 15-01-23.
 */
public class Tetris extends JFrame {

    private int interval = 250;
    private TetrisGame game;
    private GamePanel gp;
    private ScorePanel sp;
    private Timer t;
    private ChallengeManager cm;

    public Tetris(boolean hard, ChallengeManager challengeManager) {
        super("Tetris");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        game = new TetrisGame();
        cm = challengeManager;
        gp = new GamePanel(game);
        sp = new ScorePanel(game);
        add(gp);
        add(sp, BorderLayout.NORTH);
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer(hard);
        t.start();
    }

    private void addTimer(boolean hard) {
        if (hard == true) {
            interval = 125;
        }
        t = new Timer(interval, new ActionListener(){
            int acc = 0;
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.update();
                acc++;
                if (acc == interval) {
                    cm.setWin(false);
                    dispose();
                }
                if (game.update() == true) {
                    cm.setWin(true);
                    dispose();
                }
                gp.repaint();
                sp.repaint();

            }
        });
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
}