package fr.main.java.exceptions;

public class TournamentIllegalCompetitorsSize extends Exception {
	public TournamentIllegalCompetitorsSize() {
		super("Illegal size of competitors : power of two excpected.");
	}
}
