package ui;

import model.Challenge;
import model.ChallengeDummy;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

//import model.SpaceInvaders;
//import model.Pacman;



/**
 * Created by JD on 2015-01-23.
 */
public class ChallengeManager {

    // Fields

    private static ChallengeManager challengeManager;
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

    public static ChallengeManager getInstance() {
        if (challengeManager == null) {
            challengeManager = new ChallengeManager();
        }
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
            Double randN = Math.ceil(5 * Math.random());
            int challengeNumber = randN.intValue();
            Challenge c = getChallenge(challengeNumber, false);
            easyChallenges.add(c);
        }

        for (int i = 0; i < 10; i++) {
            Double randN = Math.ceil(5 * Math.random());
            int challengeNumber = randN.intValue();
            Challenge c = getChallenge(challengeNumber, true);
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

    private Challenge getChallenge(int challengeNumber, boolean isHard) {
        switch (challengeNumber) {
            case 0: return new ChallengeDummy();
            case 1: return new ChallengeDummy();
            case 2: return new ChallengeDummy();
            case 3: return new ChallengeDummy();
            case 4: return new ChallengeDummy();
        }
        return null;
    }

    // return an easy challenge to be played
    public Challenge getEasyChallenge(){
        //TODO
        return null;
    }

    // return a hard challenge to be played
    public Challenge getHardChallenge(){
        //TODO
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((easyChallenges == null) ? 0 : easyChallenges.hashCode());
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        result = prime * result
                + ((hardChallenges == null) ? 0 : hardChallenges.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChallengeManager other = (ChallengeManager) obj;
        if (easyChallenges == null) {
            if (other.easyChallenges != null)
                return false;
        } else if (!easyChallenges.equals(other.easyChallenges))
            return false;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (hardChallenges == null) {
            if (other.hardChallenges != null)
                return false;
        } else if (!hardChallenges.equals(other.hardChallenges))
            return false;
        return true;
    }

}
