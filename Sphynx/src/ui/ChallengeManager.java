package ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import model.Challenge;


/**
 * Created by JD on 2015-01-23.
 */
public class ChallengeManager {
	
	// Fields
	
	private static ChallengeManager challengeManager = new ChallengeManager();
	private Queue<Challenge> hardChallenges;
	private Queue<Challenge> easyChallenges;
	private SphynxGame game;
	
	// Constructor & Singleton getter
	
	private ChallengeManager() {
		loadChallenges();
	}
	
	/**
	 * Should be called after game starts to associate ChallengeManager with the game it is running in
	 */
	public void setGame(SphynxGame game) {
		this.game = game;
	}
	
	public static ChallengeManager getInstance( ) {
		return challengeManager;
	}
	
	// Methods
	
	   /**
	    * Loads all challenges for the game in random order into two separate queues for easy and hard
	    */
	private void loadChallenges() {
		easyChallenges = new ArrayBlockingQueue<Challenge>(20);
		hardChallenges = new ArrayBlockingQueue<Challenge>(10);
		
		for (int i = 0; i < 20; i++) {
			int challengeNumber = Math.ceil(game.getNumberChallenges() * Math.random());
			Challenge c = getChallenge(challengeNumber);
			easyChallenges.add(c);
		}
		
		for (int i = 0; i < 10; i++) {
			int challengeNumber = Math.ceil(game.getNumberChallenges() * Math.random());
			Challenge c = getChallenge(challengeNumber);
			hardChallenges.add(c);
		}
		
	}
	
	   /**
	    * Pops next challenge and passes it to the game to be displayed
	    */
	public Challenge newChallenge(boolean isHard) {
		if (isHard) {
			return hardChallenges.poll();
		}
		else {
			return easyChallenges.poll();
		}
	}
	
	private Challenge getChallenge(int challengeNumber) {
		switch(challengeNumber)
	}
	
}
