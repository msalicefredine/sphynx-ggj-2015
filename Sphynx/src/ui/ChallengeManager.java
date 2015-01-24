package ui;

/**
 * Created by JD on 2015-01-23.
 */
public class ChallengeManager {
	
	// Fields
	
	private static ChallengeManager challengeManager = new ChallengeManager();
	private Collection<Challenge> challenges;
	private GamePanel game;
	
	// Constructor & Singleton getter
	
	private ChallengeManager(GamePanel game) {
		challenges = loadChallenges();
	}
	
	/**
	 * Should be called after game starts to associate ChallengeManager with the game it is running in
	 */
	public void setGame(GamePanel game) {
		this.game = game;
	}
	
	public static ChallengeManager getInstance( ) {
		return challengeManager;
	}
	
	// Methods
	
	   /**
	    * Loads all challenges for the game in random order
	    */
	private Collection<Challenge> loadChallenges() {
		
		for (int i = 0; i < 30; i++) {
			Math.random()
		}
		
	}
	
	
    @return      
	@see         Image
	public void newChallenge() {
		
	}
	
	
	
}
