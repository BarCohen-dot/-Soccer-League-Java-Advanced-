package core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import utils.E_Levels;

public class Coach extends Person {
	
	private static final long serialVersionUID = 1L;
	
	//Characteristics
	private Team MainTeam;	 	// The current group he works for ("The Main Team")
	private E_Levels level;  	// level
	
	private Set<Team> teams; 	// The list of Unique teams
	private Trophy<?> trophy;	// The Trophy
	
	//constructor for primary key
	public Coach(String pid) {
		super(pid);
	}
	
    // Constructor
	public Coach(String pId, String fullName, int age, String nation, Team mainTeam, E_Levels level) {
		super(pId, fullName, age, nation);
		MainTeam = mainTeam;
		this.level = level;
		
		this.teams = new HashSet<>();
		this.trophy = null;
	}

    // Setters & Getters
	public Team getMainTeam() {
		return MainTeam;
	}

	public void setMainTeam(Team mainTeam) {
		MainTeam = mainTeam;
	}

	public E_Levels getLevel() {
		return level;
	}

	public void setLevel(E_Levels level) {
		this.level = level;
	}
	
	public Set<Team> getTeams() {
		return teams;
	}
	
	public Trophy<?> getTrophy() {
		return trophy;
	}

	public void setTrophy(Trophy<?> trophy) {
		this.trophy = trophy;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	// Functions - basic
	@Override
	public String toString() {
		return "Coach [MainTeam=" + MainTeam + ", level=" + level + ", teams=" + teams + ", trophy=" + trophy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(MainTeam, level, teams, trophy);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coach other = (Coach) obj;
		return Objects.equals(MainTeam, other.MainTeam) && level == other.level && Objects.equals(teams, other.teams)
				&& Objects.equals(trophy, other.trophy);
	}

	// Functions - additional
    public boolean addTeam(Team team) {
        if (team != null) {
            return teams.add(team);
        }
        return false;
    }
    
    public boolean transferTo(Team team) {
        if (team == null || team.equals(MainTeam)) {
            return false;
        }
        
        if (MainTeam != null) {
            MainTeam.setCoach(null); // Remove this coach from the current team
        }
        
        team.setCoach(this); // Assign this coach to the new team
        setMainTeam(team);   // Update the MainTeam property of this coach
        return true;
    }


}

