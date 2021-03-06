package model.pacman.ui;

import model.pacman.model.Board;
import model.pacman.model.GridLocation;

import javax.swing.*;
import java.awt.*;

/**
 * Taken from UBC CPSC210 lab on 15-01-24.
 */
public class BoardPanel extends JPanel {
    Board gameBoard;

    // Requires: A valid game board gameBoard
    // Modifies: this
    // Effects:  sets up this panel based on the dimensions and contents of gameBoard
    public BoardPanel(Board gameBoard) {
        this.gameBoard = gameBoard;

        initLayout();
        initGridPanels();

        setVisible(true);
    }

    // Requires: nothing
    // Modifies: g
    // Effects:  delegates most painting to the children of the panel, except when the game is over, prints a message over top of the board
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (gameBoard.isGameOver() || gameBoard.isFoodOver()) {
            Color saved = g.getColor();
            g.setColor(Color.RED);
            g.setFont(new Font("Arial Bold", 20, 20));
            FontMetrics fm = g.getFontMetrics();
            centreString("GAME OVER!", g, fm, getHeight() / 2);
            centreString("RESET THE GAME TO REPLAY.", g, fm, getHeight() / 2 + 50);
            g.setColor(saved);
        }
    }

    // Requires: nothing
    // Modifies: g
    // Effects:  draw's str, centered horizontally in the panel given a font and y position
    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        int width = fm.stringWidth(str);
        g.drawString(str, (getWidth() - width) / 2, yPos);
    }

    // Requires: nothing
    // Modifies: this
    // Effects:  initializes a GUI GridLayout that's sized according to the board we are displaying
    public void initLayout() {
        setLayout(new GridLayout(gameBoard.getBoardHeight(), gameBoard.getBoardWidth()));
    }

    // Requires: nothing
    // Modifies: this
    // Effects:  Initializes each location in the gridlayout by creating a GridLocationPanel associated with the proper location on the board
    public void initGridPanels() {
        for (java.util.List<GridLocation> row: gameBoard.getGridRows()) {
            for (GridLocation g : row) {
                JPanel j = new GridLocationPanel(g);
                j.setVisible(true);
                add(j);
            }
        }
    }
}
