package core;

import java.util.Objects;

public class MatchResult {
	
	//Characteristics
	private Team homeTeam; 		// team A, participant in the game
	private Team awayTeam; 		// team B, participant in the game
	private String matchID; 	// team A, participant in the game
	private int totalTime; 		// duration of the game in minutes
	private boolean penaltyEnd; // indicates if the was determined by penalty kicks 
	private int homeTeamScore;  // total goals by team A
	private int awayTeamScore;  //total goals by team B
	
	private Match match;
	
	//constructor
	public MatchResult(Team homeTeam, Team awayTeam, String matchID, int totalTime, boolean penaltyEnd, int homeTeamScore,
			int awayTeamScore, Match match) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matchID = matchID;
		this.totalTime = totalTime;
		this.penaltyEnd = penaltyEnd;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.match = match;
	}

    // Setters & Getters
	public Team getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getMatchID() {
		return matchID;
	}

	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}

	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public boolean isPenaltyEnd() {
		return penaltyEnd;
	}
	public void setPenaltyEnd(boolean penaltyEnd) {
		this.penaltyEnd = penaltyEnd;
	}
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	// Functions - basic
	
	@Override
	public int hashCode() {
		return Objects.hash(awayTeam, awayTeamScore, homeTeam, homeTeamScore, match, matchID, penaltyEnd, totalTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchResult other = (MatchResult) obj;
		return Objects.equals(awayTeam, other.awayTeam) && awayTeamScore == other.awayTeamScore
				&& Objects.equals(homeTeam, other.homeTeam) && homeTeamScore == other.homeTeamScore
				&& Objects.equals(match, other.match) && Objects.equals(matchID, other.matchID)
				&& penaltyEnd == other.penaltyEnd && totalTime == other.totalTime;
	}
}
