package fr.test.java.competition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.main.java.Competitor;
import fr.main.java.CompetitorFactory;
import fr.main.java.competition.Competition;
import fr.main.java.competition.Master;
import fr.main.java.competition.strategy.StrategyPickFirst;
import fr.main.java.competition.strategy.StrategyPickTwoFirstBest;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public class MasterTest extends CompetitionTest {

	@Override
	protected Competition initCompetition() throws CompetitionIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors = CompetitorFactory.createCompetitor(4);
		return new Master(competitors, match, new StrategyPickTwoFirstBest(), 2);
	}
	
	@Override
	public void testRightCountOfMatches() {
		this.competition.play();
		
		assertEquals(12, this.competition.getNumberOfMatch(this.competition.getSize()));
	}
	
	@Test
	public void testDefaultStrategy() {
		Master master = (Master) this.competition;
		
		assertEquals(StrategyPickTwoFirstBest.class, master.getStrategy().getClass());
	}
	
	@Test
	public void testSetStrategy() {
		Master master = (Master) this.competition;
		master.setStrategy(new StrategyPickTwoFirstBest());
		assertEquals(StrategyPickTwoFirstBest.class, master.getStrategy().getClass());
		
		master.setStrategy(new StrategyPickFirst());
		assertEquals(StrategyPickFirst.class, master.getStrategy().getClass());
		
		master.setStrategy(new StrategyPickTwoFirstBest());
		assertEquals(StrategyPickTwoFirstBest.class, master.getStrategy().getClass());
		assertNotEquals(StrategyPickFirst.class, master.getStrategy().getClass());
	}
	
}
