package com.kata.match;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	private Player player1;
	private Player player2;
	private TennisGame tennisGame;

	@Before
	public void init() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		tennisGame = new TennisGame(player1, player2);
	}

	@Test
	public void initialScoreShouldBe0() {
		assertThat(player1.getCurrentScore()).isEqualTo("0");
	}

	@Test
	public void firstPointScoreShouldBe15() {
		tennisGame.play(player1);
		assertThat(player1.getCurrentScore()).isEqualTo("15");
	}

	@Test
	public void secondPointScoreShouldBe30() {
		tennisGame.play(player1);
		tennisGame.play(player1);
		assertThat(player1.getCurrentScore()).isEqualTo("30");
	}

	@Test
	public void thirdPointScoreShouldBe40() {
		tennisGame.play(player1);
		tennisGame.play(player1);
		tennisGame.play(player1);
		assertThat(player1.getCurrentScore()).isEqualTo("40");
	}

	@Test
	public void fourthPointScoreShouldBeWinGame() {
		Arrays.asList(1, 2, 3, 4).stream().forEach(i -> tennisGame.play(player1));
		assertThat(player1.getCurrentScore()).isEqualTo("Win game");
	}

	@Test
	public void theWinnerShouldBePlayer1IfWinGameIsItsScore() {
		List<Player> playersPoints = Arrays.asList(player1, player1, player2, player1, player2, player2, player2,
				player1, player1, player1);
		for (Player player : playersPoints) {
			tennisGame.play(player);
		}
		assertThat(tennisGame.getTheSetWinner().getId()).isEqualTo("Player 1");
	}

	@Test
	public void scoreShouldBeADVWhenPreviousScoreIsFourtyToFourtyAndPlayerHasOnePointMoreThanHisOpponent() {
		List<Player> playersPoints = Arrays.asList(player1, player1, player1, player2, player2, player2, player1);
		for (Player player : playersPoints) {
			tennisGame.play(player);
		}
		assertThat(tennisGame.getPlayer1().getCurrentScore()).isEqualTo("ADV");
	}

	@Test
	public void scoreShouldBeDeuceWhenDeuceRuleIsActivatedAndTheScoresAreEqual() {
		List<Player> playersPoints = Arrays.asList(player1, player1, player1, player2, player2, player2, player1,
				player2);
		for (Player player : playersPoints) {
			tennisGame.play(player);
		}
		assertThat(tennisGame.getPlayer1().getCurrentScore()).isEqualTo("DEUCE");
	}

}
