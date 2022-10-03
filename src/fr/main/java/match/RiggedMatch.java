package fr.main.java.match;

import java.util.List;

import fr.main.java.Competitor;

public class RiggedMatch extends Match {
	
	private double playerOneChance;
	
	public RiggedMatch(List<Competitor> competitors, double playerOneChance) {
		super(competitors);
		this.playerOneChance = playerOneChance;
	}
	
	@Override
	public double playerOneWinningChances() {
		return this.playerOneChance;
	}
}
