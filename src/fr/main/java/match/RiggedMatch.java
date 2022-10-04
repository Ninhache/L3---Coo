package fr.main.java.match;

import java.util.Arrays;
import java.util.List;

import fr.main.java.Competitor;

public class RiggedMatch extends Match {
	
	private double playerOneChance;
	
	public RiggedMatch(List<Competitor> competitors, double playerOneChance) {
		this.competitors = competitors;
		this.playerOneChance = playerOneChance;
	}
	
	public RiggedMatch(Competitor c1, Competitor c2, double playerOneChance) {
		this(Arrays.asList(c1,c2), playerOneChance);
	}
	
	@Override
	public double playerOneWinningChances() {
		return this.playerOneChance;
	}
}
