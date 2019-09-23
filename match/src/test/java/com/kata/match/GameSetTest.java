package com.kata.match;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameSetTest {

	private TennisGame tennisGame;
	private Player player1;
	private Player player2;
	List<Player> playersPointsSet1;
	List<Player> playersPointsSet2;

	@Before
	public void init() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		tennisGame = new TennisGame(player1, player2);
		playersPointsSet1 = Arrays.asList(player1, player1, player2, player1, player2, player2, player1,
				player1);
		playersPointsSet2 =Arrays.asList(player1, player1, player2, player1, player2, player2, player2,
				player2);
	}

	@Test
	public void initialSetScoreShouldBe0() {
		assertThat(player1.getSetScores().get(0)).isEqualTo(0);
	}

	@Test
	public void setScoreShouldBe1If1GameIsWon() {
		playTennisSet(tennisGame, playersPointsSet1);
		assertThat(tennisGame.getTheSetWinner().getFinalScore()).isEqualTo(1);
	}

	@Test
	public void setScoreShouldBe2If2GameSetsAreWon() {
		for (int i = 0; i < 2; i++) {
			playTennisUsingFirstSetData();
		}
		assertThat(tennisGame.getTheSetWinner().getFinalScore()).isEqualTo(2);

	}

	@Test
	public void setScoreShouldBe3If3GameSetsAreWon() {
		for (int i = 0; i < 3; i++) {
			playTennisUsingFirstSetData();
		}
		assertThat(tennisGame.getTheSetWinner().getFinalScore()).isEqualTo(3);

	}

	// Using firstSetData, the winner should be player 1
	private void playTennisUsingFirstSetData() {
		for (Player player : playersPointsSet1)
			tennisGame.play(player);
	}

	// Using secondSetData, the winner should be player 2
	private void playTennisUsingSecondSetData() {
		for (Player player : playersPointsSet2) {
			tennisGame.play(player);
		}
	}

	@Test
	public void theWinnerShouldBeFirstPlayerIfScoreIS6To4() {
		for (int i = 0; i < 4; i++) {
			playTennisUsingSecondSetData();
		}
		for (int i = 0; i < 6; i++) {
			playTennisUsingFirstSetData();
		}
		assertThat(tennisGame.getTheGameWinner()).isEqualTo(tennisGame.getPlayer1());

	}

	@Test
	public void theWinnerShouldBeFirstPlayerIfScoreIS9To7() {
		for (int i = 0; i <= 6; i++) {
			playTennisSet(tennisGame, playersPointsSet1);
			playTennisSet(tennisGame, playersPointsSet2);
		}
		playTennisSet(tennisGame, playersPointsSet1);
		playTennisSet(tennisGame, playersPointsSet2);
		playTennisSet(tennisGame, playersPointsSet1);
		playTennisSet(tennisGame, playersPointsSet1);
		assertThat(tennisGame.getTheGameWinner()).isEqualTo(tennisGame.getPlayer1());
	}

	public void playTennisSet(TennisGame game, List<Player> playersPoints) {
		for (Player player : playersPoints) {
			game.play(player);
		}
	}

}
