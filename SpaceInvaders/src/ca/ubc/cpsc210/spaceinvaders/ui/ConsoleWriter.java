package ca.ubc.cpsc210.spaceinvaders.ui;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Sultan on 14-11-10.
 */
public class ConsoleWriter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Invader hit");
    }


}
