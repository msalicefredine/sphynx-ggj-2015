package model.space_invaders.ui;

import model.MiniGames;
import model.space_invaders.model.SIGame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Sultan on 15-01-24.
 */
public class SpaceInvaders extends JFrame implements MiniGames {

    private int interval = 20;
    private SIGame game;
    private GamePanel gp;
    private ScorePanel sp;
    private Timer t;

    // Constructs main window
    // effects: sets up window in which Space Invaders game will be played
    public SpaceInvaders(boolean hard) {
        super("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new SIGame();
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

    // Set up timer
    // modifies: none
    // effects:  initializes a timer that updates game each
    //           INTERVAL milliseconds
    private void addTimer(boolean hard) {
        if (hard == true) {
            interval = 10;
        }
        t = new Timer(interval, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.update();
                gp.repaint();
                sp.update();
            }
        });
    }

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    /*
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e);
        }
    }

    // Play the game
    public void run(boolean hard) {
        new SpaceInvaders(hard);
    }

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
