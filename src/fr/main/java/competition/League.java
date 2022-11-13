package fr.main.java.competition;

import java.util.ArrayList;
import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;

/**
 * Represents a league.
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
public class League extends Competition {
	/**
	 * Constructor with competitors and match.
	 * @param competitors the list of competitors participating in the competition
	 * @param match type of match for the competition
	 * @throws CompetitionIllegalCompetitorsSize
	 */
	public League(List<Competitor> competitors, AbstractMatch match) throws CompetitionIllegalCompetitorsSize {
		super(competitors, match);
	}

	/**
	 * Constructor with competitors.
	 * @param competitors the list of competitors participating in the competition
	 * @throws CompetitionIllegalCompetitorsSize
	 */
	public League(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize {
		this(competitors,null);
	}
	
	
	
	/**
	 * Play matches between all the competitors given in parameters.
	 * @param competitors the list of competitors to use
	 */
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

	/** 
	 * @param nbCompetitors
	 * @return number of matches played during the competition
	 */
	@Override
	public int getNumberOfMatch(int nbCompetitors) {
		return nbCompetitors * 2;
	}

	/**
	 * @return winner of the competition
	 */
	@Override
	public Competitor getWinner() {
		return this.ranking().keySet().iterator().next();
	}
	
}
