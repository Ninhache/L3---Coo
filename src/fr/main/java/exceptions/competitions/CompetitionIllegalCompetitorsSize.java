package fr.main.java.exceptions.competitions;

/**
 * Exception for the competition.
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
public class CompetitionIllegalCompetitorsSize extends Exception {
	public CompetitionIllegalCompetitorsSize() {
		super("Illegal size of competitors : minimum 2 competitors excpected.");
	}
}
