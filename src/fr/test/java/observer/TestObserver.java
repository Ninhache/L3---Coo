package fr.test.java.observer;

import org.junit.jupiter.api.BeforeEach;

import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.observer.IObserver;

public abstract class TestObserver {
	protected IObserver observer;
	
	protected abstract IObserver initObserver();
	
	@BeforeEach
	public void init() throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		this.observer = initObserver();
	}
	
	
}
