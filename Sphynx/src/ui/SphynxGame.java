package ui;
import java.awt.*;
/**
 * Created by JD on 2015-01-23.
 */
public class SphynxGame {

<<<<<<< HEAD

	// draws all pieces of the game that are not UI (read: challenges)
	public void draw(Graphics g) {
		// TODO

    }



=======
	private GameState gs;
	private UIManager uimanager;
	private ChallengeManager challengemanager;
	private PointManager pointmanager;
	private TimeManager timemanager;
	
	public SphynxGame() {
		gs = "start";
		uimanager = new UIManager();
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
	
>>>>>>> 380ad5156a66fba8a5a08eab918a0622ded3ddd6
}
