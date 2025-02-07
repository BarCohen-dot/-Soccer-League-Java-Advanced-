package core;

import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import utils.E_Levels;

public class Customer extends Person { // Customers or fans
	
	// Unique identifier
	private static final long serialVersionUID = 1L; // To use files
	
	//Characteristics
	private URL email;
	private E_Levels level;	   // describes the rank of the fan
	private Team favoriteTeam;
	
	private Player player;	 	// A favorite actor
	private Set<Match> matches; // The list of Unique matches
	
	//constructors for primary key
    public Customer(String pId) {
 		super(pId);
 	}
    
    // Constructor
	public Customer(String pId, String fullName, int age, String nation, URL email, E_Levels level, Team favoriteTeam) {
		super(pId, fullName, age, nation);
		this.email = email;
		this.level = level;
		this.favoriteTeam = favoriteTeam;
		
		this.player = null;
		this.matches = new HashSet<>();
	}

    // Setters & Getters
	public URL getEmail() {
		return email;
	}

	public void setEmail(URL email) {
		this.email = email;
	}

	public E_Levels getLevel() {
		return level;
	}

	public void setLevel(E_Levels level) {
		this.level = level;
	}

	public Team getFavoriteTeam() {
		return favoriteTeam;
	}

	public void setFavoriteTeam(Team favoriteTeam) {
		this.favoriteTeam = favoriteTeam;
	}
	
	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
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
		return "Customer [email=" + email + ", level=" + level + ", favoriteTeam=" + favoriteTeam + ", player=" + player
				+ ", matches=" + matches + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, favoriteTeam, level, matches, player);
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
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(favoriteTeam, other.favoriteTeam)
				&& level == other.level && Objects.equals(matches, other.matches)
				&& Objects.equals(player, other.player);
	}
	
	// Functions - additional
	public int compareTo(Customer o) {
	return this.level.compareTo(o.level); // sort by level
	  }
	
    public boolean addMatch(Match match) {
        if (match != null) {
            return matches.add(match);
        }
        return false;
    }
    
    public boolean addFavoritePlayer(Player player) { // Giving a prize to the team
    if(player == null) return false;
    if(this.player == null ){
    this.player = player;
    player.getCustomers_Fan().add(this);
    return true;
    }
    return false;
    }
	
	
}
