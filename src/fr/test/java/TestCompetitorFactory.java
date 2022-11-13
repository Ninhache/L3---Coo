package fr.test.java;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.main.java.Competitor;
import fr.main.java.CompetitorFactory;

public class TestCompetitorFactory {
	@Test
	public void testNumberOfCompetitors() {
		List<Competitor> competitors1 = CompetitorFactory.createCompetitor(5);
		assertEquals(5,competitors1.size());
		
		List<Competitor> competitors2 = CompetitorFactory.createCompetitor(700);
		assertEquals(700,competitors2.size());
	}
}
