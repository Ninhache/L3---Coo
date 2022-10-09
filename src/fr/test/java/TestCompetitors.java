package fr.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import fr.main.java.Competitor;

public class TestCompetitors {

	private Competitor competitor;
	
	@Test
	public void testAddWin() {
		this.competitor = new Competitor("Bob");
		
		assertEquals(0, this.competitor.getWins());
		this.competitor.addWin();
		assertEquals(1, this.competitor.getWins());
	}
	
	@Test
	public void testEqualsCompetitor() {
		this.competitor = new Competitor("Bob");
		
		assertEquals(this.competitor, this.competitor);
		assertNotEquals(this.competitor, new Competitor("Bob"));
		assertNotEquals(this.competitor, new Competitor("Alice"));
	}
	
}
