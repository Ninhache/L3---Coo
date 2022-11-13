package fr.main.java.competition.strategy;

import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.competition.League;

/**
 * Interface for the type of strategy.
 */
public interface IStrategyToPick {
	/**
	 * Select winners of a League
	 * @param league League in wich competitors have played
	 * @return List of competitors who won the league
	 */
	public List<Competitor> selectCompetitors(League league);
	/**
	 * Verify if the list of competitors is usable for a tournament.
	 * @return True if the list of competitors is usable for a tournament. False if not. 
	 */
	public boolean isUsableForTournament();
	/**
	 * @return Number of competitors in the list. 
	 */
	public int numberOfCompetitorReturned();
	
	public void clear();
}
