package model.tetris.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sultan on 15-01-23.
 */
public class STetrimino extends Tetrimino {

    public STetrimino() {
        cells = new ArrayList<Cell>();
        Color c = new Color(25, 215, 227);
        cells.add(new Cell(3, 1, c, 1));
        cells.add(new Cell(4, 1, c, 2));
        cells.add(new Cell(4, 0, c, 3));
        cells.add(new Cell(5, 0, c, 4));
    }

    @Override
    public void turn() {
        if (face == 0 || face == 2) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x + 1);
                    next.setY(y - 2);
                } else if (ind == 2) {
                    next.setY(y - 1);
                } else if (ind == 3) {
                    next.setX(x + 1);
                } else if (ind == 4) {
                    next.setY(y + 1);
                }
            }
            face += 1;
        } else if (face == 1 || face == 3) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x - 1);
                    next.setY(y + 2);
                } else if (ind == 2) {
                    next.setY(y + 1);
                } else if (ind == 3) {
                    next.setX(x - 1);
                } else if (ind == 4) {
                    next.setY(y - 1);
                }
            }
            if (face == 1) {
                face = 2;
            } else {
                face = 0;
            }
        }
    }

}