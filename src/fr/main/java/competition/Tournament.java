package fr.main.java.competition;

import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.Math;

public class Tournament extends Competition {
	
	public Tournament(List<Competitor> competitors,AbstractMatch match) throws TournamentIllegalCompetitorsSize, CompetitionIllegalCompetitorsSize {
		super(competitors);
		if(!Math.isPowerOfTwo(competitors.size()))
			new TournamentIllegalCompetitorsSize();
	}
	
	public Tournament(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		this(competitors,null);
	}

	@Override
	protected void play(List<Competitor> competitors) {
		// TODO Auto-generated method stub
		
	}
}
