package com.kata.match;

import java.util.Arrays;
import java.util.List;

import com.kata.match.Player;
import com.kata.match.TennisGame;

public class MainMatch {
	public static void main(String[] args) {

		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		TennisGame game = new TennisGame(player1, player2);
		// player 1 wins the set
		List<Player> playersPointsSet1 = Arrays.asList(player1, player1, player2, player1, player2, player2, player1,
				player1);
		// player 2 wins the set
		List<Player> playersPointsSet2 = Arrays.asList(player1, player1, player2, player1, player2, player2, player2,
				player2);

		playTennisSet(game, playersPointsSet1);
		playTennisSet(game, playersPointsSet2);
		playTennisSet(game, playersPointsSet1);
		playTennisSet(game, playersPointsSet1);
		playTennisSet(game, playersPointsSet2);
		playTennisSet(game, playersPointsSet2);
		playTennisSet(game, playersPointsSet2);
		playTennisSet(game, playersPointsSet1);
		playTennisSet(game, playersPointsSet1);
		playTennisSet(game, playersPointsSet2);
		playTennisSet(game, playersPointsSet1);
		playTennisSet(game, playersPointsSet1);

		if (game.getTheGameWinner() != null)
			System.out.println("The winner is " + game.getTheGameWinner().getId());
		else
			System.out.println("No winner ! please play again");

	}

	public static void playTennisSet(TennisGame game, List<Player> playersPoints) {
		for (Player player : playersPoints) {
			game.play(player);
		}
	}

}
