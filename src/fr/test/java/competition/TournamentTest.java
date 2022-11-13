package fr.test.java.competition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.main.java.Competitor;
import fr.main.java.CompetitorFactory;
import fr.main.java.competition.Competition;
import fr.main.java.competition.Tournament;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;
import fr.main.java.util.Math;

public class TournamentTest extends CompetitionTest {

	@Override
	protected Competition initCompetition() throws TournamentIllegalCompetitorsSize, CompetitionIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		
		List<Competitor> competitors = CompetitorFactory.createCompetitor(8);
		
		return new Tournament(competitors, match);
	}
	
	@Test
	public void testIsNotPowerOfTwo() {
		
		Assertions.assertThrows(TournamentIllegalCompetitorsSize.class, () -> {
			RandomMatch match = new RandomMatch();
			List<Competitor> competitors = CompetitorFactory.createCompetitor(3);
			Tournament tournament = new Tournament(competitors, match);
		});
		
	}

	@Test
	public void testIsPowerOfTwo() throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors = CompetitorFactory.createCompetitor(8);
		Tournament tournament = new Tournament(competitors, match);
		
		assertEquals(true,Math.isPowerOfTwo(competitors.size()));
	}

	@Test
	public void testRightCountOfMatches() {
		this.competition.play();
		
		assertEquals(7,this.competition.getNumberOfMatch(this.competition.getSize()));
	}


}
