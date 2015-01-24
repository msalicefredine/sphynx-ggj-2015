package model;

import java.awt.*;

/**
 * Created by Sultan on 14-12-18.
 */
public class Cell {

    public static final int CELL_SIZE = 40;

    private int x;
    private int y;
    private Color color;
    private int index;


    public Cell(int x, int y, Color color, int index) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.index = index;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public void moveDown() {
        y += 1;
    }

    public void moveRight() {
        x += 1;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fill3DRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, true);
        g.setColor(Color.BLACK);
        g.draw3DRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, false);
    }

    public void draw(Graphics g, Graphics graphics) {
        g.setColor(color);
        g.fill3DRect(x * CELL_SIZE / 2, (y+1) * CELL_SIZE / 2, CELL_SIZE / 2, CELL_SIZE / 2, true);
        g.setColor(Color.BLACK);
        g.draw3DRect(x * CELL_SIZE / 2, (y+1) * CELL_SIZE / 2, CELL_SIZE / 2, CELL_SIZE / 2, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        if (y != cell.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}