package core;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import utils.E_Position;


public class Player extends Person implements Comparable<Player>, Serializable {
 
	// Unique identifier
	private static final long serialVersionUID = 1L; // To use files

	// Characteristics
    private int pNum;
    private E_Position position;
    private int fansCount;
    private Team currentTeam;
    
    private Set<Match> matches;			 // Unique Matches
    private Set<Customer> Customers_Fan; // Unique Fans
    private Set<Trophy<?>> Trophies;	 // Unique Trophies

	//constructor for primary key
    public Player(String pId) {
 		super(pId);
 	}
    
	//constructor
	public Player(String pId, String fullName, int age, String nation, int pNum, E_Position position, int fansCount,
		Team currentTeam) {
		super(pId, fullName, age, nation);
		this.pNum = pNum;
		this.position = position;
		this.fansCount = fansCount;
		this.currentTeam = currentTeam;	
		
		this.matches = new HashSet<>();
		this.Customers_Fan = new HashSet<>();
		this.Trophies = new HashSet<>();
	}

    // Setters & Getters
	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public E_Position getPosition() {
		return position;
	}

	public void setPosition(E_Position position) {
		this.position = position;
	}
	
	public Set<Customer> getCustomers_Fan() {
		return Customers_Fan;
	}

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public Set<Trophy<?>> getTrophies() {
		return Trophies;
	}

	public void setTrophies(Set<Trophy<?>> trophies) {
		Trophies = trophies;
	}

	public void setCustomers_Fan(Set<Customer> customers_Fan) {
		Customers_Fan = customers_Fan;
	}

	// Functions - basic
	
	@Override
	public int hashCode() {
	    return Objects.hash(super.hashCode(), pId); // Use unique identifier
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    if (!super.equals(o)) return false;
	    Player player = (Player) o;
	    return pId.equals(player.pId); // Ensure you are comparing unique identifiers
	}
    
	// Functions - additional
	
    /**
     * This method adds the player to the given team and removes the player from its current team
     * only if the given team doesn't equal to the Player's current team.
     *
     * @param team
     * @return true if the player was added successfully to team, false otherwise
     */
	
	public boolean transferTo(Team team) {
	    if (team == null || team.equals(currentTeam)) {
	        return false;
	    }
	    
	    // Assuming 'this' refers to the current player instance
	    if (currentTeam != null) {
	        currentTeam.getPlayers().remove(this); // Remove the player from the current team
	    }										   // 'this' refers to the current Player instance
	    
	    if (team.getPlayers().add(this)) {
	        currentTeam = team; // Update the current team to the new team
	        return true;
	    }
	    
	    return false;
	}

	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		 return this.getpId().compareTo(o.getpId());
	}
	
    public boolean addMatch(Match match) {
        if (match != null && !this.getMatches().contains(match)) {
        	if(!match.getPlayers().contains(this)){ // Just in case
            	match.getPlayers().add(this);
                return matches.add(match);
        	}
        }
        return false;
    }
}
