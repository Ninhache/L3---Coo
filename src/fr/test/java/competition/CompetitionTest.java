package fr.test.java.competition;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import fr.main.java.Competitor;
import fr.main.java.competition.Competition;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public abstract class CompetitionTest {
	
	
	@Test(expected=CompetitionIllegalCompetitorsSize.class)
	public void testLessThanTwoPlayers() throws CompetitionIllegalCompetitorsSize{
		List<Competitor> compet = new ArrayList<>();
		Competition competition = new MockCompetition(compet);
	}
	
	@Test
	public void testSetMatch() throws CompetitionIllegalCompetitorsSize {
		List<Competitor> competitors = new ArrayList<>();;
		for(int i=0;i<3;i++) {
			competitors.add(new Competitor("Player"+i));
		}
		Competition mockCompetition = new MockCompetition(competitors);
		
		RandomMatch randomMatch = new RandomMatch();
		mockCompetition.setMatch(randomMatch);
		assertSame(randomMatch, mockCompetition.getMatch());
	}	
	
	@Test
	public abstract void testRightCountOfMatches() throws CompetitionIllegalCompetitorsSize;
}
