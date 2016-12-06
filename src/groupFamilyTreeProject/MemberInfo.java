package groupFamilyTreeProject;

public class MemberInfo{
	
	protected String name; // First and last name.
	protected String birthDate; // mm/dd/yyyy
	protected String placeOfBirth; 
	protected String deathDate; // mm/dd/yyyy
	protected String placeOfDeath;
	protected String parentHidden; // Parent not displayed in diagram, had a relationship with displayed parent.
	protected String spouse1; // The name of the first individual that the member married and had children with.
	protected String spouse2; // The name of the second individual that the member married and had children with.
	protected String occupation;
	
	public MemberInfo(String name){
		this.name = name;
		this.birthDate = "Enter the birth date.";
		this.placeOfBirth = "Enter the place of birth.";
		this.deathDate = "Enter  the death date.";
		this.placeOfDeath = "Enter the place of death.";
		this.parentHidden = "Enter the second parent";
		this.spouse1 = "Enter the first spouse.";
		this.spouse2 = "Enter the second spouse.";
		this.occupation = "Enter the occupation";
	}
	
	public MemberInfo(){
		this.name = "Enter the name";
		this.birthDate = "Enter the birth date.";
		this.placeOfBirth = "Enter the place of birth.";
		this.deathDate = "Enter  the death date.";
		this.placeOfDeath = "Enter the place of death.";
		this.parentHidden = "Enter the second parent";
		this.spouse1 = "Enter the first spouse.";
		this.spouse2 = "Enter the second spouse.";
		this.occupation = "Enter the occupation";
	}
	
	public String toString(){
		return this.name;
	}
	
	public void setDeathDate(String deathDate)
	{
		this.deathDate = deathDate;
	}
	
	public void setDeathPlace(String placeOfDeath)
	{
		this.placeOfDeath = placeOfDeath;
	}
	
	public void setParentHidden(String parentHidden)
	{
		this.parentHidden = parentHidden;
	}
	
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

	public String getName()
	{
		return this.name;
	}
	
	public String getBirthDate()
	{
		return this.birthDate;
	}
	
	public String getPlaceOfBirth()
	{
		return this.placeOfBirth;
	}
	
	public String getDeathDate()
	{
		return this.deathDate;
	}
	
	public String getPlaceOfDeath()
	{
		return this.placeOfDeath;
	}
	
	public String getParentHidden()
	{
		return this.parentHidden;
	}
	
	public String getOccupation()
	{
		return this.occupation;
	}
}
