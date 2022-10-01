package fr.main.java.competition;

import java.util.List;
import java.util.Map;

import fr.main.java.Competitor;

public abstract class Competition {
	private final List<Competitor> competitors;

	public Competition(List<Competitor> competitors) {

	}

	public void play() {

	}

	protected void play(List<Competitor> competitors) {
		
	}

	protected void playMatch(List<Competitor> competitors) {

	}
	
	public Map<Competitor,Integer> ranking(){
		return null;
	}

}
