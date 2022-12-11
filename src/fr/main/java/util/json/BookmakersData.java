package fr.main.java.util.json;

import java.util.List;
import java.util.Random;

public class BookmakersData {
	
	private List<String> names, replicas;
	
	public BookmakersData(List<String> names, List<String> replicas) {
		this.names = names;
		this.replicas = replicas;
	}
	
	public String getRandomReplica() {
		return this.replicas.get(new Random().nextInt(this.replicas.size()));
	}
	
	public String getRandomName() {
		return this.names.get(new Random().nextInt(this.names.size()));
	}
}
