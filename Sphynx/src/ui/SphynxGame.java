package ui;

import model.Challenge;

import java.awt.*;


/**
 * Created by JD on 2015-01-23.
 */
public class SphynxGame {


	private GameState gs;
	private UIManager uimanager;
	private ChallengeManager challengemanager;
	private PointManager pointmanager;
	private TimeManager timemanager;
	
	public SphynxGame() {
		gs = new GameState();
		gs.setAtStart();
		uimanager = new UIManager(this, gs);
		challengemanager = ChallengeManager.getInstance();
		pointmanager = new PointManager();
		timemanager = new TimeManager();
		run();
	}
	
	public void run() {
		while (notFinished()) {
			
			
				
			}
			
			
			GameState last = gs;
			
		}
	
	public void draw(Graphics g) {
		
	}
	
	public boolean notFinished() {
		return false;
	}

    //called from EM when start button is pressed
    // OR after next challenge button is pressed.
    // change state to BEFORE_CHALLENGE, open up before challenge screen
    public void openBeforeChallenge(){
        //TODO
        // make a call to UImanager to open before challenge screen
    }

    //called from EM when easy button is pressed
    // start up an easy challenge
    public void startEasyChallenge(Challenge c){
        // TODO
    }

    //called from EM when hard button is pressed in before-challenge screen
    //start up a hard challenge
    public void startHardChallenge(Challenge c){
        //TODO
        //
    }

    // when challenged finished, make call to UI manager to bring up after-challenge screen
    //
    public void challengeEnd(){
        //TODO
        //todo somehow transition from AC-screen back to before challenge screen
    }

    // called from EM when replay button is pressed in end screen
    // go back to start screen
    public void replay(){

    }

}
