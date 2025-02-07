package init;

import java.io.*;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import core.Found;
import core.Match;
import core.MatchResult;
import core.Person;
import core.Player;
import core.Sponsor;
import core.Team;
import core.Trophy;
import core.Coach;
import core.Customer;

import utils.Country;
import utils.E_Levels;
import utils.E_Position;
import utils.E_Trophy;
import utils.Role;
import utils.Stadium;

public class JEuroTournament {
	
	//Characteristics
	private static JEuroTournament instance;
	
	private HashMap<String, Player> players; 			// All the Players
	private HashMap<String, Coach> coaches; 			// All the Coaches
	private HashMap<String, Customer> customers; 		// All Customers
	private HashMap<String, Sponsor> sponsors; 			// All sponsors
	private HashMap<String, Team> teams; 				// All teams
	private HashMap<String, Match> matches; 			// All matches
	private HashMap<String, MatchResult> matchResults;  // All matches results
	private HashSet<Trophy<?>> trophies; 				// <?> Allows flexibility, All trophies 

    // Constructor
    public JEuroTournament() {
        super();
        teams = new HashMap<>();  		// done
        matches = new HashMap<>(); 		// done
        players = new HashMap<>(); 		// done
        coaches = new HashMap<>(); 		// done
		customers= new HashMap<>(); 	// done
		sponsors = new HashMap<>(); 	// done
		matchResults = new HashMap<>();	// done
		trophies = new HashSet<>();		// done
    }

    // Setters & Getters
    public static JEuroTournament getInstance() {
    	if (instance == null) 
			instance = new JEuroTournament();
 		return instance;
 	}

 	public HashMap<String, Player> getPlayers() {
 		return players;
 	}

 	public HashMap<String, Coach> getCoaches() {
 		return coaches;
 	}

 	public HashMap<String, Customer> getCustomers() {
 		return customers;
 	}

 	public HashMap<String, Sponsor> getsponsors() {
 		return sponsors;
 	}

 	public HashMap<String, Team> getTeams() {
 		return teams;
 	}

 	public HashMap<String, Match> getMatches() {
 		return matches;
 	}

 	public HashMap<String,MatchResult> getMatchResults() {
 		return matchResults;
 	}

