package fr.main.java.observer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.main.java.Competitor;
import fr.main.java.match.AbstractMatch;
import fr.main.java.util.json.DataHandler;
import fr.main.java.util.json.JournalistsData;

public class Journalist implements IObserver {

	private JournalistsData data;
	
	public Journalist() {
		data = DataHandler.getInstance().getJournalistsData();
	}
	
	@Override
	public void update(AbstractMatch match) {
		Competitor winner = match.getWinner();
		Competitor looser = match.getLooser();
		
		String replica = data.getRandomReplica();
		replica = replica.replaceAll("\\{1n\\}", winner.getName());
		replica = replica.replaceAll("\\{2n\\}", looser.getName());
		
		System.out.println(String.format("%s : %s", data.getRandomName(), replica));
	}
	
}
