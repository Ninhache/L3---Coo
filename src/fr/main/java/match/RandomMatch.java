package fr.main.java.match;

import java.util.List;

import fr.main.java.Competitor;

public class RandomMatch extends Match {

	public RandomMatch(List<Competitor> competitors) {
		super(competitors);
	}
	
	public RandomMatch(Competitor c1, Competitor c2) {
		super(c1, c2);
	}
	
	@Override
	public double playerOneWinningChances() {
		// TODO Auto-generated method stub
		return 0;
	}
}
