package com.kata.match;

public class TennisGame {
	private Player player1;
	private Player player2;
	private Player theGameWinner;
	private Player theSetWinner;
	private Player theSetLoser;

	public Player getTheSetLoser() {
		return theSetLoser;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.player1 = firstPlayer;
		this.player2 = secondPlayer;
	}

	public void play(Player player) {
		Player winner, loser;
		if (player.getId().equals("Player 1")) {
			winner = player1;
			loser = player2;
		} else {
			winner = player2;
			loser = player1;
		}
		if (!winner.getCurrentScore().equals("Win game") && !loser.getCurrentScore().equals("Win game")
				&& theGameWinner == null) {
			winner.addLastScore(winner.getCurrentScore());
			loser.addLastScore(loser.getCurrentScore());
			switch (winner.getCurrentScore()) {
			case "0":
				winner.setCurrentScore("15");
				break;
			case "15":
				winner.setCurrentScore("30");
				break;
			case "30":
				winner.setCurrentScore("40");
				break;
			case "40":
				if (loser.getCurrentScore().equals("40")) {
					winner.setCurrentScore("ADV");
				} else if (loser.getCurrentScore().equals("ADV")) {
					winner.setCurrentScore("DEUCE");
					loser.setCurrentScore("DEUCE");
				} else {
					winner.setCurrentScore("Win game");
					player1.getScores().add("0");
					player2.getScores().add("0");
					theSetWinner = winner;
					theSetLoser = loser;
				}
				break;
			case "DEUCE":
				winner.setCurrentScore("ADV");
				loser.setCurrentScore("40");
				break;
			case "ADV":
				winner.setCurrentScore("Win game");
				player1.getScores().add("0");
				player2.getScores().add("0");
				theSetWinner = winner;
				theSetLoser = loser;
				break;
			default:
				break;
			}
			if (winner.getCurrentScore().equals("Win game")) {
				theSetWinner.setFinalScore(theSetWinner.getFinalScore() + 1);
				if ((theSetWinner.getFinalScore() == 6 && theSetLoser.getFinalScore() <= 4)
						|| (theSetWinner.getFinalScore() > 6
								&& (theSetWinner.getFinalScore() - theSetLoser.getFinalScore() >= 2))) {
					theGameWinner = theSetWinner;
				}
			}

		} else {
			// initialize set score
			player1.addSetScore(player1.getFinalScore());
			player2.addSetScore(player2.getFinalScore());
			player1.setCurrentScore("0");
			player2.setCurrentScore("0");
			play(player);
		}
	}

	public Player getTheGameWinner() {
		return theGameWinner;
	}

	public Player getTheSetWinner() {
		return theSetWinner;
	}

}