 	public HashSet<Trophy<?>> getTrophies() {
 		return trophies;
 	}
	// ========================================================== Add functions for the system  ==================================================================================================================
    /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
 	public boolean addPlayer(String pId, String fullName, int age, String nation, int pNum,E_Position position, int fansCount,
			Team currentTeam) {
 		if(pId == null || fullName == null || age <=0 || nation == null || pNum <=0
 				|| position==null || fansCount <=0 ||  currentTeam ==null) return false;
 		Player player = new Player(pId);
 		if(players.containsKey(player.getpId())) {
 			return false;
 		}
 		Player toPlayer = new Player(pId,fullName,age,nation,pNum,position,fansCount,currentTeam);
 		players.put(pId, toPlayer);
 		return true;	      
    }
    /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
 	public boolean addCoach(String pId, String fullName, int age, String nation, Team currentTeam, E_Levels level) {
 		if(pId == null || fullName == null || age <=0 || nation == null
 				|| level==null ||  currentTeam ==null) return false;
 		Coach coach = new Coach(pId);
 		if(coaches.containsKey(coach.getpId())) {
 			return false;
 		}
 		Coach toCoach = new Coach(pId,fullName,age,nation,currentTeam,level);
 		coaches.put(pId, toCoach);
 		return true;      
    }
 	 /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add 
     */
 	public boolean addCustomer(String pId, String fullName, int age, String nation, URL email, E_Levels level, Team favoriteTeam) {
 		if(pId == null || fullName == null || age <=0 || nation == null
 				|| email==null|| level==null ||  favoriteTeam ==null) return false;
 		Customer customer = new Customer(pId);
 		if(customers.containsKey(customer.getpId())) {
 			return false;
 		}
 		Customer toCostumer = new Customer(pId,fullName,age,nation,email,level,favoriteTeam);
 		customers.put(pId, toCostumer);
 		return true;   
    }
	 /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
 	public boolean addSponsor(String pId, String fullName, int age, String nation, String nickName) {
 		if(pId == null || fullName == null || age <=0 || nation == null
 				|| nickName==null) return false;
 		Sponsor sponsor = new Sponsor(pId);
 		if(sponsors.containsKey(sponsor.getNickName())) {
 			return false;
 		}
 		Sponsor tosponsor = new Sponsor(pId,fullName,age,nation,nickName);
 		sponsors.put(pId, tosponsor);
 		return true;
    }
    /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
    public boolean addTeam(String tNumber, String tName, int fansCount,String represents) {
    	if(tNumber == null || tName == null || represents == null
 				|| fansCount <=0 ) return false;
 		Team team = new Team(tNumber);
 		if(teams.containsKey(team.gettNumber())) {
 			return false;
 		}
 		Team toTeam = new Team(tNumber,tName,fansCount,represents);
 		teams.put(tNumber, toTeam);
 		return true;
    } 
	/**
     * adds a match to the system IFF it does not exist
     * @param matchID
     * @param date
     * @param stadium
     * @return true if managed to add the match
     */
    public boolean addMatch(String matchID, Date date, String stadium, long totalTickets, MatchResult MatchR) {
    	if(matchID == null || date == null || stadium == null || totalTickets <=0 ) return false;
 		Match match = new Match(matchID);
 		if(matches.containsKey(match.getmId())) {
 			return false;
 		}
 		Match toMatch = new Match(matchID,date,stadium,totalTickets,MatchR);
 		matches.put(matchID, toMatch);
 		return true;
    } 
	/**
     * adds a match to the system IFF it does not exist
     * @param matchID
     * @param date
     * @param stadium
     * @return true if managed to add the match
     */
    public boolean addMatchResult(Team homeTeam, Team awayTeam, String matchId,  int homeTeamScore,
			int awayTeamScore, int totalTime,boolean penaltyEnd) {
    	if(homeTeam == null || awayTeam == null || matchId == null || homeTeamScore <=0 || awayTeamScore <=0 || totalTime<0) return false;
 		MatchResult matchResult = new MatchResult(homeTeam,awayTeam,matchId,totalTime,penaltyEnd,homeTeamScore,awayTeamScore, null);
 	
 		if(matchResults.containsKey(matchId)) {
 			return false;
 		}	
 		
 		matchResults.put(matchId,matchResult);
 		return true;
    }
	/**
     * adds a match to the system IFF it does not exist
     * @param matchID
     * @param date
     * @param stadium
     * @return true if managed to add the match
     */
    public <T> boolean addTrophy(E_Trophy trophy, T owner, Date trophyWinningDate) {
    	if(trophy == null || owner == null || trophyWinningDate == null) return false;
    	Trophy<T> trophys = new Trophy<T>(trophy,owner,trophyWinningDate);
 		if(trophies.contains(trophys)) {
 			return false;
 		}
 		trophies.add(trophys);
 		return true;
	}
    // ============================================================== Functions - Queries ================================================================================================================================ 
    /**
     * adds a Team to Coach
     * @param TeamID
     * @param CoachID
     * @return true if managed to add the Team to coach
     * 
     */
    public boolean addTeamToCoach(String teamId, String coachId) {
    	
        if (teamId == null || coachId == null) { // Check if teamId or coachId is null
            return false;
        }
        
        if (!teams.containsKey(teamId) || !coaches.containsKey(coachId)) { // Check if the team or coach exist
            return false;
        }
        
        Team team = teams.get(teamId); 		// Pulling the variables from the table (specific "HashMap")
        Coach coach = coaches.get(coachId); // -״- -״-
        
        if (coach.getTeams().contains(team)) { // Check if the coach already has this team
            return false;
        }
        
        return coach.addTeam(team); // Add team to coach
    }
    /**
     * adds a Match to Player
     * @param MatchId
     * @param PlayerId
     * @return true if managed to add the Match to Player
     * 
     */
    public boolean addMatchToPlayer(String matchId, String playerId) {

    	if (playerId == null || matchId == null) { // Check if playerId or matchId is null
    		return false;
    	}

        if (!matches.containsKey(matchId) || !players.containsKey(playerId)) { // Check if the match or the player exist
            return false;
        }
        
        Match match = matches.get(matchId);    // Pulling the variables from the table (specific "HashMap")
        Player player = players.get(playerId); // -״- -״-
        
        return player.addMatch(match); // Adding new match to the player
    }
    /**
     * adds a Team to Sponsor
     * @param teamId
     * @param nickName
     * @return true if managed to add the Team to Sponsor
     * 
     */
    public boolean addTeamToSponsor(String teamId, String pId) {

    	if (teamId == null || pId == null) { // Check if teamId or pId is null
    		return false;
    	}

        if (!teams.containsKey(teamId) || !sponsors.containsKey(pId)) { // Check if the teamId or the pId exist
            return false;
        }

        Team team = teams.get(teamId); 		 // Pulling the variables from the table (specific "HashMap")
        Sponsor sponsor = sponsors.get(pId); // -״- -״-
        
        return sponsor.addTeam(team); // Adding new team to the sponsor
    }
    /**
     * adds a Player to Team
     * @param teamId
     * @param PlayerId
     * @return true if managed to add the Player to Team
     * 
     */
    public boolean addPlayerToTeam(String teamId, String playerId) {

    	if (teamId == null || playerId == null) { // Check if teamId or playerId is null
    		return false;
    	}

        if (!teams.containsKey(teamId) || !players.containsKey(playerId)) { // Check if the teamId or the playerId exist
            return false;
        }

        Team team = teams.get(teamId); 			// Pulling the variables from the table (specific "HashMap")
        Player player = players.get(playerId);  // -״- -״-
        									  
        if (team.getPlayers().size() >= 20) { // Checking if there is space in the team ,The team can contain 20 players at most (according the story)
            return false;
        }

        return team.getPlayers().add(player); // Adding new player to the team
    }
    /**
     * adds a Match to Team
     * @param teamId
     * @param MatchId
     * @return true if managed to add the Match to Team
     * 
     */
    public boolean addMatchToTeam(String matchId, String teamId) {

    	if (matchId == null || teamId == null) { // Check if matchId or teamId is null
    		return false;
    	}

        if (!matches.containsKey(matchId) || !teams.containsKey(teamId)) { // Check if the matchId or the teamId exist
            return false;
        }

        Match match = matches.get(matchId); // Pulling the variables from the table (specific "HashMap")
        Team team = teams.get(teamId);		// -״- -״-

        return team.addMatch(match); // Adding new Match to the team 
    }
    /**
     * adds a Costumer to match
     * @param costumerId
     * @param matchId
     * @return true if managed to add the Costumer to match
     * 
     */
    public boolean addCostumerToMatch(String customerId, String matchId) {

    	if (customerId == null || matchId == null) { // Check if customerId or matchId is null
    		return false;
    	}

        if (!matches.containsKey(matchId) || !customers.containsKey(customerId)) { // Check if the customerId or the matchId exist
            return false;
        }

        Match match = matches.get(matchId); // Pulling the variables from the table (specific "HashMap")
        Customer customer = customers.get(customerId);

        if (match.getTookPlace() == null || match.getTotalTickets() >= match.getTookPlace().getCapacity()) { // Check if there is enough space in the match
            return false;
        }

        return match.addCustomer(customer); // Adding new Costumer to the match 
    }
	/**
	 * This query returns the most favored team. 
	 * Most favored team is the team that has the highest number of customers 
	 * that the team is their favorite team.
	 * 
	 * @return team object if found, null otherwise
	 */
    public Team getTheMostFavoredTeam() {
        
    	if (teams.isEmpty()) { // There are no teams in the table (specific "HashMap")
            return null;
        }
        
        Team mostFavoredTeam = null; // We will initialize an empty class of type "Team", so that we can save it
        int maxFans = -1; 			 // We will initialize a numerical value for overriding

        for (Map.Entry<String, Team> team : teams.entrySet()) { // To go through all the keys and values ​​in the map, we will use the "entrySet" method. 
            													// Unique functions can also be used, keySet() will return the keys, while values() will return only values.
        														// Type of team Map.Entry<String, Team> , brings us the key and the value
        	Team team_current = team.getValue();				// In every iteration we will ask for the values
            
        	if (team_current.getFansCount() > maxFans) {
                maxFans = team_current.getFansCount();
                mostFavoredTeam = team_current;
            }
        }
        return mostFavoredTeam;
    }
	/**
	 * This query returns the all best customers. 
	 * "beset customer" that had level of PROFESSIONAL and from UKRAINE.
	 * 
	 * @return array of customers if players were found, empty list otherwise
	 */
    public Collection<Customer> getTheBesetCustomer() {
    	
        HashSet<Customer> customersSet = new HashSet<>();
 
        for (Map.Entry<String, Customer> customerEntry : customers.entrySet()) {
        	
            Customer customer = customerEntry.getValue(); // The object
            
            if (customer.getLevel() == E_Levels.PROFESSIONAL &&
                customer.getNation() == Country.UKRAINE) {
                customersSet.add(customer);
            }
        }
        return customersSet;
    }

