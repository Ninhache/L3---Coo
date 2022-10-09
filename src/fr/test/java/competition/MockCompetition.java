package fr.test.java.competition;

import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.competition.Competition;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;

public class MockCompetition extends Competition {
	
	private static int[] cpt = new int[4];

	public MockCompetition(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize {
		super(competitors);
	}
	
	@Override
	protected void play(List<Competitor> competitors) {
		super.playMatch(competitors);
	}
}
