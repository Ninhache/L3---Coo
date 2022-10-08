package fr.test.java.competition;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import fr.main.java.Competitor;
import fr.main.java.competition.Competition;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public class CompetitionTest {
	List<Competitor> competitors;
	Competition mockCompetition;
	
	@BeforeAll
	void init() {
		competitors = new ArrayList<>();
		for(int i=0;i<3;i++) {
			competitors.add(new Competitor("Player"+i));
		}
		mockCompetition = new MockCompetition(competitors);
	}
	
	@Test(expected=CompetitionIllegalCompetitorsSize.class)
	void testLessThanTwoPlayers(){
		List<Competitor> competitors = new ArrayList<>();
		Competition mockCompetition = new MockCompetition(competitors);
	}
	
	@Test
	void testSetMatch() {
		RandomMatch randomMatch = new RandomMatch(); 
		mockCompetition.setMatch(randomMatch);
		assertSame(randomMatch, mockCompetition.getMatch());
	}	
}
