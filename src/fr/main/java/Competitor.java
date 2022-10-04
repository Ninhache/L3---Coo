package fr.main.java;

import java.util.UUID;

public class Competitor implements Comparable<Competitor> {

	private String name;
	private int wins;
	private final UUID uuid; 
	
	public Competitor(String name) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.wins = 0;
	}

	public void addWin() {
		
	}

	@Override
	public int compareTo(Competitor arg0) {
		return this.uuid.compareTo(arg0.getUuid());
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
}
