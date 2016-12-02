package groupFamilyTreeProject;

import javax.swing.JScrollPane;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeNode;

/**
 * CSCI 373: Software Engineering. Term Project. This class is used as a representation of the entirety of the family tree.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/2/16
 */

public class FamilyTree extends JScrollPane implements TreeWillExpandListener {
	
	
	/**
	 * https://docs.oracle.com/javase/7/docs/api/javax/swing/tree/TreeNode.html
	 * https://docs.oracle.com/javase/7/docs/api/javax/swing/tree/DefaultMutableTreeNode.html
	 * @return
	 */
	public TreeNode addTreeNode(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Ryan");
		DefaultMutableTreeNode grandparent = new DefaultMutableTreeNode("Ryans Father");
		root.add(grandparent);
		return root;
	}
	

	
	public void removeMember(String Name, Integer birthDate, String placeOfBirth)
	{
		
	}
	
	public void toString(String Name, Integer birthDate, String placeOfBirth)
	{
		
	}

	@Override
	public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		
	}
}
