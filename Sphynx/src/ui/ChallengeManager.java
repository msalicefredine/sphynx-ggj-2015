package ui;

import model.Challenge;
import model.pacman.ui.Game;
import model.space_invaders.ui.SpaceInvaders;
import model.tetris.ui.Tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JD on 2015-01-23.
 */
public class ChallengeManager {
    private List<Challenge> challenges;

    public ChallengeManager() {
        challenges = new ArrayList<Challenge>();
        challenges.add(new Tetris(true));
        challenges.add(new Tetris(false));
        challenges.add(new Game());
        challenges.add(new SpaceInvaders(true));
        challenges.add(new SpaceInvaders(false));
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }
}
