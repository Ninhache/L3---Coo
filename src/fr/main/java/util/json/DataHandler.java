package fr.main.java.util.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * BOOKMAKERS DATA :
 * 	NAMES : Osef
 * 	REPLICAS :
 * 			- $1n$ => Joueur 1 . Name
 * 			- $1r$ => Joueur 1 . Rate
 * 
 * JOURNALISTS DATA :
 * 	NAMES : Osef
 * 	REPLICAS :
 * 			- $2n$ => Joueur 2 . Name
 * 			- $2s$ => Joueur 2 . Score
 * 
 * Rappel :
 * 	n : name
 *  r : rate
 *  s : score
 * */


public class DataHandler {
	
	private static DataHandler instance;
	
	private BookmakersData bookmakersData;
	private JournalistsData journalistsData;
	
	private DataHandler() {
		JSONParser parser = new JSONParser();
		Reader reader = null;
		try {
			reader = new FileReader("./src/fr/resources/data.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Object jsonObj = null;
		try {
			jsonObj = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		parseBookmakers(jsonObj);
		parseJournalists(jsonObj);
	}
	
	private void parseJournalists(Object jsonObj) {
		parseJournalists((JSONObject) jsonObj);
	}
	
	private void parseJournalists(JSONObject jsonObj) {
		JSONObject journalistsObj = (JSONObject) jsonObj.get("journalistsData");
		
		ArrayList<String> names = new ArrayList<>();
		JSONArray journNames = (JSONArray) journalistsObj.get("names");
		for (Object name: journNames) {
			names.add(name.toString());
		}
		
		ArrayList<String> replicas = new ArrayList<>();
		JSONArray journReplicas =  (JSONArray) journalistsObj.get("replicas");
		for(Object replic: journReplicas) {
			replicas.add(replic.toString());
		}
	
		this.journalistsData = new JournalistsData(names, replicas);  
	}
	
	private void parseBookmakers(Object jsonObj) {
		parseBookmakers((JSONObject) jsonObj);
	}

	private void parseBookmakers(JSONObject jsonObj) {
		JSONObject bookmakersObj = (JSONObject) jsonObj.get("bookmakersData");
		
		ArrayList<String> names = new ArrayList<>();
		JSONArray bookNames = (JSONArray) bookmakersObj.get("names");
		for (Object name: bookNames) {
			names.add(name.toString());
		}
		
		ArrayList<String> replicas = new ArrayList<>();
		JSONArray bookReplicas =  (JSONArray) bookmakersObj.get("replicas");
		for(Object replic: bookReplicas) {
			replicas.add(replic.toString());
		}
		
		this.bookmakersData = new BookmakersData(names, replicas);  
	}

	public static DataHandler getInstance() {
		if (instance == null) {
			instance = new DataHandler();
		}
		
		return instance;
	}
	
	public BookmakersData getBookmakersData() {
		return bookmakersData;
	}
	
	public JournalistsData getJournalistsData() {
		return journalistsData;
	}
	
}
