package core;

import java.util.Objects;
import java.util.TreeSet;

import utils.Country;

public class Team {

	//Characteristics
	private String tNumber; 	 // the team identification number 
	private String tName; 		 // team full name
	private int fansCount; 		 // this calculated field is a result of total fans of all player of this team 
	private Sponsor sponsor; 	 // sponsor that the team sponsored from of this team  
	private Country represents;  // country that this team represent, each team represent one country 
	private Coach coach; 		 // The coach of the team 
	
	private Trophy<?> trophy; 	 	 	// Type of <?> ,This feature allows the team to have a trophy of any kind, according to the generic model defined in the Trophy<T> class.
	private TreeSet<Player> Players; 	// The List of Unique & Ordered Players ,The tree is sorting
	private TreeSet<Match> matches; 	// The list of Unique & Ordered Coaches
	
	//constructor for primary key
	public Team(String tNumber) { // With this builder, we actually build the "HashMap"
		super();
		this.tNumber = tNumber;
	}
 
    // Constructor
	public Team(String tNumber, String tName, int fansCount, String represents) {
		super();
		this.tNumber = tNumber;
		this.tName = tName;
		this.fansCount = fansCount;
		setRepresents(represents);
		
		this.trophy = null;
		this.Players = new TreeSet<>();
		this.matches = new TreeSet<>();
	}

    // Setters & Getters
	public String gettNumber() {
		return tNumber;
	}

	public void settNumber(String tNumber) {
		this.tNumber = tNumber;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

	public Country getRepresents() {
		return represents;
	}

	public void setRepresents(String represents) {
		 this.represents = Country.getCounrtyByName(represents);
	}

	public void setRepresents(Country represents) {
		this.represents = represents;
	}

	  public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	public Trophy<?> getTrophy() {
		return trophy;
	}

	public void setTrophy(Trophy<?> trophy) {
		this.trophy = trophy;
	}

	public TreeSet<Player> getPlayers() {
		return Players;
	}

	public void setPlayers(TreeSet<Player> players) {
		Players = players;
	}

	public TreeSet<Match> getMatches() {
		return matches;
	}

	public void setMatches(TreeSet<Match> matches) {
		this.matches = matches;
	}
	
	// Functions - basic

	@Override
	public int hashCode() {
		return Objects.hash(matches, Players, coach, fansCount, represents, sponsor, tName, tNumber, trophy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(matches, other.matches) && Objects.equals(Players, other.Players)
				&& Objects.equals(coach, other.coach) && fansCount == other.fansCount && represents == other.represents
				&& Objects.equals(sponsor, other.sponsor) && Objects.equals(tName, other.tName)
				&& Objects.equals(tNumber, other.tNumber) && Objects.equals(trophy, other.trophy);
	}

	// Functions - additional
    public boolean addMatch(Match match) {
        if (match != null && !this.getMatches().contains(match)) {
        	for(Player player: Players) {
        		if(!match.getPlayers().contains(player)){
        			match.getPlayers().add(player);} }
            return matches.add(match);
        }
        return false;
    }
}
