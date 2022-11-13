package fr.test.java.competition;


import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.main.java.Competitor;
import fr.main.java.competition.Competition;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public abstract class CompetitionTest {
	
	protected Competition competition;
	
	protected abstract Competition initCompetition() throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize;
	
	@BeforeEach
	public void init() throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		this.competition = initCompetition();
	}
	
	@Test
	public void testLessThanTwoPlayers() {
		List<Competitor> competitors = new ArrayList<>();
		assertThrows(Exception.class, () -> new MockCompetition(competitors));
	}
	
	@Test
	public void testSetMatch() throws CompetitionIllegalCompetitorsSize {
		List<Competitor> competitors = new ArrayList<>();;
		for (int i = 0 ; i < 3 ; i++ ) {
			competitors.add(new Competitor("Player"+i));
		}
		competition = new MockCompetition(competitors);
		
		RandomMatch randomMatch = new RandomMatch();
		competition.setMatch(randomMatch);
		
		assertSame(randomMatch, competition.getMatch());
	}	
	
	@Test
	public abstract void testRightCountOfMatches() throws CompetitionIllegalCompetitorsSize;
	
	
}
