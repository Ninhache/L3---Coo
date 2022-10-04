package fr.main.java.exceptions;

public class MatchIllegalCompetitorsSize extends AbstractMatchExceptions {

	public MatchIllegalCompetitorsSize(int size) {
		super(String.format("Illegal size of competitors : %d\nExpected 2 ...", size));
	}
	
	public MatchIllegalCompetitorsSize() {
		this(0);
	}
	
}
