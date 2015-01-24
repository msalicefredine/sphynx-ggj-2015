package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cpsc210.spaceinvaders.model.Sprite;

/**
 * Created by JD on 2015-01-23.
 */
public class UIManager extends JPanel {
	
	private SphynxGame game;
	private static final String BACKSTORY = "";
	private static final String CHALLENGE = "";
	private static final String WIN = "";
	private static final String LOSE = "";
	
	private static final Integer HEIGHT = 200;
	private static final Integer WIDTH = 200;
	
	/* creates a UIManager
	 * sets size and colour of background
	 */
	public UIManager(SphynxGame sg) {
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
		setBackground(new Color(139, 80, 14));
		this.game = sg;
		}
	
	@Override
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		drawGame(g);
		
		// indicates we need the Backstory screen
		if (game.isStart()) {
			gameStart(g);
		}
		
		// indicates the game is posing a challenge to the USER
		if (game.isChallenge()) {
			gameChallenge(g);
		}
		
		// indicates the USER has won the game
		if (game.isWin()) {
			gameWin(g);
		}
		
		// the USER has been defeated by the Sphynx
		if (game.isLoss()) {
			gameLoss(g);
		}
		
	}
	


		// Draws the game
		// modifies: g
		// effects:  the game is drawn onto the Graphics object g
		private void drawGame(Graphics g) {
			game.draw(g); // need this method in game to draw not only UI, but any minigames
		}
		
		// Draws the Backstory message and the start button
		private void gameStart(Graphics g) {
			Color saved = g.getColor();
			g.setColor(new Color(135, 206, 260));
			g.drawRoundRect(10, 10, 180, 180, 2, 2);
			g.setColor(new Color(135, 206, 250));
			g.fillRoundRect(10, 10, 180, 180, 2, 2);
			g.setColor(new Color(0, 0, 0));
			g.setFont(new Font("Arial", 20, 20));
			g.drawString(BACKSTORY, WIDTH / 2, 12);
			JButton b = new JButton("Start...");
			b.setFont(new Font("Arial", 20, 20));
			b.setBackground(new Color(125, 206, 250));
			b.setForeground(new Color(0, 0, 0));

		}
		
	    private void gameLoss(Graphics g) {
		// TODO Auto-generated method stub
		
	}

		private void gameWin(Graphics g) {
		// TODO Auto-generated method stub
		
	}

		private void gameChallenge(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
