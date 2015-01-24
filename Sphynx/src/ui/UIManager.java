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
	private static final String BACKSTORY = "";
	private static final String CHALLENGE = "What will you do now?";
	private static final String WIN = "You Win!";
	private static final String LOSE = "You have been defeated by the sphynx!";
	private static final String GAMEWIN = "You escaped the Sphynx!";
	private static final String GAMELOSS = "You have been eaten by the Sphynx...";
	private static final String CREDITS = "";
	
	private static final Integer HEIGHT = 200;
	private static final Integer WIDTH = 200;
	
	/* creates a UIManager
	 * sets size and colour of background
	 */
	public UIManager(SphynxGame sg, GameState gs) {
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
		setBackground(new Color(139, 80, 14));
		this.game = sg;
		this.gs = gs;
		}
	
	@Override
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		
		// indicates we need the Backstory screen
		if (gs.atStart()) {
			gameStart(g);
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
			g.setColor(new Color(135, 206, 250)); //sky blue box
			int recX = (int) ((int) WIDTH*0.05);
			int recY = (int) ((int) HEIGHT*0.05);
			int recWidth = (int) ((int) WIDTH*0.9);
			int recHeight = (int) ((int) HEIGHT*0.9);
			g.fillRoundRect(recX, recY, recWidth, recHeight, 2, 2);
			g.setColor(new Color(0, 0, 128)); // navy blue text
			g.setFont(new Font("Arial", 20, 20));
			g.drawString(BACKSTORY, WIDTH / 2, 12);
			JButton b = new JButton("Start...");
			b.setFont(new Font("Arial", 20, 20));
			b.setBackground(new Color(255, 255, 255)); //white button
			b.setForeground(new Color(0, 0, 128));
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
			g.drawString(GAMELOSS, WIDTH / 2, 12);
			JButton b = new JButton("Play Again");
			b.setFont(new Font("Impact", 20, 20));
			b.setBackground(new Color(190, 190, 190)); // grey button
			b.setForeground(new Color(0, 0, 0)); // black text
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
			g.drawString(GAMEWIN, WIDTH / 2, 12);
			JButton b = new JButton("Play Again");
			b.setFont(new Font("Impact", 20, 20)); 
			b.setBackground(new Color(0, 0, 0)); // white button
			b.setForeground(new Color(0, 0, 128)); // navy text
			JButton quit = new JButton("Quit");
			quit.setFont(new Font("Impact", 20, 20)); 
			quit.setBackground(new Color(0, 0, 0)); // white button
			quit.setForeground(new Color(0, 0, 128)); // navy text
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
				g.drawString(WIN + "\n" + CHALLENGE, WIDTH/2,  12);
			}
			else {
				g.drawString(LOSE + "\n" + CHALLENGE, WIDTH/2,  12);
			}
			JButton easy = new JButton("Easy");
			easy.setFont(new Font("Impact", 20, 20)); 
			easy.setBackground(new Color(50, 205, 50)); // green button
			easy.setForeground(new Color(0, 255, 127)); // bright green text
			JButton hard = new JButton("Hard");
			hard.setFont(new Font("Impact", 20, 20)); 
			hard.setBackground(new Color(178, 34, 34)); // firebrick button
			hard.setForeground(new Color(255, 127, 80)); // light orange button
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
			g.drawString(CREDITS, WIDTH / 2, 12);
		}
}
