package core;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import utils.E_Trophy;

public class Trophy<T> implements Serializable { 
	
	/*A generic class cannot implement interfaces. But the "Serializable" interface is an empty interface ( = marker interface) that does not contain any implementation methods. In the case of "Serializable", its use is made by adding the keyword implements only to the class we want to make "Serializable", and there is no need to implement any method.
	  Therefore, there is no problem to add implements "Serializable" to a generic class.
	*/

	// Unique identifier
	private static final long serialVersionUID = 1L; // To use files
    	
	//Characteristics
    private E_Trophy trophy;			// Type trophy
    private T owner;					// awarded to 
    private Date trophyWinningDate;		// Date of award
    
    private Player player;
    private Coach coach; 				
    private Team team;
    
    
    // Constructor
    public Trophy(E_Trophy trophy, T owner, Date trophyWinningDate) {
        this.trophy = trophy;
        this.owner = owner;
        this.trophyWinningDate = trophyWinningDate;
        
        this.player = null;
        this.coach = null;
        this.team = null;
    }
    
    // Setters & Getters
	public E_Trophy getTrophy() {
		return trophy;
	}

	public void setTrophy(E_Trophy trophy) {
		this.trophy = trophy;
	}

	public T getOwner() {
		return owner;
	}

	public void setOwner(T owner) {
		this.owner = owner;
	}

	public Date getTrophyWinningDate() {
		return trophyWinningDate;
	}

	public void setTrophyWinningDate(Date trophyWinningDate) {
		this.trophyWinningDate = trophyWinningDate;
	}
	
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	// Functions - basic
	@Override
	public String toString() {
		return "Trophy [trophy=" + trophy + ", owner=" + owner + ", trophyWinningDate=" + trophyWinningDate + ", coach="
				+ coach + ", team=" + team + ", player=" + player + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(coach, owner, player, team, trophy, trophyWinningDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trophy<?> other = (Trophy<?>) obj;
		return Objects.equals(coach, other.coach) && Objects.equals(owner, other.owner)
				&& Objects.equals(player, other.player) && Objects.equals(team, other.team) && trophy == other.trophy
				&& Objects.equals(trophyWinningDate, other.trophyWinningDate);
	}
	
	// Functions - additional
	public <T extends Comparable<T>> int compareTo(Trophy<T> o) {
	return this.trophyWinningDate.compareTo(o.trophyWinningDate); // sort by date
	  
	}
	
    public boolean addTrophyToPlayer(Player player) { // Giving a prize to a player
    if(player == null) return false;
    if(this.player == null && !player.getTrophies().contains(this) ){
    this.player = player;
    player.getTrophies().add(this);
    return true;
    }
    return false;
    }
    
    public boolean addTrophyToCoach(Coach coach) { // Giving a prize to a coach
    if(coach == null) return false;
    if(this.coach == null && coach.getTrophy() == null){
    this.coach = coach;
    coach.setTrophy(this);
    return true;
    }
    return false;
    }
    
    public boolean addTrophyToTeam(Team team) { // Giving a prize to the team
    if(team == null) return false;
    if(this.team == null && team.getTrophy() == null){
    this.team = team;
    team.setTrophy(this);
    return true;
    }
    return false;
    }
    
}




