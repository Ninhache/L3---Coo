package fr.main.java.competition.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.main.java.Competitor;
import fr.main.java.competition.League;
import fr.main.java.util.MapUtil;
import fr.main.java.util.Math;

public class StrategyPickTwoFirstBest implements IStrategyToPick {
	
	private List<Competitor> selectedCompetitors;

	public StrategyPickTwoFirstBest() {
		this.selectedCompetitors = new ArrayList<>();
	}

	@Override
	public List<Competitor> selectCompetitors(League league) {		
		return MapUtil.sortByDescendingValue(league.getScores())
			.keySet()
			.stream()
			.limit(2)
			.collect(Collectors.toList());
	}

	@Override
	public boolean isUsableForTournament() {
		return !Math.isPowerOfTwo(selectedCompetitors.size()) && this.selectedCompetitors.size() <= 0;
	}
	
	public int numberOfCompetitorReturned() {
		return 2;
	}
}
