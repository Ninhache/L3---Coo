package fr.test.java.match;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.main.java.Competitor;
import fr.main.java.exceptions.match.MatchIllegalCompetitorsSize;
import fr.main.java.exceptions.match.MatchSamePlayerException;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.Math;

public abstract class TestMatch {

	protected AbstractMatch match;
	protected double precisionThreshold = 0.5;

	protected abstract void generateMatch(List<Competitor> competitors);
	protected abstract void generateMatch(Competitor c1, Competitor c2);

	@Test
	public void testPlayersAreStillTheSame() {
		Competitor c1 = new Competitor("Bob");
		Competitor c2 = new Competitor("Alice");

		this.generateMatch(c1,c2);

		this.match.playMatch();

		assertSame(c1, this.match.getPlayer1());
		assertNotSame(c1, this.match.getPlayer2());

		assertSame(c2, this.match.getPlayer2());
		assertNotSame(c2, this.match.getPlayer1());
	}

	@Test
	public void testWinningProbabilities() {
		Competitor c1 = new Competitor("Bob");
		Competitor c2 = new Competitor("Alice");

		this.generateMatch(Arrays.asList(c1, c2));

		int iter = 1000;

		int p1Wins = 0;
		for (int i = 0 ; i < iter ; i ++) {
			this.match.playMatch();

			this.generateMatch(c1, c2);

			if (c1.equals(this.match.getWinner())) {
				p1Wins++;
			}
		}

		double p1Percentage = (float)p1Wins / (float)iter;

		assertTrue(Math.inTreshold(p1Percentage, this.match.playerOneWinningChances(), this.precisionThreshold));
	}

	@Test
	public void testCantStartMatchMultipleTime() {
		Competitor c1 = new Competitor("Bob");
		Competitor c2 = new Competitor("Alice");

		this.generateMatch(c1, c2);

		this.match.playMatch();
		Competitor winner = this.match.getWinner();
		Competitor looser = this.match.getLooser();

		int iter = 1000;
		for (int i = 0 ; i < iter ; i ++) {
			assertEquals(winner, this.match.getWinner());
			assertEquals(looser, this.match.getLooser());

			assertNotEquals(winner, this.match.getLooser());
			assertNotEquals(looser, this.match.getWinner());
		}


	}

	@Test
	public void testIllegalSize() {
		Assertions.assertThrows(MatchIllegalCompetitorsSize.class, () -> {
			Competitor c1 = new Competitor("Bob");
			Competitor c2 = new Competitor("Alice");
			Competitor c3 = new Competitor("Thomas");

			this.generateMatch(Arrays.asList(c1, c2, c3));
		});	
	}

	@Test
	public void testIllegalCompetitors() {
		Assertions.assertThrows(MatchSamePlayerException.class, () -> {
			Competitor c1 = new Competitor("Bob");

			this.generateMatch(Arrays.asList(c1, c1));
		});
	}
}
