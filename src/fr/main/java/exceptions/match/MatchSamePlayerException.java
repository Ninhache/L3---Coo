package fr.main.java.exceptions;

import fr.main.java.Competitor;

public class MatchSamePlayerException extends AbstractMatchExceptions {

	private static final long serialVersionUID = -4555938451661373918L;
	
	public MatchSamePlayerException() {
		super("Boths competitors are the same !");
	}
	
}
