package fr.main.java.exceptions.match;

/**
 * Exception about the illegal size of a list of competitor in a match
 * @author neo.almeida.etu@univ-lille.fr
 *
 */
public class MatchIllegalCompetitorsSize extends AbstractMatchExceptions {

	public MatchIllegalCompetitorsSize(int size) {
		super(String.format("Illegal size of competitors : %d\nExpected 2 ...", size));
	}
	
	public MatchIllegalCompetitorsSize() {
		this(0);
	}
	
}
