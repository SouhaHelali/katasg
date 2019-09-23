package com.kata.match;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String id;
	private List<String> scores;
	private List<Integer> setScores;
	private int finalScore;
	private String currentScore = "0";

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public String getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(String currentScore) {
		this.currentScore = currentScore;
	}

	public void addLastScore(String lastScore) {
		this.scores.add(lastScore);
	}

	public Player(String id) {
		this.id = id;
		this.scores = new ArrayList<String>();
		this.setScores = new ArrayList<Integer>();
		finalScore = 0;
		setScores.add(0);
	}

	public List<Integer> getSetScores() {
		return setScores;
	}

	public List<String> getScores() {
		return scores;
	}

	public void addScore(String score) {
		scores.add(score);
	}

	public void addSetScore(int currentSetScore) {
		setScores.add(currentSetScore);
	}

	public int getFinalScore() {
		return finalScore;
	}

	public String getLastScore() {
		return scores.get(scores.size() - 1);
	}

	public int getLastSetScore() {
		return setScores.get(setScores.size() - 1);
	}

	public String getId() {
		return id;
	}

}
