package fr.main.java.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.main.java.Competitor;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.Math;

/**
 * Represents a tournament.
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
public class Tournament extends Competition {
	/**
	 * Constructor with competitors and match.
	 * @param competitors the list of competitors participating in the competition
	 * @param match type of match for the competition
	 * @throws TournamentIllegalCompetitorsSize
	 * @throws CompetitionIllegalCompetitorsSize
	 */
	public Tournament(List<Competitor> competitors, AbstractMatch match) throws TournamentIllegalCompetitorsSize, CompetitionIllegalCompetitorsSize {
		super(competitors,match);
		if(!Math.isPowerOfTwo(competitors.size()))
			throw new TournamentIllegalCompetitorsSize();
	}
	
	/**
	 * Constructor with competitors.
	 * @param competitors
	 * @throws CompetitionIllegalCompetitorsSize
	 * @throws TournamentIllegalCompetitorsSize
	 */
	public Tournament(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize, TournamentIllegalCompetitorsSize {
		this(competitors,null);
	}

	/**
	 * Play matches between all the competitors given in parameters.
	 * @param competitors the list of competitors to use
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		// TODO Auto-generated method stub
		List<Competitor> winners = new ArrayList<>();
		for(int i = 0; i < competitors.size(); i = i+2) {
			List<Competitor> duel = new ArrayList<>();
			duel.add(competitors.get(i));
			duel.add(competitors.get(i + 1));
			this.playMatch(duel);
			winners.add(this.getMatch().getWinner());
		}
		if(competitors.size()!=2) play(winners);
	}

	@Override
	public int getNumberOfMatch(int nbCompetitors) {
		return (nbCompetitors - 1);
	}

	@Override
	public Competitor getWinner() {
		return this.ranking().entrySet().iterator().next().getKey();
	}
}
