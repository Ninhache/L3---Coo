package fr.test.java.competition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.main.java.Competitor;
import fr.main.java.competition.League;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;

public class LeagueTest extends CompetitionTest {
	
	@Test
	public void testRightCountOfMatches() throws CompetitionIllegalCompetitorsSize {
		List<Competitor> competitors = new ArrayList<>();
		for(int i=0;i<3;i++) {
			competitors.add(new Competitor("Player"+i));
		}
		League l1 = new League(competitors);
		l1.play();
		
		assertEquals(9,l1.getNbMatch());
		
		competitors.add(new Competitor("Player4"));
		League l2 = new League(competitors);
		l2.play();
		
		assertEquals(12,l1.getNbMatch());
		
	}
}