	/**
	 * This query returns the Match with the high number of crowd. 
	 * from all the matches return the match with high number of crowd
	 * 
	 * @return match object if found, null otherwise
	 */
	public Match getTheBestHomeMatch() {
		
		long Max_crowd = -1; 		 // Crowd count
		Match MaxMatch_crowd = null; // Saving the object
		
		for(Map.Entry<String, Match> matchEntry: matches.entrySet()) {
			
			Match current_match = matchEntry.getValue();
			
			if( current_match.getCustomers().size() > Max_crowd ){
				Max_crowd = current_match.getCustomers().size();
				MaxMatch_crowd = current_match;
			}
		}
		return MaxMatch_crowd;
	}
	/**
	 * This query returns the Player that has Played the most games'
	 *  if there more than one return the fist one .
	 * @return Player if found. null otherwise
	 */
	public Player getMostActivePlayer() {
		
		int Sum_Maches = -1; 		 // Crowd count
		Player MostGamesPlayed = null; // Saving the object
		
		for(Map.Entry<String, Player> playerEntry: players.entrySet()){
			
			Player current_player = playerEntry.getValue();
			if( current_player.getMatches().size() > Sum_Maches  ){
				Sum_Maches = current_player.getMatches().size();
				MostGamesPlayed = current_player;
			}
		}
		return MostGamesPlayed;	
	}
	/**
	 * This query returns the Match with maximum number of sold out Tickets.
	 * and ends with penalty kicks 
	 *  if there more than one return the fist one .
	 * @return Matc if found. null otherwise
	 */
	public Match getMatchWithMaxSoldOutTickets() {
		
		long MaxSoldOutTickets = -1; 		 // Crowd count
		Match MaxMatch_Tickets = null; // Saving the object
		
		for(Map.Entry<String, Match> matchEntry: matches.entrySet()) {
			
			Match current_match = matchEntry.getValue();
			
			if( current_match.getTotalTickets() > MaxSoldOutTickets ){
				MaxSoldOutTickets = current_match.getTotalTickets();
				MaxMatch_Tickets = current_match;
			}
		}
		return MaxMatch_Tickets;
	}
	/**
	 * This query returns Sponsors that supports Germany
	 * @return Collection of Sponsors if found. empty otherwise
	 */
	public Collection<Sponsor> getSponsorsOfGermany() {
        HashSet<Sponsor> SponsorsSupportGermany = new HashSet<>();
        
        for(Map.Entry<String, Sponsor> sponsorEnter: sponsors.entrySet()) {
        	Sponsor current_sponsor = sponsorEnter.getValue(); // Saving the object every iterations
        	
        	for ( Team team : current_sponsor.getTeam() ) {
        		if( team.getRepresents() == Country.GERMANY ) {
        			SponsorsSupportGermany.add(current_sponsor);
        		}
        	} 
        }
        return SponsorsSupportGermany; 
	}
	/**
	 * This query returns the entity that has won the most trophies.
	 * @return object if found. null otherwise
	 */
	public Object getEntityWithMostTrophies() {
		
		int SumTrophyByCoachOBJ = 0;  // count Max Trophy by Coach
		
		for(Map.Entry<String, Coach> coachEntry: coaches.entrySet()){
			
			Coach current_coach = coachEntry.getValue();
			
			if( current_coach.getTrophy() != null ){
				SumTrophyByCoachOBJ ++;
			}
		}
	
		int SumTrophyByPlayerOBJ = 0;  // count Max Trophy by Player
		
		for(Map.Entry<String, Player> playerEntry: players.entrySet()){
			
			Player current_player = playerEntry.getValue();
			
			if(current_player.getTrophies().size() > SumTrophyByPlayerOBJ  ) {
				SumTrophyByPlayerOBJ = current_player.getTrophies().size();
			}
		}
		
		
		int SumTrophyByTeamOBJ = 0;  // count Max Trophy by Team
	    
		for (Map.Entry<String, Team> teamEntry : teams.entrySet()) {
			
			Team current_team = teamEntry.getValue();
					
			if( current_team.getTrophy() != null ){
				SumTrophyByTeamOBJ ++;
			}
		}
	if(SumTrophyByCoachOBJ > SumTrophyByPlayerOBJ && SumTrophyByCoachOBJ > SumTrophyByTeamOBJ ){return Coach.class.getName();}
	else if(SumTrophyByPlayerOBJ > SumTrophyByCoachOBJ && SumTrophyByPlayerOBJ > SumTrophyByTeamOBJ ){return Player.class.getName();}
	else{return Team.class.getName();}
	}
	/**
	 * This query returns all the Teams of the "Best Home Team" 
	 * "Best Home Team" is the team with the highest homeTeamScore winnings
	 * 
	 * @return array of players if players were found, empty list otherwise  
	 */
	public Collection<Team> getTeamsBestHomeScore() {
	    
	    HashMap<Team, Integer> homeWins = new HashMap<>(); // Map to track the number of home wins for each team

	    for (MatchResult result : matchResults.values()) { // Iterate through all match results
	       
	        if (result.getHomeTeamScore() > result.getAwayTeamScore()) { // Check if the home team scored more than the away team
	            Team homeTeam = result.getHomeTeam(); 					 // Get the home team
	           
	            homeWins.putIfAbsent(homeTeam, 0); 						 // Initialize count to zero if not already in the map, is mean that we put 0 if there is no number
	            homeWins.put(homeTeam, homeWins.get(homeTeam) + 1); 	 // Other, Increment the count of home wins for the home team
	        }
	    }
	    
	    int maxWins = 0;
	    for (int wins : homeWins.values()) { // Find the maximum number of home wins
	        if (wins > maxWins) {
	            maxWins = wins;
	        }
	    }
	    
	    Collection<Team> bestHomeTeams = new ArrayList<>(); // Collection to store teams with the maximum home wins

	    for (Map.Entry<Team, Integer> team : homeWins.entrySet()) { // Iterate through homeWins map to find teams with maxWins
	        if (team.getValue() == maxWins) {
	            bestHomeTeams.add(team.getKey()); // Add team to bestHomeTeams if they have maxWins
	        }
	    }
	    return bestHomeTeams; // Return all teams with the maximum home wins
	}
	/**
	 * This query returns the most popular position. 
	 * Most popular position is the type that belongs to the highest number of players.
	 * 
	 * @return position object if found, null otherwise
	 */
	public E_Position getTheMostPopularPosition() {
	    HashMap<E_Position, Integer> positions = new HashMap<>();
	    
	    for (Player player : players.values()) { // Initialize counts for each position
	        E_Position position = player.getPosition();
	        
	        if (positions.containsKey(position)) { // Check if position already exists in the map
	            positions.put(position, positions.get(position) + 1);
	        } else {
	            positions.put(position, 1); // Initialize count to 1 if position doesn't exist
	        }
	    }

	    int maxPositionCount = -1;			   // count positions
	    E_Position mostPopularPosition = null; // Saving the object every iterations
	   
	    for (Map.Entry<E_Position, Integer> entry : positions.entrySet()) { // Find the position with the maximum count
	        if (entry.getValue() > maxPositionCount) {
	            maxPositionCount = entry.getValue();
	            mostPopularPosition = entry.getKey();
	        }
	    }
	    return mostPopularPosition;
	}
}
