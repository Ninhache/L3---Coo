package fr.main.java.competition.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.main.java.Competitor;
import fr.main.java.competition.League;
import fr.main.java.util.MapUtil;
import fr.main.java.util.Math;
/**
 * Strategy to pick the first person of each league.
 */
public class StrategyPickFirst implements IStrategyToPick {
	
	private List<Competitor> selectedCompetitors;

	public StrategyPickFirst() {
		this.selectedCompetitors = new ArrayList<>();
	}

	/**
	 * Select winners of a League
	 * @param league League in wich competitors have played
	 * @return List of competitors who won the league
	 */
	@Override
	public List<Competitor> selectCompetitors(League league) {		
		return MapUtil.sortByDescendingValue(league.getScores())
			.keySet()
			.stream()
			.limit(1)
			.collect(Collectors.toList());
	}

	/**
	 * Verify if the list of competitors is usable for a tournament.
	 * @return True if the list of competitors is usable for a tournament. False if not. 
	 */
	@Override
	public boolean isUsableForTournament() {
		return !Math.isPowerOfTwo(selectedCompetitors.size()) && this.selectedCompetitors.size() <= 0;
	}
	
	/**
	 * @return Number of competitors in the list. 
	 */
	public int numberOfCompetitorReturned() {
		return 1;
	}
}
