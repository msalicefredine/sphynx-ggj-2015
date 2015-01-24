package ui;

import model.Cell;
import model.TetrisGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sultan on 14-12-24.
 */
public class GamePanel extends JPanel {

    private static final String OVER = "GAME OVER";
    private static final String REPLAY = "press R to try again";
    private static final String QUIT = "press X to quit";
    private TetrisGame game;

    public GamePanel(TetrisGame g) {
        setPreferredSize(new Dimension(TetrisGame.WIDTH_CELL * Cell.CELL_SIZE,
                TetrisGame.HEIGHT_CELL * Cell.CELL_SIZE));
        setBackground(Color.WHITE);
        this.game = g;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGame(g);

        if (game.isGameOver()) {
            gameOver(g);
        }
    }

    private void drawGame(Graphics g) {
        game.draw(g);
    }

    // Draws the "game over" message and replay instructions
    // modifies: g
    // effects:  draws "game over" and replay instructions onto g
    private void gameOver(Graphics g) {
        g.setColor(new Color(96, 94, 94));
        g.fill3DRect(1 * Cell.CELL_SIZE, 7 * Cell.CELL_SIZE - Cell.CELL_SIZE / 2,
                8 * Cell.CELL_SIZE, 4 * Cell.CELL_SIZE, true);
        g.setColor(new Color(255, 255, 255));
        g.draw3DRect(1 * Cell.CELL_SIZE, 7 * Cell.CELL_SIZE - Cell.CELL_SIZE / 2,
                8 * Cell.CELL_SIZE, 4 * Cell.CELL_SIZE, false);
        g.setFont(new Font("Helvetica", Font.BOLD, 40));
        FontMetrics fm = g.getFontMetrics();
        centreString(OVER, g, fm, TetrisGame.HEIGHT_CELL * Cell.CELL_SIZE / 2);
        g.setFont(new Font("Helvetica", Font.PLAIN, 20));
        fm = g.getFontMetrics();
        centreString(REPLAY, g, fm, (TetrisGame.HEIGHT_CELL * Cell.CELL_SIZE / 2) + 40);
        centreString(QUIT, g, fm, (TetrisGame.HEIGHT_CELL * Cell.CELL_SIZE / 2) + 60);
    }

    // Centres a string on the screen
    // modifies: g
    // effects:  centres the string str horizontally onto g at vertical position yPos
    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        int width = fm.stringWidth(str);
        g.drawString(str, (TetrisGame.WIDTH_CELL * Cell.CELL_SIZE - width) / 2, yPos);
    }
}
