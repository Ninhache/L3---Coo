package fr.main.java.competition.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.main.java.Competitor;
import fr.main.java.competition.League;
import fr.main.java.util.MapUtil;
import fr.main.java.util.Math;
/**
 * Strategy to pick the two best first.
 */
public class StrategyPickTwoFirstBest implements IStrategyToPick {
	
	private List<Competitor> selectedCompetitors;

	public StrategyPickTwoFirstBest() {
		this.selectedCompetitors = new ArrayList<>();
	}

	/**
	 * Select winners of a League
	 * @param league League in wich competitors have played
	 * @return List of competitors who won the league
	 */
	@Override
	public List<Competitor> selectCompetitors(League league) {		
		
		List<Competitor> result = new MapUtil().sortByDescendingValue(league.getScores())
									.keySet()
									.stream()
									.limit(2)
									.collect(Collectors.toList());
		this.selectedCompetitors.addAll(result);
		return result;
	}

	/**
	 * Verify if the list of competitors is usable for a tournament.
	 * @return True if the list of competitors is usable for a tournament. False if not. 
	 */
	@Override
	public boolean isUsableForTournament() {
		return Math.isPowerOfTwo(selectedCompetitors.size());
	}
	
	/**
	 * @return Number of competitors in the list. 
	 */
	public int numberOfCompetitorReturned() {
		return 2;
	}

	@Override
	public void clear() {
		this.selectedCompetitors.clear();
	}
}
