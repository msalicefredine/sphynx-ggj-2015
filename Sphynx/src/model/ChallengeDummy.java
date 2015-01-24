package model;

import java.awt.Color;
import java.awt.Graphics;

public class ChallengeDummy implements Challenge {
	
	 private static final String MINIGAME = "I am a minigame";
	
	public ChallengeDummy() {
		
	}
	
	/**
	 * Should draw the game etc.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(135, 206, 260));
		g.drawRoundRect(10, 10, 180, 180, 2, 2);
		g.drawString(MINIGAME, 200, 12);
	}
	
	

}
