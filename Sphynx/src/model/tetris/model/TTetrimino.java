package model.tetris.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sultan on 15-01-23.
 */
public class TTetrimino extends Tetrimino {

    public TTetrimino() {
        cells = new ArrayList<Cell>();
        Color c = new Color(250, 250, 25);
        cells.add(new Cell(4, 1, c, 1));
        cells.add(new Cell(3, 0, c, 2));
        cells.add(new Cell(4, 0, c, 3));
        cells.add(new Cell(5, 0, c, 4));
    }

    @Override
    public void turn() {
        if (face == 0) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x - 1);
                    next.setY(y - 1);
                } else if (ind == 2) {
                    next.setX(x + 1);
                    next.setY(y - 1);
                } else if (ind == 4) {
                    next.setX(x - 1);
                    next.setY(y + 1);
                }
            }
            face += 1;
        } else if (face == 1) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x + 1);
                    next.setY(y - 1);
                } else if (ind == 2) {
                    next.setX(x + 1);
                    next.setY(y + 1);
                } else if (ind == 4) {
                    next.setX(x - 1);
                    next.setY(y - 1);
                }
            }
            face += 1;
        } else if (face == 2) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x + 1);
                    next.setY(y + 1);
                } else if (ind == 2) {
                    next.setX(x - 1);
                    next.setY(y + 1);
                } else if (ind == 4) {
                    next.setX(x + 1);
                    next.setY(y - 1);
                }
            }
            face += 1;
        } else if (face == 3) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x - 1);
                    next.setY(y + 1);
                } else if (ind == 2) {
                    next.setX(x - 1);
                    next.setY(y - 1);
                } else if (ind == 4) {
                    next.setX(x + 1);
                    next.setY(y + 1);
                }
            }
            face = 0;
        }
    }

}