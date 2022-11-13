package fr.main.java.exceptions.competitions;
/**
 * Exception for the master.
 */
public class MasterNotEnoughCompetitors extends CompetitionIllegalCompetitorsSize {
	
	public MasterNotEnoughCompetitors() {
		super("Illegal size of competitors : Not enough competitors in each divisions");
	}

}
