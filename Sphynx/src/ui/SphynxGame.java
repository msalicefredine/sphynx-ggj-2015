package ui;
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
		gs = "start";
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
	}
	
	public void draw(Graphics g) {
		
	}
	
	public boolean notFinished() {
		return false;
	}

}
