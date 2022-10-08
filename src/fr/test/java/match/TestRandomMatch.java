package fr.test.java.match;

import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.match.RandomMatch;

public class testRandomMatch extends testMatch {

	@Override
	protected void generateMatch(List<Competitor> competitors) {
		this.match = new RandomMatch(competitors);
	}
	
	@Override
	protected void generateMatch(Competitor c1, Competitor c2) {
		this.match = new RandomMatch(c1, c2);
	}

}
