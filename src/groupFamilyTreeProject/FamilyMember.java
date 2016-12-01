package groupFamilyTreeProject;
/**
 * CSCI 373: Software Engineering. Term Project. The purpose of this class is for its instances to act as an individual in the 
 * family tree. This classes houses data on the name, parents, birth date, death date, and other data on all members within the 
 * family tree.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/1/16
 */

import java.lang.Integer;

public class FamilyMember {

	private final String name; // First and last name.
	private final String birthDate;
	private final String placeOfBirth;
	private String deathDate;
	private String placeOfDeath;
	private FamilyMember parent1; // Parent displayed in diagram.
	private String parent2; // Parent not displayed in diagram, had a relationship with displayed parent.
	private String occupation;
	
	public FamilyMember(String name, String birthDate, String placeOfBirth)
	{
		this.name = name;
		this.birthDate = birthDate;
		this.placeOfBirth = placeOfBirth;
		deathDate = null;
		placeOfDeath = null;
		parent1 = null;
		parent2 = null;
		occupation = null;
	}
	
	public void setDeathDate(String deathDate)
	{
		this.deathDate = deathDate;
	}
	
	public void setDeathPlace(String placeOfDeath)
	{
		this.placeOfDeath = placeOfDeath;
	}
	
	public void setParent1(FamilyMember parent1)
	{
		this.parent1 = parent1;
	}
	
	public void setParent2(String parent2)
	{
		this.parent2 = parent2;
	}
	
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

	public String getName()
	{
		return this.name;
	}
	
	public String getbirthDate()
	{
		return this.birthDate;
	}
	
	public String getplaceofBirth()
	{
		return this.placeOfBirth;
	}
	
	public String getdeathDate()
	{
		return this.deathDate;
	}
	
	public String getplaceofDeath()
	{
		return this.placeOfDeath;
	}
	
	public FamilyMember getparent1()
	{
		return this.parent1;
	}
	
	public FamilyMember getparent2()
	{
		return this.parent2;
	}
	
	public String getoccupation()
	{
		return this.occupation;
	}
}
