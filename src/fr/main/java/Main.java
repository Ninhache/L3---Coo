package fr.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.main.java.competition.Competition;
import fr.main.java.competition.League;
import fr.main.java.competition.Tournament;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;
import fr.main.java.util.Math;

public class Main {

	public static void main(String[] args) {
		int typeCompet = -1;
		int nbCompetitors = -1;
		Competition competition;
		RandomMatch match = new RandomMatch();
		Scanner sc = new Scanner(System.in);
		
		try {
			typeCompet = getNbCompetition(sc);
			nbCompetitors = getNbCompetitors(typeCompet,sc);
			sc.close();
			
			List<Competitor> competitors = new ArrayList<>();
			for (int i = 0; i < nbCompetitors; i++) {
				competitors.add(new Competitor("Player"+i));
			}

			if (typeCompet == 1) {
				competition = new League(competitors,match);
			} else {
				competition = new Tournament(competitors,match);
			}
			
			competition.play();
		} catch (CompetitionIllegalCompetitorsSize e) {
			e.printStackTrace();
		} catch (TournamentIllegalCompetitorsSize e) {
			e.printStackTrace();
		}
	}
	
	private static int getNbCompetition(Scanner sc) {
		System.out.println("Choose the competition :");
		System.out.println("1. League");
		System.out.println("2. Tournament");

		int competition=-1;
		
		while(competition!=1 && competition!=2) {	
			try {
				System.out.println("You have to choose 1 or 2 !");
				competition = sc.nextInt();
			}catch(Exception e) {
				sc.next();
				continue;
			}
		}
		return competition;
	}
	
	private static int getNbCompetitors(int competition, Scanner sc) {
		System.out.println("Choose the number of competitors (min 2) :");
		
		int nbCompetitors = -1;
		
		if (competition == 2) {
			while(!Math.isPowerOfTwo(nbCompetitors) || nbCompetitors < 2) {
				try {					
					System.out.println("The number must be a power of two!!");
					nbCompetitors = sc.nextInt();
				} catch(Exception e) {
					sc.next();
					continue;
				}
			}
		} else {
			while(nbCompetitors < 2) {
				try {
					nbCompetitors = sc.nextInt();					
				} catch(Exception e) {
					sc.next();
					continue;
				}
			}
		}
		return nbCompetitors;
	}
}
