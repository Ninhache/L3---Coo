package fr.main.java.exceptions;

/**
 * Exception for the competition.
 * @author ambre
 *
 */
public class CompetitionIllegalCompetitorsSize extends Exception {
	public CompetitionIllegalCompetitorsSize() {
		super("Illegal size of competitors : minimum 2 competitors excpected.");
	}
}
