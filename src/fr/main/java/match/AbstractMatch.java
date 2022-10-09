package fr.main.java.match;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import fr.main.java.Competitor;
import fr.main.java.exceptions.match.AbstractMatchExceptions;
import fr.main.java.exceptions.match.MatchIllegalCompetitorsSize;
import fr.main.java.exceptions.match.MatchSamePlayerException;

/**
 * Represent a simple match
 * @author neo.almeida.etu@univ-lille.fr
 *
 */
public abstract class AbstractMatch {
	/**
	 * List of competitors taking part in the match.
	 */
	protected List<Competitor> competitors;
	
	/**
	 * Random variable to handle unpredictable
	 */
	protected Random random = new Random();
	
	/**
	 * The winner and the looser of the match
	 */
	protected Competitor winner, looser;
	
	/**
	 * Constructor with a list of competitors
	 * @param competitors the list of competitors taking part in the match, the size of the list must be 2
	 */
	protected AbstractMatch(List<Competitor> competitors){
		this.competitors = competitors;
	}
	
	protected AbstractMatch() {
		this(null);
	}
	
	/**
	 * Set the competitors
	 * 
	 * @param competitors
	 * @throws AbstractMatchExceptions
	 */
	public void setCompetitors(List<Competitor> competitors) throws AbstractMatchExceptions {
		this.competitors = competitors;
		this.winner = null;
		this.looser = null;
		
		if (this.competitors.size() != 2) {
			throw new MatchIllegalCompetitorsSize(this.competitors.size());
		}
		
		if (this.competitors.get(0).equals(this.competitors.get(1))) {
			throw new MatchSamePlayerException();
		}
	}
	
	public void setCompetitors(Competitor c1, Competitor c2) {
		this.setCompetitors(Arrays.asList(c1,c2));
	}
	
	public List<Competitor> getCompetitors() {
		return competitors;
	}
	
	/**
	 * Function can be useless if competitors are not equals to two
	 * 
	 * Return the probability that player 1 wins
	 * 
	 * @return double
	 */
	public abstract double playerOneWinningChances();
	
	/**
	 * Play the match and set the variables winner/looser depending the {@link #playerOneWinningChances()}
	 * 
	 */
	public void playMatch() {
		if (winner == null || looser == null) {
			float f = this.random.nextFloat();
			
			if (f < playerOneWinningChances()) {
				this.winner = Objects.requireNonNull(this.competitors.get(0));
				this.looser = Objects.requireNonNull(this.competitors.get(1));
			} else {
				this.winner = Objects.requireNonNull(this.competitors.get(1));
				this.looser = Objects.requireNonNull(this.competitors.get(0));
			}
		
			this.winner.addWin();
		}
	}
	
	/**
	 * Return the winner of the match, if he's not defined, the match is played
	 * @return Winner
	 */
	public Competitor getWinner() { 
		if (winner == null) {
			this.playMatch();
		}
		return winner;
	}
	
	/**
	 * Return the looser of the match, if he's not defined, the match is played
	 * @return Looser
	 */
	public Competitor getLooser() {
		if (looser == null) {
			this.playMatch();
		}
		return looser;
	}
	
	/**
	 * Return the first player
	 * @return player1
	 */
	public Competitor getPlayer1() {
		return Objects.requireNonNull(this.competitors.get(0));
	}
	
	/**
	 * Return the second player
	 * @return player2
	 */
	public Competitor getPlayer2() {
		return Objects.requireNonNull(this.competitors.get(1));
	}
	
	@Override
	public String toString() {
		return String.format("%s VS %s --> %s", this.getPlayer1(), this.getPlayer2(), this.getWinner());
	}
}
