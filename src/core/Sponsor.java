package core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sponsor extends Person implements Comparable<Sponsor>{
	
	// Unique identifier
	private static final long serialVersionUID = 1L; // To use files
	
	// Characteristics
	private String nickName;
	
	private Set<Team> teams; // The list of the Unique teams

	//constructor for primary key
	public Sponsor(String pId) {
		super(pId);
	}
	
	//constructor
	public Sponsor(String pId, String fullName, int age, String nation, String nickName) {
		super(pId, fullName, age, nation);
		this.nickName = nickName;
		
		this.teams = new HashSet<>();
	}

    // Setters & Getters	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	

	public Set<Team> getTeam() {
		return teams;
	}

	public void setTeam(Set<Team> team) {
		this.teams = team;
	}

	// Functions
	@Override
	public String toString() {
		return "Sponsor [nickName=" + nickName + ", team=" + teams + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nickName, teams);
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
		Sponsor other = (Sponsor) obj;
		return Objects.equals(nickName, other.nickName) && Objects.equals(teams, other.teams);
	}

	// Functions - more
	@Override
	public int compareTo(Sponsor o) {
		// TODO Auto-generated method stub
		return this.getpId().compareTo(o.getpId());
	}
	
    public boolean addTeam(Team team) {
        if (team != null) {
            return teams.add(team);
        }
        return false;
    }
}
