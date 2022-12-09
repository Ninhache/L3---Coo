package fr.main.java.observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.main.java.Competitor;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.json.BookmakersData;
import fr.main.java.util.json.DataHandler;

public class Bookmaker implements IObserver {

	private Map<Competitor, Float> rateMap;
	private BookmakersData data;
	
	public Bookmaker() {
		rateMap = new HashMap<>();
		data = DataHandler.getInstance().getBookmakersData();
	}
	
	// Rate cannot be negative
	// Rate should be above 1
	public void initMap(List<Competitor> competitors) {
		for (Competitor competitor : competitors)
			rateMap.put(competitor, 1f);
	}
	
	@Override
	public void update(AbstractMatch match) {
		Competitor winner = match.getWinner();
		Competitor looser = match.getLooser();
		
		String replica = data.getRandomReplica();
		replica = replica.replaceAll("\\{1n\\}", winner.getName());
		replica = replica.replaceAll("\\{2n\\}", looser.getName());
		
		replica = replica.replaceAll("\\{2n\\}", rateMap.get(winner).toString());
		replica = replica.replaceAll("\\{2n\\}", rateMap.get(looser).toString());
		
		System.out.println(String.format("%s : %s", data.getRandomName(), replica));
	}
	
}
