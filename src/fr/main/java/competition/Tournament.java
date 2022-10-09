package fr.main.java.competition;

import java.util.ArrayList;
import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.Math;

public class Tournament extends Competition {
	
	public Tournament(List<Competitor> competitors,AbstractMatch match) throws TournamentIllegalCompetitorsSize, CompetitionIllegalCompetitorsSize {
		super(competitors,match);
		if(!Math.isPowerOfTwo(competitors.size()))
			throw new TournamentIllegalCompetitorsSize();
	}
	
	public Tournament(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		this(competitors,null);
	}

	@Override
	protected void play(List<Competitor> competitors) {
		// TODO Auto-generated method stub
		List<Competitor> winners = new ArrayList<>();
		for(int i=0; i<competitors.size();i=i+2) {
			List<Competitor> duel = new ArrayList<>();
			duel.add(competitors.get(i));
			duel.add(competitors.get(i+1));
			this.playMatch(duel);
			winners.add(this.getMatch().getWinner());
		}
		if(competitors.size()!=2) play(winners);
	}
}
