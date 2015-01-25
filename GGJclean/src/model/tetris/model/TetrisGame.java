package model.tetris.model;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sultan on 15-01-23.
 */
public class TetrisGame {

    public static final int WIDTH_CELL = 10;
    public static final int HEIGHT_CELL = 16;

    private List<Cell> cells;
    private Tetrimino currentTetrimino;
    private Tetrimino nextTetrimino;
    private boolean isGameOver;
    private int score;

    public TetrisGame() {
        cells = new ArrayList<Cell>();
        setUp();
    }

    public int getScore() {
        return score;
    }

    public Tetrimino getNextTetrimino() {
        return nextTetrimino;
    }

    private void setUp() {
        cells.clear();
        currentTetrimino = randomTetrimino();
        nextTetrimino = randomTetrimino();
        score = 0;
        isGameOver = false;
    }

    public boolean update() {
        if (!canMoveDown(currentTetrimino)) {
            cells.addAll(currentTetrimino.getCells());
            if (canMoveDown(nextTetrimino)) {
                currentTetrimino = nextTetrimino;
                nextTetrimino = randomTetrimino();
                score += 4;
            } else {
                isGameOver = true;
            }
        } else if (score >= 100) {
            return true;
        } else {
            currentTetrimino.moveDown();
        }
        clearFullLines();
        checkGameOver();
        return false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void draw(Graphics g) {
        for (Cell next: cells)
            next.draw(g);
        for (Cell next: currentTetrimino.getCells())
            next.draw(g);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_KP_LEFT || e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (canMoveLeft()) {
                currentTetrimino.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (canMoveRight()) {
                currentTetrimino.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_KP_UP || e.getKeyCode() == KeyEvent.VK_UP) {
            if (canTurn()) {
                currentTetrimino.turn();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_KP_DOWN || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (canMoveDown(currentTetrimino))
                currentTetrimino.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            setUp();
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            System.exit(0);
        }
    }

    private Tetrimino randomTetrimino() {
        int i = (int)(Math.random()*7);
        if (i == 0) {
            return new ITetrimino();
        } else if (i == 1) {
            return new JTetrimino();
        } else if (i == 2) {
            return new LTetrimino();
        } else if (i == 3) {
            return new OTetrimino();
        } else if (i == 4) {
            return new STetrimino();
        } else if (i == 5) {
            return new TTetrimino();
        } else {
            return new ZTetrimino();
        }
    }

    private void clearFullLines() {
        for (int y = 0; y < HEIGHT_CELL; y++) {
            int acc = 0;
            List<Cell> containedCells = new ArrayList<Cell>();
            for (int x = 0; x < WIDTH_CELL; x++) {
                Cell cell = new Cell(x, y, new Color(0), 0 );
                if (cells.contains(cell)) {
                    acc += 1;
                    containedCells.add(cell);
                }
            }
            if (acc == WIDTH_CELL) {
                cells.removeAll(containedCells);
                score += WIDTH_CELL;
                moveCellsDown(y);
            }
        }
    }

    private void moveCellsDown(int y) {
        for (Cell next: cells) {
            if (next.getY() < y) {
                next.moveDown();
            }
        }
    }

    private void checkGameOver() {
        for (Cell next: cells) {
            if (next.getY() == 0) {
                isGameOver = true;
            }
        }
    }

    private boolean canMoveDown(Tetrimino tetrimino) {
        boolean canMoveDown = true;
        for (Cell next: tetrimino.getCells()) {
            Cell cellUnder = new Cell(next.getX(), next.getY() + 1, new Color(0), 0 );
            if (cells.contains(cellUnder) || (next.getY() == HEIGHT_CELL - 1)) {
                canMoveDown = false;
            }
        }
        return canMoveDown;
    }

    private boolean canMoveLeft() {
        int acc = 0;
        for (Cell next: currentTetrimino.getCells()) {
            Cell cellToLeft = new Cell(next.getX() - 1, next.getY(), new Color(0), 0 );
            if (!cells.contains(cellToLeft) && !(next.getX() == 0))
                acc += 1;
        }
        return acc == 4;
    }

    private boolean canMoveRight() {
        int acc = 0;
        for (Cell next: currentTetrimino.getCells()) {
            Cell cellToRight = new Cell(next.getX() + 1, next.getY(), new Color(0), 0 );
            if (!cells.contains(cellToRight) && !(next.getX() == WIDTH_CELL - 1))
                acc += 1;
        }
        return acc == 4;
    }

    private boolean canTurn() {
        if (currentTetrimino instanceof ITetrimino)
            return canTurnITetrimino();
        else if (currentTetrimino instanceof JTetrimino)
            return canTurnJTetrimino();
        else if (currentTetrimino instanceof LTetrimino)
            return canTurnLTetrimino();
        else if (currentTetrimino instanceof OTetrimino)
            return true;
        else if (currentTetrimino instanceof STetrimino)
            return canTurnSTetrimino();
        else if (currentTetrimino instanceof TTetrimino)
            return canTurnTTetrimino();
        else
            return canTurnZTetrimino();
    }

    private boolean canTurnITetrimino() {
        boolean canTurn = false;
        int face = currentTetrimino.getFace();
        for (Cell next: currentTetrimino.getCells()) {
            if (next.getIndex() == 2) {
                int x = next.getX();
                int y = next.getY();
                Color c = new Color(0);
                Cell cellZeroOne = new Cell(x - 1, y, c, 0);
                Cell cellZeroThree = new Cell(x + 1, y, c, 0);
                Cell cellZeroFour = new Cell(x + 2, y, c, 0);
                Cell cellOneOne = new Cell(x, y - 1, c, 0);
                Cell cellOneThree = new Cell(x, y + 1, c, 0);
                Cell cellOneFour = new Cell(x, y + 2, c, 0);
                boolean onTheEdge = (face == 1 || face == 3) && (x == 0 || x == WIDTH_CELL -1);
                canTurn = (!(cells.contains(cellZeroOne) ||
                        cells.contains(cellZeroThree) ||
                        cells.contains(cellZeroFour) ||
                        cells.contains(cellOneOne) ||
                        cells.contains(cellOneThree) ||
                        cells.contains(cellOneFour)) &&
                        !onTheEdge) ;
            }
        }
        return canTurn;
    }

    private boolean canTurnJTetrimino() {
        boolean canTurn = false;
        int face = currentTetrimino.getFace();
        for (Cell next: currentTetrimino.getCells()) {
            if (next.getIndex() == 2) {
                int x = next.getX();
                int y = next.getY();
                Color c = new Color(0);
                if (face == 0) {
                    Cell cellOneOne = new Cell(x, y - 1, c, 0);
                    Cell cellOneThree = new Cell(x, y + 1, c, 0);
                    Cell cellOneFour = new Cell(x - 1, y + 1, c, 0);
                    canTurn = !(cells.contains(cellOneOne) ||
                            cells.contains(cellOneThree) ||
                            cells.contains(cellOneFour));
                } else if (face == 1) {
                    Cell cellTwoOne = new Cell(x + 1, y, c, 0);
                    Cell cellTwoThree = new Cell(x - 1, y, c, 0);
                    Cell cellTwoFour = new Cell(x - 1, y - 1, c, 0);
                    boolean onTheEdge = x==WIDTH_CELL-1;
                    canTurn = (!(cells.contains(cellTwoOne) ||
                            cells.contains(cellTwoThree) ||
                            cells.contains(cellTwoFour)) &&
                            !onTheEdge);
                } else if (face == 2) {
                    Cell cellThreeOne = new Cell(x, y + 1, c, 0);
                    Cell cellThreeThree = new Cell(x, y - 1, c, 0);
                    Cell cellThreeFour = new Cell(x + 1, y - 1, c, 0);
                    canTurn = !(cells.contains(cellThreeOne) ||
                            cells.contains(cellThreeThree) ||
                            cells.contains(cellThreeFour));
                } else if (face == 3) {
                    Cell cellZeroOne = new Cell(x - 1, y, c, 0);
                    Cell cellZeroThree = new Cell(x + 1, y, c, 0);
                    Cell cellZeroFour = new Cell(x + 1, y + 1, c, 0);
                    boolean onTheEdge = x==0;
                    canTurn = (!(cells.contains(cellZeroOne) ||
                            cells.contains(cellZeroThree) ||
                            cells.contains(cellZeroFour)) &&
                            !onTheEdge);
                }
            }
        }
        return canTurn;
    }

    private boolean canTurnLTetrimino() {
        boolean canTurn = false;
        int face = currentTetrimino.getFace();
        for (Cell next: currentTetrimino.getCells()) {
            if (next.getIndex() == 3) {
                int x = next.getX();
                int y = next.getY();
                Color c = new Color(0);
                if (face == 0) {
                    Cell cellOneOne = new Cell(x - 1, y - 1, c, 0);
                    Cell cellOneTwo = new Cell(x, y - 1, c, 0);
                    Cell cellOneFour = new Cell(x, y + 1, c, 0);
                    canTurn = !(cells.contains(cellOneOne) ||
                            cells.contains(cellOneTwo) ||
                            cells.contains(cellOneFour));
                } else if (face == 1) {
                    Cell cellTwoOne = new Cell(x + 1, y - 1, c, 0);
                    Cell cellTwoTwo = new Cell(x + 1, y, c, 0);
                    Cell cellTwoFour = new Cell(x - 1, y, c, 0);
                    boolean onTheEdge = x==WIDTH_CELL-1;
                    canTurn = (!(cells.contains(cellTwoOne) ||
                            cells.contains(cellTwoTwo) ||
                            cells.contains(cellTwoFour)) &&
                            !onTheEdge);
                } else if (face == 2) {
                    Cell cellThreeOne = new Cell(x + 1, y + 1, c, 0);
                    Cell cellThreeTwo = new Cell(x, y + 1, c, 0);
                    Cell cellThreeFour = new Cell(x, y - 1, c, 0);
                    canTurn = !(cells.contains(cellThreeOne) ||
                            cells.contains(cellThreeTwo) ||
                            cells.contains(cellThreeFour));
                } else if (face == 3) {
                    Cell cellZeroOne = new Cell(x - 1, y + 1, c, 0);
                    Cell cellZeroTwo = new Cell(x - 1, y, c, 0);
                    Cell cellZeroFour = new Cell(x + 1, y, c, 0);
                    boolean onTheEdge = x==0;
                    canTurn = (!(cells.contains(cellZeroOne) ||
                            cells.contains(cellZeroTwo) ||
                            cells.contains(cellZeroFour)) &&
                            !onTheEdge);
                }
            }
        }
        return canTurn;
    }

    private boolean canTurnSTetrimino() {
        boolean canTurn = false;
        int face = currentTetrimino.getFace();
        for (Cell next: currentTetrimino.getCells()) {
            if (next.getIndex() == 3) {
                int x = next.getX();
                int y = next.getY();
                Color c = new Color(0);
                Cell cellZeroOne = new Cell(x - 1, y + 1, c, 0);
                Cell cellZeroTwo = new Cell(x, y + 1, c, 0);
                Cell cellOneOne = new Cell(x, y - 1, c, 0);
                Cell cellOneFour = new Cell(x + 1, y + 1, c, 0);
                boolean onTheEdge = (face == 1 || face == 3) && x == 1;
                canTurn = (!(cells.contains(cellZeroOne) ||
                        cells.contains(cellZeroTwo) ||
                        cells.contains(cellOneOne) ||
                        cells.contains(cellOneFour)) &&
                        !onTheEdge);
            }
        }
        return canTurn;
    }

    private boolean canTurnTTetrimino() {
        boolean canTurn = false;
        int face = currentTetrimino.getFace();
        for (Cell next: currentTetrimino.getCells()) {
            if (next.getIndex() == 3) {
                int x = next.getX();
                int y = next.getY();
                Color c = new Color(0);
                if (face == 0) {
                    Cell cellOneTwo = new Cell(x, y - 1, c, 0);
                    canTurn = !cells.contains(cellOneTwo);
                } else if (face == 1) {
                    Cell cellTwoTwo = new Cell(x + 1, y, c, 0);
                    boolean onTheEdge = x==WIDTH_CELL-1;
                    canTurn = (!cells.contains(cellTwoTwo) &&
                            !onTheEdge);
                } else if (face == 2) {
                    Cell cellThreeTwo = new Cell(x, y + 1, c, 0);
                    canTurn = !cells.contains(cellThreeTwo);
                } else if (face == 3) {
                    Cell cellZeroTwo = new Cell(x - 1, y, c, 0);
                    boolean onTheEdge = x==0;
                    canTurn = (!cells.contains(cellZeroTwo) &&
                            !onTheEdge);
                }
            }
        }
        return canTurn;
    }

    private boolean canTurnZTetrimino() {
        boolean canTurn = false;
        int face = currentTetrimino.getFace();
        for (Cell next: currentTetrimino.getCells()) {
            if (next.getIndex() == 2) {
                int x = next.getX();
                int y = next.getY();
                Color c = new Color(0);
                Cell cellZeroOne = new Cell(x - 1, y + 1, c, 0);
                Cell cellZeroTwo = new Cell(x, y + 1, c, 0);
                Cell cellOneOne = new Cell(x, y - 1, c, 0);
                Cell cellOneFour = new Cell(x + 1, y + 1, c, 0);
                boolean onTheEdge = (face == 1 || face == 3) && x == WIDTH_CELL-1;
                canTurn = (!(cells.contains(cellZeroOne) ||
                        cells.contains(cellZeroTwo) ||
                        cells.contains(cellOneOne) ||
                        cells.contains(cellOneFour)) &&
                        !onTheEdge);
            }
        }
        return canTurn;
    }

}