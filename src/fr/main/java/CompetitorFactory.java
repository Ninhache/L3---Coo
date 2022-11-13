package fr.main.java;

import java.util.ArrayList;
import java.util.List;

public class CompetitorFactory {
	
	public static List<Competitor> createCompetitor(int nbCompetitors){
		List<Competitor> competitors = new ArrayList<>();
		
		for (int i=0;i<nbCompetitors;i++) {
			competitors.add(new Competitor("Player"+i));
		}
		
		return competitors;	
	}
	
}
