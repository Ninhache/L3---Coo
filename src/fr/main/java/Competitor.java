package fr.main.java;

import java.util.Objects;
import java.util.UUID;

/**
 * 
 * @author neo.almeida.etu@univ-lille.fr
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
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
		this.setWins(this.getWins() + 1);
	}

	@Override
	public int compareTo(Competitor other) {
		return this.wins - other.getWins();
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

	@Override
	public int hashCode() {
		return Objects.hash(name, uuid, wins);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competitor other = (Competitor) obj;
		return Objects.equals(name, other.name) && Objects.equals(uuid, other.uuid) && wins == other.wins;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}