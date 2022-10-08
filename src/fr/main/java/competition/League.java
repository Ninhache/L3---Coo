package fr.main.java.competition;

import java.util.ArrayList;
import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;

public class League extends Competition {
	
	public League(List<Competitor> competitors, AbstractMatch match) throws CompetitionIllegalCompetitorsSize {
		super(competitors, match);
	}

	public League(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize {
		this(competitors,null);
	}
	
	@Override
	protected void play(List<Competitor> competitors) {
		int j;
		for(int i=0; i<competitors.size();i++) {
			for(j=i;j<competitors.size();j++) {
				Competitor c1 = competitors.get(i);
				Competitor c2 = competitors.get(j);
				if(!c1.equals(c2)) {
					List<Competitor> duel = new ArrayList<>();
					duel.add(c1);
					duel.add(c2);
					this.playMatch(duel);
					this.playMatch(duel);
				}
				
			}
		}
	}
}
