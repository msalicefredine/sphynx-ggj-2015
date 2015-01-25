package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private static final String CREDITS = "Credits";
	
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
		
		Image i = null;
		try {
			i = ImageIO.read(new File("res/sphynxbackground.png"));
		} catch (IOException e) {
		}
		
		g.drawImage(i, 0, 0, WIDTH, HEIGHT, 0, 0, 1367, 764, null);
		
		
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
		paintComponent(game.getGraphics());
	}
	
	private void renderTimer(Graphics g) {
		int timeX = (int) ((int) (2*WIDTH)/5);
		int timeY = (int) ((int) (HEIGHT*0.85));
		int timeWIDTH = (int) ((int) WIDTH/5);
		int timeHEIGHT = (int) ((int) HEIGHT*0.2);
		g.setColor(new Color(220, 34, 34)); // red timer
		g.fillRoundRect(timeX, timeY, timeWIDTH, timeHEIGHT, 10, 10);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", 10, 70));
		String time = "1:00";
		centerString(time, g, HEIGHT);
	}
	
	private void renderRectangle(Graphics g) {
		int recX = (int) ((int) WIDTH*0.05);
		int recY = (int) ((int) HEIGHT*0.05);
		int recWidth = (int) ((int) WIDTH*0.9);
		int recHeight = (int) ((int) HEIGHT*0.8);
		g.fillRoundRect(recX, recY, recWidth, recHeight, 10, 10);
	}
	
	private void centerString(String s, Graphics g, int y) {
		FontMetrics fm = g.getFontMetrics();
		int width = fm.stringWidth(s);
		g.drawString(s, (WIDTH - width)/2, y);
	}
		
		// Draws the Backstory message and the start button
		private void gameStart(Graphics g) {
			Color saved = g.getColor();
			g.setColor(new Color(245, 222, 179)); //wheat box
			int recX = (int) ((int) WIDTH*0.05);
			renderRectangle(g);
			renderTimer(g);
			g.setColor(new Color(139, 69, 19)); // saddle brown text
			g.setFont(new Font("Herculanum", 20, 20));
			g.drawString(BACKSTORY, recX + 5, HEIGHT/2);
			g.setColor(saved);

		}
		
		// Renders the user loss *make this an animation if we can
	    private void gameLoss(Graphics g) {
	    	Color saved = g.getColor();
			g.setColor(Color.BLACK); // black box
			renderRectangle(g);
			renderTimer(g);
			g.setColor(new Color(220, 34, 34)); // red text
			g.setFont(new Font("Herculanum", Font.BOLD, 30));
			centerString("You have been eaten by the", g, HEIGHT/3);
			g.setFont(new Font("Herculanum", Font.BOLD, 40));
			centerString("SPHYNX...", g, (HEIGHT/3 + 30));
			g.setFont(new Font("Herculanum", 10, 20));
			g.drawString("Press y to", WIDTH/5, (2*HEIGHT)/3);
			g.drawString("play again...", WIDTH/5, ((2*HEIGHT)/3 + 20));
			g.drawString("Press n to", (3*WIDTH)/5, (2*HEIGHT)/3);
			g.drawString("give up...", (3*WIDTH)/5, ((2*HEIGHT)/3 + 20));
			g.setColor(saved);
		
	}
	    // Display Game Win text and play again option
		private void gameWin(Graphics g) {
			Color saved = g.getColor();
			g.setColor(new Color(245, 222, 179)); 
			renderRectangle(g);
			renderTimer(g);
			g.setColor(new Color(255, 99, 71)); // navy text
			g.setFont(new Font("Herculanum", Font.BOLD, 30));
			centerString(GAMEWIN, g, HEIGHT/3);
			g.setFont(new Font("Herculanum", 10, 20));
			g.drawString("Press y to", WIDTH/5, (2*HEIGHT)/3);
			g.drawString("play again...", WIDTH/5, ((2*HEIGHT)/3 + 20));
			g.drawString("Press n to", (3*WIDTH)/5, (2*HEIGHT)/3);
			g.drawString("get out now...", (3*WIDTH)/5, ((2*HEIGHT)/3 + 20));
			g.setColor(saved);
		
	}

		// display challenge dialogue box
		private void gameChallenge(Graphics g) {
			Color saved = g.getColor();
			g.setColor(new Color(245, 222, 179)); // wheat box
			renderRectangle(g);
			renderTimer(g);
			g.setColor(new Color(139, 69, 19)); 
			g.setFont(new Font("Herculanum", 30, 30));
			if (gs.wonEasyChallenge() || gs.wonHardChallenge()) {
				centerString(WIN, g, HEIGHT/3);
			}
			else if (gs.lostChallenge()) {
				centerString(LOSE, g, HEIGHT/3);
			}
			else {
				centerString("Here we go.", g, HEIGHT/3);
			}
			centerString(CHALLENGE, g, HEIGHT/2);
			g.setFont(new Font("Herculanum", 0, 20));
			g.drawString("Press E to take", WIDTH/5, (2*HEIGHT)/3);
			g.drawString("the easy way out...", WIDTH/5, ((2*HEIGHT)/3 + 20));
			g.drawString("Press H to", (3*WIDTH)/5, (2*HEIGHT)/3);
			g.drawString("be brave...", (3*WIDTH)/5, ((2*HEIGHT)/3 + 20));
			g.setColor(saved);
		
	}
		
		// display the credits for the game
		public void gameEnd(Graphics g) {
			g.setColor(new Color(245, 222, 179)); //sky blue box
			renderRectangle(g);
			g.setColor(new Color(0, 0, 128)); // navy blue text
			g.setFont(new Font("Herculanum", 20, 20));
			centerString(CREDITS, g, (int) ((int) HEIGHT*0.05 + 20));
			g.setColor(Color.WHITE);
			g.setFont(new Font("Herculanum", Font.BOLD, 40));
			String s = "THANKS FOR PLAYING";
			centerString(s, g, (HEIGHT - 10));
		}
}
