package ui;

import java.util.ArrayList;


public class PointManager {
    private ArrayList<Points> points;

    public PointManager(){
        points = new ArrayList<Points>();
    }

    public void addPointsToList(Points p){
        points.add(p);
    }

    public boolean isNewRecord(Points p){
        for (int i = 0; i < points.size(); i++){
            if (points.get(i).getScore() >= p.getScore()){return false;}
        }
        return false;
    }
}