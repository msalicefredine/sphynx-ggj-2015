package model;

import java.awt.Graphics;

/**
 * Created by JD on 2015-01-23.
 */
public interface Challenge {
	
	/**
	 * Should draw the game etc. Should probably get called in the minigame's loop.
	 */
	public void draw(Graphics g);
	
}
