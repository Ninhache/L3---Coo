package fr.test.java.competition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.main.java.Competitor;
import fr.main.java.competition.League;
import fr.main.java.competition.Tournament;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;
import fr.main.java.util.Math;

public class TournamentTest extends CompetitionTest {

	@Test(expected=TournamentIllegalCompetitorsSize.class)
	public void testIsNotPowerOfTwo() throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors = new ArrayList<>();
		for(int i=0;i<3;i++) {
			competitors.add(new Competitor("Player"+i));
		}
		Tournament tournament = new Tournament(competitors, match);
	}

	@Test
	public void testIsPowerOfTwo() throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors = new ArrayList<>();
		for(int i=0;i<8;i++) {
			competitors.add(new Competitor("Player"+i));
		}
		Tournament tournament = new Tournament(competitors, match);
		assertEquals(true,Math.isPowerOfTwo(competitors.size()));
	}

	@Test
	public void testRightCountOfMatches() throws CompetitionIllegalCompetitorsSize {
		try {
			RandomMatch match = new RandomMatch();
			List<Competitor> competitors1 = new ArrayList<>();
			for(int i=0;i<4;i++) {
				competitors1.add(new Competitor("Player"+i));
			}
			Tournament t1 = new Tournament(competitors1, match);
			t1.play();
			assertEquals(3,t1.getNbMatch());

			List<Competitor> competitors2 = new ArrayList<>();
			for(int i=0;i<8;i++) {
				competitors2.add(new Competitor("Player"+i));
			}
			Tournament t2 = new Tournament(competitors2, match);
			t2.play();
			assertEquals(7,t2.getNbMatch());
		}catch(TournamentIllegalCompetitorsSize e) {
			e.printStackTrace();
		}
	}
}
