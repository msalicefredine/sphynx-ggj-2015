package model.tetris.ui;

import model.tetris.model.Cell;
import model.tetris.model.Tetrimino;
import model.tetris.model.TetrisGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sultan on 15-01-23.
 */
public class ScorePanel extends JPanel {
    private static final String SCORE_STRING = "your score is ";
    private String scoreString;
    private int score;
    private static final String NEXT = "<= is your next tetrimino";
    private TetrisGame game;
    private Tetrimino next;

    public ScorePanel(TetrisGame game) {
        setPreferredSize(new Dimension(TetrisGame.WIDTH_CELL * Cell.CELL_SIZE / 2,
                TetrisGame.HEIGHT_CELL * Cell.CELL_SIZE / 8));
        setBackground(new Color(96, 94, 94));
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        next = game.getNextTetrimino();
        next.draw(g);
        g.setFont(new Font("SansSerif", Font.PLAIN, 20));
        g.setColor(Color.WHITE);
        FontMetrics fm = g.getFontMetrics();
        centreString(NEXT, g, fm, TetrisGame.HEIGHT_CELL * Cell.CELL_SIZE / 16);
        score = game.getScore();
        scoreString = SCORE_STRING + score;
        centreString(scoreString, g, fm, 3 * TetrisGame.HEIGHT_CELL * Cell.CELL_SIZE / 32);
    }

    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        g.drawString(str, TetrisGame.WIDTH_CELL * Cell.CELL_SIZE / 2 - 3 * Cell.CELL_SIZE / 2 , yPos);
    }

}
