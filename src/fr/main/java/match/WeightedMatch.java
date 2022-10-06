package fr.main.java.match;

import java.util.Arrays;
import java.util.List;

import fr.main.java.Competitor;

public class WeightedMatch extends AbstractMatch {

	public WeightedMatch(List<Competitor> competitors) {
		super(competitors);
	}
	
	public WeightedMatch(Competitor c1, Competitor c2) {
		this(Arrays.asList(c1, c2));
	}
	
	public void playMatch() {
		
	}

	@Override
	public double playerOneWinningChances() {
		// TODO Auto-generated method stub
		return 0;
	}
}
