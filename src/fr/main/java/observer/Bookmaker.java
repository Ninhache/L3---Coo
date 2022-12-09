package fr.main.java.observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.main.java.Competitor;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.json.BookmakersData;
import fr.main.java.util.json.DataHandler;
import fr.main.java.util.Math;

public class Bookmaker implements IObserver {
	
	// Rate are stored as integer .. and these integer has to go inside the Math.nToRate to get the real rate
	private Map<Competitor, Integer> rateMap;
	private BookmakersData data;
	
	public Bookmaker() {
		rateMap = new HashMap<>();
		data = DataHandler.getInstance().getBookmakersData();
	}
	
	// Rate cannot be negative
	// Rate should be above 1
	public void initMap(List<Competitor> competitors) {
		for (Competitor competitor : competitors)
			rateMap.put(competitor, 0);
	}
	
	@Override
	public void update(AbstractMatch match) {
		Competitor winner = match.getWinner();
		Competitor looser = match.getLooser();
		
		int oldWinnerRate = rateMap.get(winner);
		int oldLooserRate = rateMap.get(looser);
		
		rateMap.compute(winner, (k,v) -> v + 5);
		rateMap.compute(looser, (k,v) -> v - 5);
		
		String replica = data.getRandomReplica();
		replica = replica.replaceAll("\\{1n\\}", winner.getName());
		replica = replica.replaceAll("\\{2n\\}", looser.getName());
		
		replica = replica.replaceAll("\\{1r\\-\\}", Math.nToRate(oldWinnerRate) + "");
		replica = replica.replaceAll("\\{2r\\-\\}", Math.nToRate(oldLooserRate) + "");
		
		replica = replica.replaceAll("\\{1r\\+\\}", Math.nToRate(rateMap.get(winner)) + "");
		replica = replica.replaceAll("\\{2r\\+\\}", Math.nToRate(rateMap.get(looser)) + "");
		
		System.out.println(String.format("%s : %s", data.getRandomName(), replica));
	}
	
}
