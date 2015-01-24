package model;

import model.space_invaders.ui.SpaceInvaders;
import model.tetris.ui.Tetris;

import java.awt.event.KeyEvent;

/**
 * Created by Sultan on 15-01-24.
 */
public class Game {
    private model.pacman.ui.Game pacman;
    private Tetris tetris;
    private SpaceInvaders spaceInvaders;

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_KP_LEFT || e.getKeyCode() == KeyEvent.VK_LEFT) {
            spaceInvaders = new SpaceInvaders(false);
        } else if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            tetris = new Tetris(false);
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            System.exit(0);
        }
    }
}
