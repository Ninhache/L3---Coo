package fr.test.java.match;

import static org.junit.Assert.assertTrue;

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
	protected abstract double playerOneWinningChances();
	
	@BeforeEach
	protected void init() {
		List<Competitor> competitors = new ArrayList<>(
			Arrays.asList(new Competitor("Bob"), new Competitor("Alice")
		));
		
		this.generateMatch(competitors);
	}
	
	@Test
	void testPlayerOneWinningProbability() {
		
		Competitor c1 = new Competitor("Bob");
		Competitor c2 = new Competitor("Alice");
		
		int iter = 1000;
		
		int p1Wins = 0;
		for (int i = 0 ; i < iter ; i ++) {
			this.match.playMatch();
			
			this.generateMatch(c1, c2);
			
			if (c1.equals(this.match.getWinner())) {
				p1Wins++;
			}
		}
		
		float p1Percentage = p1Wins / iter;
		System.out.println(String.format("player 1 did %d wins => %f", p1Wins, p1Percentage));
		// assertTrue();
		// assertTrue()
		System.out.println(Math.inTreshold(p1Percentage, this.playerOneWinningChances(), this.precisionThreshold));
		assertTrue(Math.inTreshold(p1Percentage, this.playerOneWinningChances(), this.precisionThreshold));
	}
	
}
