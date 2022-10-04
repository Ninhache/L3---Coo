package fr.test.java.match;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import fr.main.java.Competitor;
import fr.main.java.match.Match;

import fr.main.java.util.Math;

public abstract class testMatch {
	
	protected Match match;
	// protected abstract
	/*
	 * 
	 * valeur théorique de victoire genre 50%
	 * 
	 * */
	protected double precisionThreshold = 0.5;
	
	protected abstract void generateMatch(List<Competitor> competitors);
	protected abstract void generateMatch(Competitor c1, Competitor c2);
	
	@BeforeEach
	protected void init() {
		List<Competitor> competitors = new ArrayList<>(
			Arrays.asList(new Competitor("Bob"), new Competitor("Alice")
		));
		
		this.generateMatch(competitors);
	}

	@Test
	void testPlayersAreStillTheSame() {
		Competitor c1 = new Competitor("Bob");
		Competitor c2 = new Competitor("Alice");
		
		this.generateMatch(c1,c2);
		
		this.match.playMatch();
		
		assertEquals(c1, this.match.getPlayer1());
		assertNotEquals(c1, this.match.getPlayer2());
		
		assertEquals(c2, this.match.getPlayer2());
		assertNotEquals(c2, this.match.getPlayer1());
	}
	
	@Test
	void testWinningProbabilities() {
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
	
}
