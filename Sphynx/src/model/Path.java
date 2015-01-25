package model;

/**
 * Created by mohamedshaaban on 15-01-24.
 */
public class Path {

    private static int PATH_LENGTH = 1000;
    private int currentPosition;

    public Path() {

        currentPosition = 0;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void moveBy(int x) {
        currentPosition = currentPosition + x;
    }

    public boolean atStart() {
        return currentPosition == 0;
    }

    public boolean reachedEnd() {
        return currentPosition >= PATH_LENGTH;
    }
}
