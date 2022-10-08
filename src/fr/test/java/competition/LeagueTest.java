package fr.test.java.competition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.main.java.Competitor;
import fr.main.java.competition.League;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public class LeagueTest extends CompetitionTest {
	
	@Test
	public void testRightCountOfMatches() throws CompetitionIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors = new ArrayList<>();
		for(int i=0;i<3;i++) {
			competitors.add(new Competitor("Player"+i));
		}
		League l1 = new League(competitors, match);
		l1.play();
		
		assertEquals(6,l1.getNbMatch());
		
		competitors.add(new Competitor("Player4"));
		League l2 = new League(competitors, match);
		l2.play();
		
		assertEquals(12,l2.getNbMatch());
	}
}
