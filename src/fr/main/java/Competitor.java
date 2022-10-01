package fr.main.java;

public class Competitor implements Comparable {

	private String name;
	private int wins;
	
	public Competitor(String name) {
		this.name = name;
		this.wins = 0;
	}

	public void addWin() {
		
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
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
