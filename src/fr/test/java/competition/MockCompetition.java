package fr.test.java.competition;

import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.competition.Competition;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;

public class MockCompetition extends Competition {

	public MockCompetition(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize {
		super(competitors);
	}
	
	@Override
	protected void play(List<Competitor> competitors) {
		this.playMatch(competitors);
	}

	@Override
	public int getNumberOfMatch(int nbCompetitors) {
		return this.getNumberOfMatch(nbCompetitors);
	}

	@Override
	public Competitor getWinner() {
		return this.getWinner();
	}
}
