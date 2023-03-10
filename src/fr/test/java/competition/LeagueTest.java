package fr.test.java.competition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.main.java.Competitor;
import fr.main.java.CompetitorFactory;
import fr.main.java.competition.Competition;
import fr.main.java.competition.League;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public class LeagueTest extends CompetitionTest {
	
	@Override
	protected Competition initCompetition() throws CompetitionIllegalCompetitorsSize {
		
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors = CompetitorFactory.createCompetitor(3);
		
		return new League(competitors, match);
	}
	
	@Test
	public void testRightCountOfMatches() {
		this.competition.play();
		
		assertEquals(6,this.competition.getNumberOfMatch(this.competition.getSize()));
	}
}
