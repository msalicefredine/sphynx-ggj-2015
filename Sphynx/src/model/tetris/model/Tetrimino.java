package model.tetris.model;

import java.awt.*;
import java.util.List;

/**
 * Created by Sultan on 15-01-23.
 */
public abstract class Tetrimino {

    protected List<Cell> cells;
    protected int face = 0;
    protected int x;
    protected int y;
    protected int ind;

    public int getFace() {
        return face;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void draw(Graphics g) {
        for (Cell next: cells) {
            next.draw(g, g);
        }
    }

    public void moveDown() {
        for (Cell next: cells)
            next.moveDown();
    }

    public void moveRight() {
        for (Cell next: cells)
            next.moveRight();
    }

    public void moveLeft() {
        for (Cell next: cells)
            next.moveLeft();
    }

    public abstract void turn();

    public void turnSetUpHelper(Cell next) {
        x = next.getX();
        y = next.getY();
        ind = next.getIndex();
    }

}