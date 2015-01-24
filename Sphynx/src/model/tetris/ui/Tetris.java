package model.tetris.ui;

import model.MiniGames;
import model.tetris.model.TetrisGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Sultan on 15-01-23.
 */
public class Tetris extends JFrame implements MiniGames {

    private int interval;
    private TetrisGame game;
    private GamePanel gp;
    private ScorePanel sp;
    private Timer t;

    public Tetris(boolean hard) {
        super("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new TetrisGame();
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
        } else {
            interval = 250;
        }
        t = new Timer(interval, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.update();
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

    public void run(boolean hard) {
        new Tetris(hard);
    }
}