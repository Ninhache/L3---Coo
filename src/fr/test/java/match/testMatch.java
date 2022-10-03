package fr.test.java.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import fr.main.java.Competitor;
import fr.main.java.match.Match;

public abstract class testMatch {
	
	protected Match match;
	
	protected abstract void generateMatch(List<Competitor> competitors);
	
	@BeforeEach
	protected void init() {
		List<Competitor> competitors = new ArrayList<>(Arrays.asList(new Competitor("Bob"), new Competitor("Alice")));
		
		generateMatch(competitors);
		
	}
	
}
