package ui;


/**
 * Created by mohamedshaaban on 15-01-24.
 */
public class TimeManager {


    private static long INITIAL_TIME = 60000;
    private static long BONUS = 6000;
    private long endTime;
    private long startTime;
    private long acc;
    private boolean timerOn;

    public TimeManager() {

        timerOn = false;
    }

    public long getCurrentTime() {
        return (endTime - System.currentTimeMillis()) / 1000;
    }



    public void startTimer() {
        startTime = System.currentTimeMillis();
        endTime = startTime + INITIAL_TIME;
        timerOn = true;
    }


    public void pauseTimer() {

        if (timerOn) {
            acc = endTime - System.currentTimeMillis();
        }

        timerOn = false;


    }

    public void continueTimer() {
        if (!timerOn) {
            endTime = System.currentTimeMillis() + acc;
        }

        timerOn = true;
    }

    public void addBonusTime() {
        endTime = endTime + BONUS;
    }


    public boolean isTimeUp() {
        if (timerOn) {
            return endTime <= System.currentTimeMillis();
        }
        else return false;
    }

}
