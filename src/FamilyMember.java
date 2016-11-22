

import java.lang.Integer;

public class FamilyMember {

	private final String name;
	private final Integer birthDate;
	private final String placeOfBirth;
	private Integer deathDate;
	private String placeOfDeath;
	private FamilyMember parent1;
	private FamilyMember parent2;
	private String occupation;
	
	public FamilyMember(String name, Integer birthDate, String placeOfBirth)
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
	
	public void setDeathDate(Integer deathDate)
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
	
	public void setParent2(FamilyMember parent2)
	{
		this.parent2 = parent2;
	}
	
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}
}