package fr.main.java.exceptions;

/**
 * Exception for the tournament.
 * @author ambre
 *
 */
public class TournamentIllegalCompetitorsSize extends Exception {
	public TournamentIllegalCompetitorsSize() {
		super("Illegal size of competitors : power of two excpected.");
	}
}
