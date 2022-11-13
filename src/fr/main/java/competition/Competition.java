package fr.main.java.competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import fr.main.java.Competitor;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;
import fr.main.java.match.RandomMatch;
import fr.main.java.util.MapUtil;

/**
 * Represents a competition.
 * 
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
public abstract class Competition {
	/**
	 * List of competitors taking part in the competition.
	 */
	protected final List<Competitor> competitors;
	/**
	 * Type of match for the competition.
	 */
	private AbstractMatch match;

	protected Map<Competitor, Integer> scores;

	/**
	 * Constructor with a list of competitors and Match.
	 * 
	 * @param competitors the list of competitors participating in the competition
	 * @param match       type of match for the competition
	 * @throws CompetitionIllegalCompetitorsSize
	 */
	public Competition(List<Competitor> competitors, AbstractMatch match) throws CompetitionIllegalCompetitorsSize {
		if (competitors.size() < 2)
			throw new CompetitionIllegalCompetitorsSize();

		this.competitors = competitors;
		this.match = match;

		this.scores = new HashMap<>();

		for (Competitor competitor : competitors) {
			scores.put(competitor, 0);
		}

	}

	/**
	 * Constructor with competitors.
	 * 
	 * @param competitors the list of competitors participating in the competition
	 * @throws CompetitionIllegalCompetitorsSize
	 */
	public Competition(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize {
		this(competitors, new RandomMatch());
	}

	/**
	 * Play all the matches and show the score.
	 */
	public void play() {
		this.play(this.competitors);

		this.displayRanking();
	}
	
	/** 
	 * @param nbCompetitors
	 * @return number of matches played during the competition
	 */
	public abstract int getNumberOfMatch(int nbCompetitors);

	/**
	 * Play matches between all the competitors given in parameters.
	 * 
	 * @param competitors the list of competitors to use
	 */
	abstract protected void play(List<Competitor> competitors);

	/**
	 * Play a match between competitors given in parameters and display it
	 * 
	 * @param competitors the list of competitors to use in a match
	 */
	protected void playMatch(List<Competitor> competitors) {

		this.match.setCompetitors(competitors);
		this.match.playMatch();

		this.scores.compute(this.match.getWinner(), (k, v) -> ++v);

		System.out.println(this.match);
	}

	/**
	 * Returns a Map sorted by descending number of wins of all the competitors.
	 * 
	 * @return map sorted by descending number of wins of all the competitors
	 */
	public Map<Competitor, Integer> ranking() {
		return MapUtil.sortByDescendingValue(this.scores);
	}

	/**
	 * Display ranking.
	 */
	protected void displayRanking() {
		System.out.println();
		System.out.println("*** Ranking ***");
		Map<Competitor, Integer> rank = this.ranking();
		for (Map.Entry<Competitor, Integer> entry : rank.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

	/**
	 * 
	 * @param match match to set
	 */
	public void setMatch(AbstractMatch match) {
		this.match = match;
	}

	/**
	 * @return current Match
	 */
	public AbstractMatch getMatch() {
		return this.match;
	}

	/**
	 * @return winner of the competition
	 */
	public abstract Competitor getWinner();

	/**
	 * @return scores of each competitor
	 */
	public Map<Competitor, Integer> getScores() {
		return scores;
	}
	
	/**
	 * @return number of competitors
	 */
	public int getSize() {
		return this.competitors.size();
	}

}
