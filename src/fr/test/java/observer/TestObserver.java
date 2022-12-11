package fr.test.java.observer;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.main.java.Competitor;
import fr.main.java.CompetitorFactory;
import fr.main.java.competition.Competition;
import fr.main.java.competition.Master;
import fr.main.java.competition.strategy.StrategyPickTwoFirstBest;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;
import fr.main.java.observer.IObserver;

public abstract class TestObserver {
	protected IObserver observer;
	
	protected Competition competition;
	
	@Test
	public abstract void testSetObserver();
	
	@BeforeEach
	public void init() throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		RandomMatch match = new RandomMatch();
		List<Competitor> competitors = CompetitorFactory.createCompetitor(4);
		competition = new Master(competitors, match, new StrategyPickTwoFirstBest(), 2);
	}
}
