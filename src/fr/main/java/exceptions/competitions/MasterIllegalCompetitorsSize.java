package fr.main.java.exceptions.competitions;
/**
 * Exception for the master.
 */
public class MasterIllegalCompetitorsSize extends CompetitionIllegalCompetitorsSize {
	
	public MasterIllegalCompetitorsSize() {
		super("Illegal size of competitors : Each divisions should be able to have the same amount of competitors.");
	}

}
