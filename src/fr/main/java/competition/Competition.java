package fr.main.java.competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import fr.main.java.Competitor;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.MapUtil;

/**
 * Represents a competition.
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
public abstract class Competition {
	/**
	 * List of competitors taking part in the competition.
	 */
	private final List<Competitor> competitors;
	/**
	 * Type of match for the competition.
	 */
	private AbstractMatch match;
	/**
	 * Number of matches already played.
	 */
	private int nbMatch = 0; 
	
	/**
	 * Constructor with a list of competitors and Match.
	 * @param competitors the list of competitors participating in the competition
	 * @param match type of match for the competition
	 * @throws CompetitionIllegalCompetitorsSize
	 */
	public Competition(List<Competitor> competitors, AbstractMatch match) throws CompetitionIllegalCompetitorsSize {
		this.competitors = competitors;
		this.match=match;
		if(this.competitors.size()<2)
			throw new CompetitionIllegalCompetitorsSize();
	}
	
	/**
	 * Constructor with competitors.
	 * @param competitors the list of competitors participating in the competition
	 * @throws CompetitionIllegalCompetitorsSize
	 */
	public Competition(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize {
		this(competitors,null);
	}

	/**
	 * Play all the matches and show the score.
	 */
	public void play() {
		this.play(this.competitors);
		
		this.displayRanking();
	}

	/**
	 * Play matches between all the competitors given in parameters.
	 * @param competitors the list of competitors to use
	 */
	abstract protected void play(List<Competitor> competitors);

	/**
	 * Play a match between competitors given in parameters and display it
	 * @param competitors the list of competitors to use in a match
	 */
	protected void playMatch(List<Competitor> competitors) {
		this.nbMatch++;
		
		this.match.setCompetitors(competitors);
		this.match.playMatch();
		
		System.out.println(this.match);
	}
	
	/**
	 * Returns a Map sorted by descending number of wins of all the competitors. 
	 * @return map sorted by descending number of wins of all the competitors
	 */
	public Map<Competitor,Integer> ranking(){
		Map<Competitor,Integer> rank = new HashMap<Competitor,Integer>();
		for(Competitor c: competitors) {
			rank.put(c,c.getWins());			
		}
		return MapUtil.sortByDescendingValue(rank);
	}
	
	/**
	 * Display ranking.
	 */
	protected void displayRanking() {
		System.out.println();
		System.out.println("*** Ranking ***");
		Map<Competitor,Integer> rank = ranking();
		for(Map.Entry<Competitor, Integer> entry : rank.entrySet()) {
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
	 * @return number of matches already played
	 */
	public int getNbMatch() {
		return this.nbMatch;
	}
	
	public Competitor getWinner() {
		Map<Competitor, Integer> ranks = this.ranking();
		Optional<Integer> maxWins = ranks.values().stream().max(Integer::max);
		int max = maxWins.get();
		List<Competitor> exWinners = new ArrayList<>();
		ranks.forEach((key, value)-> {
			if (value == max) {
				exWinners.add(key);
			}
		});
		
		if (exWinners.size() > 1) {
			this.play(exWinners);
			return getWinner();
		}
		this.displayRanking();
		
		return exWinners.get(0);
	}
	
}
