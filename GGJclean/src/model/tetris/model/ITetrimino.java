package model.tetris.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sultan on 15-01-23.
 */
public class ITetrimino extends Tetrimino {

    public ITetrimino() {
        cells = new ArrayList<Cell>();
        Color c = new Color(255, 158, 25);
        cells.add(new Cell(3, 0, c, 1));
        cells.add(new Cell(4, 0, c, 2));
        cells.add(new Cell(5, 0, c, 3));
        cells.add(new Cell(6, 0, c, 4));
    }

    @Override
    public void turn() {
        if (face == 0 || face == 2) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x + 1);
                    next.setY(y - 1);
                } else if (ind == 3) {
                    next.setX(x - 1);
                    next.setY(y + 1);
                } else if (ind == 4) {
                    next.setX(x - 2);
                    next.setY(y + 2);
                }
            }
            face += 1;
        } else if (face == 1 || face == 3) {
            for (Cell next: cells) {
                turnSetUpHelper(next);
                if (ind == 1) {
                    next.setX(x - 1);
                    next.setY(y + 1);
                } else if (ind == 3) {
                    next.setX(x + 1);
                    next.setY(y - 1);
                } else if (ind == 4) {
                    next.setX(x + 2);
                    next.setY(y - 2);
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