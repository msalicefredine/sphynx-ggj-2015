package ui;

//import model.SpaceInvaders;
//import model.Pacman;


import model.space_invaders.ui.SpaceInvaders;
import model.tetris.ui.Tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JD on 2015-01-23.
 */
public class ChallengeManager {
    private boolean isWin;
    private List<Integer> hardChallenges;
    private List<Integer> easyChallenges;

    public ChallengeManager() {
        loadChallenges();
    }

    public void loadChallenges() {
        hardChallenges = new ArrayList<Integer>();
        easyChallenges = new ArrayList<Integer>();
        for (int i = 1; i < 3; i++) {
            hardChallenges.add(i);
        }
        Collections.shuffle(hardChallenges);
        for (int i = 1; i < 4; i++) {
            easyChallenges.add(i);
        }
        Collections.shuffle(easyChallenges);
    }

    public boolean startChallenge(boolean isHard) {
        if (isHard == true) {
            startHardChallenge();
        } else {
            startEasyChallenge();
        }
        return false;
    }

    public void startHardChallenge() {
        if (hardChallenges.isEmpty()) {
            startEasyChallenge();
        } else {
            int i = hardChallenges.get(0);
            hardChallenges.remove(0);
            if (i == 1) {
                new Tetris(true, this);
            } else if (i == 2) {
                new SpaceInvaders(true, this);
            }
        }
    }

    public void startEasyChallenge() {
        if (easyChallenges.isEmpty()) {
            loadChallenges();
        } else {
            int i = easyChallenges.get(0);
            easyChallenges.remove(0);
            if (i == 1) {
                new Tetris(false, this);
            } else if (i == 2) {
                new SpaceInvaders(false, this);
            } else if (i == 3) {
                new model.pacman.ui.Game(this);
            }
        }
    }

    public void setWin(boolean won) {
        isWin = won;
    }
}
