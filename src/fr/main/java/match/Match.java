package fr.main.java.match;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import fr.main.java.Competitor;

public abstract class Match {
	
	protected List<Competitor> competitors;
	protected Random random = new Random();
	
	protected Competitor winner, looser;
	
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
