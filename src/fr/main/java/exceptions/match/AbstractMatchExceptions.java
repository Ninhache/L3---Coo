package fr.main.java.exceptions.match;

/**
 * Represent a match exception
 * @author neo.almeida.etu@univ-lille.fr
 *
 */
public abstract class AbstractMatchExceptions extends RuntimeException {

	protected AbstractMatchExceptions(String string) {
		super(string);
	}

	private static final long serialVersionUID = -6427187971322536839L;
	
}
