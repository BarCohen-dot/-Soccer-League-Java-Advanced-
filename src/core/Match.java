package core;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import utils.Stadium;

public class Match implements Comparable<Match> {
	
	//Characteristics
	private String mId;			// game identification number , used as key 
	private Date mDate; 		// the date when the game took place
	private Stadium tookPlace;  // the place where the game took place
	private long totalTickets;  // total Tickets sold 
	private MatchResult result; // as the two teams participant in ONE match 

	private Team team;
	private Set<Customer> customers; // The list of Unique customers
	private Set<Player> players;	 // The list of Unique players
	
	//constructor for primary key
	public Match(String mId) {
		super();
		this.mId = mId;
	}
	
	//constructor
	public Match(String mId, Date mDate, String tookPlace, long totalTickets, MatchResult result) {
		super();
		this.mId = mId;
		setmDate(mDate);
		setTookPlace(tookPlace);
		this.totalTickets = totalTickets;
		this.result = result;
		
		this.team = null;
		this.customers = new HashSet<>();
		this.players = new HashSet<>();
	
	}
    // Setters & Getters
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	public Stadium getTookPlace() {
		return tookPlace;
	}
	public void setTookPlace(String tookPlace) {
		this.tookPlace = Stadium.getStadiumByName(tookPlace);
	}
	public long getTotalTickets() {
		return totalTickets;
	}
	public void setTotalTickets(long totalTickets) {
		this.totalTickets = totalTickets;
	}
	public MatchResult getResult() {
		return result;
	}
	public void setResult(MatchResult result) {
		this.result = result;
	}
	
	public void setTookPlace(Stadium tookPlace) {
		this.tookPlace = tookPlace;
	}
	
	public Set<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	// Functions - basic
	@Override
	public String toString() {
		return "Match [mId=" + mId + ", mDate=" + mDate + ", tookPlace=" + tookPlace + ", totalTickets=" + totalTickets
				+ ", result=" + result + ", team=" + team + ", customers=" + customers + ", players=" + players + "]";
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(mId); // Use unique identifier
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Match match = (Match) o;
	    return mId.equals(match.mId); // Ensure you are comparing unique identifiers
	}

	// Functions - additional
	@Override
	public int compareTo(Match o) {
		// TODO Auto-generated method stub
		return this.getmDate().compareTo(o.getmDate());
	}
	
    public boolean addCustomer(Customer customer) {
        if (customer != null) {
            return customers.add(customer);
        }
        return false;
    }
    
    public boolean addTeam(Team team) { // Giving a prize to the team
    if(team == null && this.team == null) return false;
    if(!team.getMatches().contains(this)){
        team.getMatches().add(this);
        this.team = team;
        return true;
    }
    return false;
    }
}
