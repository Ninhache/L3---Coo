package fr.test.java.competition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.main.java.Competitor;
import fr.main.java.competition.League;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public class LeagueTest extends CompetitionTest {
	
	@Test
	public void testRightCountOfMatches() throws CompetitionIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors1 = new ArrayList<>();
		for(int i=0;i<3;i++) {
			competitors1.add(new Competitor("Player"+i));
		}
		League l1 = new League(competitors1, match);
		l1.play();
		
		assertEquals(6,l1.getNbMatch());
		
		List<Competitor> competitors2 = new ArrayList<>();
		for(int i=0;i<4;i++) {
			competitors2.add(new Competitor("Player"+i));
		}
		League l2 = new League(competitors2, match);
		l2.play();
		
		assertEquals(12,l2.getNbMatch());
	}
}
