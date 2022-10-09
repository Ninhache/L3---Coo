package fr.main.java.match;

import java.util.Arrays;
import java.util.List;

import fr.main.java.Competitor;

public class RandomMatch extends AbstractMatch {

	public RandomMatch() {
		super();
	}
	
	@Override
	public double playerOneWinningChances() {
		return 0.5;
	}
}
