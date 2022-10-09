package fr.main.java.match;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import fr.main.java.Competitor;
import fr.main.java.exceptions.AbstractMatchExceptions;
import fr.main.java.exceptions.MatchIllegalCompetitorsSize;
import fr.main.java.exceptions.MatchSamePlayerException;

public abstract class AbstractMatch {
	
	protected List<Competitor> competitors;
	protected Random random = new Random();
	
	protected Competitor winner, looser;
	
	protected AbstractMatch(List<Competitor> competitors){
		this.competitors = competitors;
	}
	
	protected AbstractMatch() {
		this(null);
	}
	
	public void setCompetitors(List<Competitor> competitors) throws AbstractMatchExceptions {
		this.competitors=competitors;
		this.winner=null;
		this.looser=null;
		if (this.competitors.size() != 2) {
			throw new MatchIllegalCompetitorsSize(this.competitors.size());
		}
		
		if (this.competitors.get(0).equals(this.competitors.get(1))) {
			throw new MatchSamePlayerException();
		}
	}
	
	public List<Competitor> getCompetitors() {
		return competitors;
	}
	
	/**
	 * /!\ Function can be useless if competitors are not equals to two /!\
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
	
	public Competitor getWinner() {
		if (winner == null) {
			this.playMatch();
		}
		return winner;
	}
	
	public Competitor getLooser() {
		if (looser == null) {
			this.playMatch();
		}
		return looser;
	}
	
	public Competitor getPlayer1() {
		return this.competitors.get(0);
	}
	
	public Competitor getPlayer2() {
		return this.competitors.get(1);
	}
}
