package model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sultan on 14-12-22.
 */
public class OTetrimino extends Tetrimino {

    public OTetrimino() {
        cells = new ArrayList<Cell>();
        Color c = new Color(227, 25, 26);
        cells.add(new Cell(4, 1, c, 1));
        cells.add(new Cell(4, 0, c, 2));
        cells.add(new Cell(5, 0, c, 3));
        cells.add(new Cell(5, 1, c, 4));
    }

    @Override
    public void turn() {
        // nothing happens
    }

}