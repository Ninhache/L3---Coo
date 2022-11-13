package fr.main.java.exceptions.competitions;

public class MasterNotEnoughCompetitors extends CompetitionIllegalCompetitorsSize {
	
	public MasterNotEnoughCompetitors() {
		super("Illegal size of competitors : Not enough competitors in each divisions");
	}

}
