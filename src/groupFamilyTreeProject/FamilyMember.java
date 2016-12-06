package groupFamilyTreeProject;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

/**
 * CSCI 373: Software Engineering. Term Project. The purpose of this class is for its instances to act as an individual in the 
 * family tree. This classes houses data on the name, parents, birth date, death date, and other data on all members within the 
 * family tree.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/1/16
 */

/* public class FamilyMember extends JPanel {

	private final String name; // First and last name.
	private final String birthDate; // mm/dd/yyyy
	private final String placeOfBirth; 
	private String deathDate; // mm/dd/yyyy
	private String placeOfDeath;
	private FamilyMember parent1; // Parent displayed in diagram.
	private String parent2; // Parent not displayed in diagram, had a relationship with displayed parent.
	private String occupation;
	
	protected TreeNode ancestor; // The base of the family tree.
	protected DefaultTreeModel compTree; // Default model of the family tree to be used.
	protected JTree tree; // The tree to be used.
	
	public FamilyMember(){
		super(new GridLayout(1,0));
		
		
		treeNode temp = new treeNode();
		temp.setName("First Known Ancestor");
		ancestor = new DefaultMutableTreeNode(temp);
		compTree = new DefaultTreeModel(ancestor);
		compTree.addTreeModelListener(new MyTreeModelLstener());
		tree = new JTree(treeModel);
		
		// Will this remain once the text boxes are added?
		tree.setEditable(true);
		
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
	}
	
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
	
	public String getparent2()
	{
		return this.parent2;
	}
	
	public String getoccupation()
	{
		return this.occupation;
	}
}*/
