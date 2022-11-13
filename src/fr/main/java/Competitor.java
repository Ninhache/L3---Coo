package fr.main.java;

import java.util.Objects;
import java.util.UUID;

/**
 * 
 * @author neo.almeida.etu@univ-lille.fr
 * @author ambre.boussert.etu@univ-lille.fr
 *
 */
public class Competitor {

	private String name;
	private final UUID uuid; 
	
	public Competitor(String name) {
		this.uuid = UUID.randomUUID();
		this.name = name;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, uuid);
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
		return Objects.equals(name, other.name) && Objects.equals(uuid, other.uuid);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}