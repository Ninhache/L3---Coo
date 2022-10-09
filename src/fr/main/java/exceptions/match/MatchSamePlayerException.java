package fr.main.java.exceptions.match;

import fr.main.java.Competitor;

/**
 * Exception about the competitors of a match, this exception is thrown  if they're the same
 * @author neo.almeida.etu@univ-lille.fr
 *
 */
public class MatchSamePlayerException extends AbstractMatchExceptions {

	private static final long serialVersionUID = -4555938451661373918L;
	
	public MatchSamePlayerException() {
		super("Boths competitors are the same !");
	}
	
}
