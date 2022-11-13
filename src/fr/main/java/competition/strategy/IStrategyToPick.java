package fr.main.java.competition.strategy;

import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.competition.League;

public interface IStrategyToPick {
	public List<Competitor> selectCompetitors(League league);
	public boolean isUsableForTournament();
	public int numberOfCompetitorReturned();
}
