package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * Created by JD on 2015-01-23.
 */
public class UIManager extends JPanel {
	
	private SphynxGame game;
	private GameState gs;
	private static final String BACKSTORY = "Hello World";
	private static final String CHALLENGE = "What will you do now?";
	private static final String WIN = "You Win!";
	private static final String LOSE = "You have been defeated by the sphynx!";
	private static final String GAMEWIN = "You escaped the Sphynx!";
	private static final String GAMELOSS = "You have been eaten by the Sphynx...";
	private static final String CREDITS = "";
	
	private static final Integer HEIGHT = 384;
	private static final Integer WIDTH = 683;
	
	/* creates a UIManager
	 * sets size and colour of background
	 */
	public UIManager(SphynxGame sg, GameState gs) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(139, 80, 14));
		this.game = sg;
		this.gs = gs;
		}
	
	@Override
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		
		// indicates we need the Backstory screen
		if (gs.atStart()) {
			gameChallenge(g);
		}
		
		// indicates the game is posing a challenge to the USER
		if (gs.atChallengeMenu()) {
			gameChallenge(g);
		}
		
		// indicates the USER has won the game
		if (gs.wonGame()) {
			gameWin(g);
		}
		
		// the USER has been defeated by the Sphynx
		if (gs.lostGame()) {
			gameLoss(g);
		}
		
		if (gs.atEnd()) {
			gameEnd(g);
		}
		
	}
	
	public void update(ActionEvent ae) {
	 // TODO stub
	}
	
		
		// Draws the Backstory message and the start button
		private void gameStart(Graphics g) {
			Color saved = g.getColor();
			g.setColor(new Color(245, 222, 179)); //wheat box
			int recX = (int) ((int) WIDTH*0.05);
			int recY = (int) ((int) HEIGHT*0.05);
			int recWidth = (int) ((int) WIDTH*0.9);
			int recHeight = (int) ((int) HEIGHT*0.9);
			g.fillRoundRect(recX, recY, recWidth, recHeight, 10, 10);
			g.setColor(new Color(139, 69, 19)); // saddle brown text
			g.setFont(new Font("Arial", 20, 20));
			g.drawString(BACKSTORY, recX + 5, HEIGHT/2);
			g.setColor(saved);

		}
		
		// Renders the user loss *make this an animation if we can
	    private void gameLoss(Graphics g) {
	    	Color saved = g.getColor();
			g.setColor(new Color(178, 34, 34)); //firebrick box
			int recX = (int) ((int) WIDTH*0.05);
			int recY = (int) ((int) HEIGHT*0.05);
			int recWidth = (int) ((int) WIDTH*0.9);
			int recHeight = (int) ((int) HEIGHT*0.9);
			g.fillRoundRect(recX, recY, recWidth, recHeight, 2, 2);
			g.setColor(new Color(0, 0, 0)); // black text
			g.setFont(new Font("Impact", 30, 30));
			g.drawString(GAMELOSS, recX + 5, HEIGHT/2);
			g.setColor(saved);
		
	}
	    // Display Game Win text and play again option
		private void gameWin(Graphics g) {
			Color saved = g.getColor();
			g.setColor(new Color(64, 224, 208)); //turquoise box
			int recX = (int) ((int) WIDTH*0.05);
			int recY = (int) ((int) HEIGHT*0.05);
			int recWidth = (int) ((int) WIDTH*0.9);
			int recHeight = (int) ((int) HEIGHT*0.9);
			g.fillRoundRect(recX, recY, recWidth, recHeight, 2, 2);
			g.setColor(new Color(0, 0, 128)); // navy text
			g.setFont(new Font("Impact", 30, 30));
			g.drawString(GAMEWIN, recX + 5, HEIGHT/2);
			g.setColor(saved);
		
	}

		// display challenge dialogue box
		private void gameChallenge(Graphics g) {
			Color saved = g.getColor();
			g.setColor(new Color(135, 206, 250)); // sky blue 
			int recX = (int) ((int) WIDTH*0.05);
			int recY = (int) ((int) HEIGHT*0.05);
			int recWidth = (int) ((int) WIDTH*0.9);
			int recHeight = (int) ((int) HEIGHT*0.9);
			g.fillRoundRect(recX, recY, recWidth, recHeight, 2, 2);
			g.setColor(new Color(0, 0, 128)); // navy text
			g.setFont(new Font("Impact", 30, 30));
			if (gs.wonEasyChallenge() || gs.wonHardChallenge()) {
				g.drawString(WIN, recX + 5, HEIGHT/3);
			}
			else {
				g.drawString(LOSE, recX + 5, HEIGHT/3);
			}
			g.drawString(CHALLENGE, recX + 5, (2*HEIGHT)/3);
			g.setColor(saved);
		
	}
		
		// display the credits for the game
		public void gameEnd(Graphics g) {
			g.setColor(new Color(135, 206, 250)); //sky blue box
			int recX = (int) ((int) WIDTH*0.05);
			int recY = (int) ((int) HEIGHT*0.05);
			int recWidth = (int) ((int) WIDTH*0.9);
			int recHeight = (int) ((int) HEIGHT*0.9);
			g.fillRoundRect(recX, recY, recWidth, recHeight, 2, 2);
			g.setColor(new Color(0, 0, 128)); // navy blue text
			g.setFont(new Font("Arial", 20, 20));
			g.drawString(CREDITS, recX + 5, recY + 15);
		}
}
