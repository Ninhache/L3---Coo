package fr.main.java.match;

import java.util.Arrays;
import java.util.List;

import fr.main.java.Competitor;

public class RandomMatch extends Match {

	public RandomMatch(List<Competitor> competitors) {
		this.competitors = competitors;
	}
	
	public RandomMatch(Competitor c1, Competitor c2) {
		this(Arrays.asList(c1,c2));
	}
	
	@Override
	public double playerOneWinningChances() {
		return 0.5;
	}
}
