package core;

import java.io.Serializable;
import java.util.Objects;

import utils.Country;

public abstract class Person implements Serializable {
	
   // Unique identifier
   private static final long serialVersionUID = 1L; // To use files
   
   // Characteristics
   protected String pId; 
   protected String fullName;
   protected int age;
   protected Country nation;
   
	//constructor for primary key
	public Person(String pId) {
	super();
	this.pId = pId;
	}
   
   //constructor
	public Person(String pId, String fullName, int age, String nation) {
	super();
	this.pId = pId;
	this.fullName = fullName;
	this.age = age;
	setNation(nation);
	}

    // Setters & Getters
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Country getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = Country.getCounrtyByName(nation);
	}

	// Functions - basic
	@Override
	public String toString() {
		return "Person [pId=" + pId + ", fullName=" + fullName + ", age=" + age + ", nation=" + nation + "]";
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(pId);
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Person person = (Person) o;
	    return pId.equals(person.pId);
	}
}
