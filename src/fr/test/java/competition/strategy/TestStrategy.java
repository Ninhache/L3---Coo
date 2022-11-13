package fr.test.java.competition.strategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.main.java.Competitor;
import fr.main.java.CompetitorFactory;
import fr.main.java.competition.League;
import fr.main.java.competition.strategy.IStrategyToPick;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;

public abstract class TestStrategy {
	
	protected IStrategyToPick strategy;
	protected abstract IStrategyToPick initStrategy();
	
	@BeforeEach
	public void init() throws CompetitionIllegalCompetitorsSize{
		this.strategy = this.initStrategy();
	}
	
	@Test
	public abstract void testIsUsableForTournament() throws CompetitionIllegalCompetitorsSize;
	
	@Test
	public abstract void testIsNotUsableForTournament() throws CompetitionIllegalCompetitorsSize;

	
	@Test
	public void testNumberOfCompetitorIsPositiv() {
		assertTrue(this.strategy.numberOfCompetitorReturned() > 0);
	}
	
}
