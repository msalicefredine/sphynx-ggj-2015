package ui;

public class Points  {

    private int timeLeft;
    private int c = 100;

    public Points(int timeLeft){
        this.timeLeft = timeLeft;
    }

    public int getScore(){
        return (timeLeft * c);
    }

}
