package fr.main.java.match;

import java.util.Arrays;
import java.util.List;

import fr.main.java.Competitor;

public class RiggedMatch extends AbstractMatch {
	
	private double playerOneChance;
	
	public RiggedMatch() {
		super();
	}
	
	public RiggedMatch(List<Competitor> competitors, double playerOneChance) {
		super(competitors);
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
