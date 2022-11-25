package fr.main.java;

import java.util.List;
import java.util.Scanner;

import fr.main.java.competition.Competition;
import fr.main.java.competition.League;
import fr.main.java.competition.Master;
import fr.main.java.competition.Tournament;
import fr.main.java.competition.strategy.StrategyPickTwoFirstBest;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.RandomMatch;
import fr.main.java.util.Math;

public class Main {

	public static void main(String[] args) {
		int typeCompet = -1;
		int nbCompetitors = -1;
		Competition competition = null;
		RandomMatch match = new RandomMatch();
		Scanner sc = new Scanner(System.in);
		
		try {
			typeCompet = getNbCompetition(sc);
			int nbPools = -1;
			if (typeCompet == 3) {
				nbPools = getNbPools(sc);
				nbCompetitors = getNbCompetitors(typeCompet,sc, (nbPools * 2));
			} else {
				nbCompetitors = getNbCompetitors(typeCompet,sc, 2);
			}
			
			
			List<Competitor> competitors = CompetitorFactory.createCompetitor(nbCompetitors);
			System.out.println("COMPET : " + competitors);
			
			if (typeCompet == 1) {
				competition = new League(competitors,match);
			} else if (typeCompet == 2) { 
				competition = new Tournament(competitors,match);
			} else {
				competition = new Master(competitors, match, new StrategyPickTwoFirstBest(), nbPools);
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
		System.out.println("3. Master");
		
		int competition=-1;
		
		while(competition!=1 && competition!=2 && competition!=3) {	
			try {
				System.out.println("You have to choose 1, 2 or 3 !");
				competition = sc.nextInt();
			}catch(Exception e) {
				sc.next();
				continue;
			}
		}
		return competition;
	}
	
	
	
	private static int getNbCompetitors(int competition, Scanner sc, int min) {
		System.out.println(String.format("Choose the number of competitors (min %d) :", min));
		
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
	
	private static int getNbPools(Scanner sc) {
		System.out.println("Choose the number of pools (min 1) :");
		
		int nbPools = -1;
		
		while(nbPools <= 0) {
			try {					
				System.out.println("The number must be a power of two!!");
				nbPools = sc.nextInt();
			} catch(Exception e) {
				sc.next();
				continue;
			}
		}
		
		return nbPools;
	}
}
