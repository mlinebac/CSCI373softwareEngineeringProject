package groupFamilyTreeProject;

/**
 * CSCI 373: Software Engineering. Term Project. This class is to be used 
 * as an object to be used as a parameter for new DefaultMutableTreeNode 
 * nodes, which represent every individual in the tree and therefore 
 * formats the structure of the tree. Instances of this class will contain
 * information on the individual for use in the text boxes on the right 
 * side of the GUI and the name of the individual in the family tree on the
 * left side of the GUI.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/6/16
 */

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
	
	/**
	 * Used for creating a member with that already has a name.
	 * @param name Name of the individual to be added to the tree.
	 */
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
	/**
	 * Used for creating a default member that will be named after being added.
	 */
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
	/**
	 * Returns the name of the member to be used as a field name in the family tree.
	 */
	public String toString(){
		return this.name;
	}
	
	// Getters and setters
	/**
	 * Set the date the member was born.
	 * @param birthDate Date.
	 */
	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}
	/**
	 * Set the place the member was born.
	 * @param placeOfBirth Location.
	 */
	public void setPlaceOfBirth(String placeOfBirth){
		this.placeOfBirth = placeOfBirth;
	}
	/**
	 * Set the date the member died.
	 * @param deathDate Date.
	 */
	public void setDeathDate(String deathDate){
		this.deathDate = deathDate;
	}
	/**
	 * Location the member died.
	 * @param placeOfDeath Location.
	 */
	public void setDeathPlace(String placeOfDeath){
		this.placeOfDeath = placeOfDeath;
	}
	/**
	 * Set the member's parent that is not displayed in the family tree diagram.
	 * @param parentHidden Member's parent.
	 */
	public void setParentHidden(String parentHidden){
		this.parentHidden = parentHidden;
	}
	/**
	 * Set the name of the first individual that the member married or had children with.
	 * @param spouse1 First husband or wife.
	 */
	public void setSpouse1(String spouse1){
		this.spouse1 = spouse1;
	}
	/**
	 * Set the name of the second individual that the member married or had children with.
	 * @param spouse2 Second husband or wife.
	 */
	public void setSpouse2(String spouse2){
		this.spouse2 = spouse2;
	}
	/**
	 * Set the member's occupation.
	 * @param occupation Job the member held.
	 */
	public void setOccupation(String occupation){
		this.occupation = occupation;
	}
	/**
	 * Returns the name of the member.
	 * @return Name.
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * Returns the date of birth of the member.
	 * @return Date of birth.
	 */
	public String getBirthDate(){
		return this.birthDate;
	}
	/**
	 * Returns the place of birth of the member.
	 * @return Place of birth.
	 */
	public String getPlaceOfBirth(){
		return this.placeOfBirth;
	}
	/**
	 * Returns the date of death of the member.
	 * @return Date of death.
	 */
	public String getDeathDate(){
		return this.deathDate;
	}
	/**
	 * Returns the place of death of the member.
	 * @return Place of death.
	 */
	public String getPlaceOfDeath(){
		return this.placeOfDeath;
	}
	/**
	 * Returns the member's parent not displayed in the family tree diagram.
	 * @return Parent not displayed.
	 */
	public String getParentHidden(){
		return this.parentHidden;
	}
	public String getSpouse1(){
		return this.spouse1;
	}
	public String getSpouse2(){
		return this.spouse1;
	}
	/**
	 * Returns the occupation of the member.
	 * @return Occupation.
	 */
	public String getOccupation(){
		return this.occupation;
	}
}
