package fr.main.java.competition;

import java.util.List;
import java.util.Map;

import fr.main.java.Competitor;
import fr.main.java.exceptions.CompetitionIllegalCompetitorsSize;
import fr.main.java.match.AbstractMatch;

public abstract class Competition {
	private final List<Competitor> competitors;
	private AbstractMatch match;
	private int nbMatch = 0; 
	
	public Competition(List<Competitor> competitors, AbstractMatch match) throws CompetitionIllegalCompetitorsSize {
		this.competitors = competitors;
		this.match=match;
		if(this.competitors.size()<2)
			throw new CompetitionIllegalCompetitorsSize();
	}
	public Competition(List<Competitor> competitors) throws CompetitionIllegalCompetitorsSize {
		this(competitors,null);
	}

	public void play() {
		this.play(this.competitors);
	}

	abstract protected void play(List<Competitor> competitors);

	protected void playMatch(List<Competitor> competitors) {
		this.nbMatch++;
		match.setCompetitors(competitors);
		match.playMatch();
		StringBuilder message = new StringBuilder();
		message.append(competitors.get(0));
		for(int i=1;i<competitors.size();i++){
			message.append(" vs ");
			message.append(competitors.get(i));
		}
		message.append(" --> ");
		message.append(match.getWinner());
		message.append(" wins!");
		System.out.println(message);
	}
	
	public Map<Competitor,Integer> ranking(){
		return null;
	}
	
	public void setMatch(AbstractMatch match) {
		this.match = match;
	}

	public AbstractMatch getMatch() {
		return this.match;
	}
	
	public int getNbMatch() {
		return this.nbMatch;
	}
}
