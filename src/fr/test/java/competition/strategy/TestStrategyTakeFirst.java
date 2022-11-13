package fr.test.java.competition.strategy;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.CompetitorFactory;
import fr.main.java.competition.League;
import fr.main.java.competition.strategy.IStrategyToPick;
import fr.main.java.competition.strategy.StrategyPickFirst;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public class TestStrategyTakeFirst extends TestStrategy {

	@Override
	protected IStrategyToPick initStrategy() {
		return new StrategyPickFirst();
	}

	@Override
	public void testIsUsableForTournament() throws CompetitionIllegalCompetitorsSize {
		List<League> groups = new ArrayList<>();
		int nbGroups = 4;
		
		for (int i = 0 ; i < nbGroups ; i++) {
			groups.add(new League(CompetitorFactory.createCompetitor(4), new RandomMatch()));
		}
		
		List<Competitor> selected = new ArrayList<>();
		for (League league : groups) {
			league.play();
			selected.addAll(strategy.selectCompetitors(league));
		}
		 
		assertTrue(this.strategy.isUsableForTournament());
	}

	@Override
	public void testIsNotUsableForTournament() throws CompetitionIllegalCompetitorsSize {
		List<League> groups = new ArrayList<>();
		int nbGroups = 4;
		
		for (int i = 0 ; i < nbGroups ; i++) {
			groups.add(new League(CompetitorFactory.createCompetitor(4), new RandomMatch()));
		}
		
		List<Competitor> selected = new ArrayList<>();
		for (League league : groups) {
			league.play();
			selected.addAll(strategy.selectCompetitors(league));
		}
		 
		assertTrue(this.strategy.isUsableForTournament());
	}

}
