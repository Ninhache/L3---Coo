package fr.main.java.exceptions.competitions;

/**
 * Exception for the tournament.
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
public class TournamentIllegalCompetitorsSize extends Exception {
	public TournamentIllegalCompetitorsSize() {
		super("Illegal size of competitors : power of two excpected.");
	}
}
