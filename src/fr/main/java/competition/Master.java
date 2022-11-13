package fr.main.java.competition;

import java.util.ArrayList;
import java.util.List;

import fr.main.java.Competitor;
import fr.main.java.competition.strategy.IStrategyToPick;
import fr.main.java.competition.strategy.StrategyPickTwoFirstBest;
import fr.main.java.exceptions.competitions.CompetitionIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.MasterIllegalCompetitorsSize;
import fr.main.java.exceptions.competitions.MasterNotEnoughCompetitors;
import fr.main.java.exceptions.competitions.TournamentIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;
import fr.main.java.match.RandomMatch;

public class Master extends Competition {

	protected List<League> groups;
	protected IStrategyToPick strategy;
	protected int nbDivisions;
	
	public Master(List<Competitor> competitors, AbstractMatch match, IStrategyToPick strategy, int nbDivisions) throws CompetitionIllegalCompetitorsSize {
		super(competitors, match);
		
		if (competitors.size() % nbDivisions != 0) throw new MasterIllegalCompetitorsSize();
		
		this.strategy = strategy;
		this.nbDivisions = nbDivisions;
		
		this.groups = new ArrayList<>();
		
		int nbPerGroup = this.competitors.size() / nbDivisions;
		System.out.println("NB PER GROUYP" + nbPerGroup);
		System.out.println("this.competitors.size() " + this.competitors.size());
		System.out.println("NB DIV " + nbDivisions);
		if (nbPerGroup < 2) throw new MasterNotEnoughCompetitors();
		
		for (int i = 0 ; i < nbDivisions ; i ++) {
			
			groups.add(new League(this.competitors.subList(i, nbPerGroup + (nbPerGroup * i))));
		}
	}
	
	public Master(List<Competitor> competitors, IStrategyToPick strategy) throws CompetitionIllegalCompetitorsSize, MasterIllegalCompetitorsSize {
		this(competitors, new RandomMatch(), strategy, 2);
	}
	
	public Master(List<Competitor> competitors, int nbDivisions) throws CompetitionIllegalCompetitorsSize, MasterIllegalCompetitorsSize {
		this(competitors, new RandomMatch(), new StrategyPickTwoFirstBest(), nbDivisions);
	}

	public Master(List<Competitor> competitors, AbstractMatch match,int nbDivisions) throws CompetitionIllegalCompetitorsSize, MasterIllegalCompetitorsSize {
		this(competitors, match, new StrategyPickTwoFirstBest(), nbDivisions);
	}
	
	public Master(List<Competitor> competitors, AbstractMatch match) throws CompetitionIllegalCompetitorsSize, MasterIllegalCompetitorsSize {
		this(competitors, match, new StrategyPickTwoFirstBest(), 2);
	}
	
	@Override
	protected void play(List<Competitor> competitors) {
		
		List<Competitor> selectedForNext = new ArrayList<>();
		System.out.println("First phase");
		for (League league : this.groups) {
			league.play();
			selectedForNext.addAll(this.strategy.selectCompetitors(league));
		}
		
		System.out.println("Final phase");
		try {
			Tournament tournament = new Tournament(selectedForNext);
			
			tournament.play();
			this.scores = tournament.getScores();
		} catch (TournamentIllegalCompetitorsSize | CompetitionIllegalCompetitorsSize e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getNumberOfMatch(int nbCompetitors) {
		return ((this.nbDivisions * 2) + ((this.strategy.numberOfCompetitorReturned() * this.nbDivisions) - 1));
	}

	@Override
	public Competitor getWinner() {
		return this.ranking().entrySet().iterator().next().getKey();
	}


}
