package groupFamilyTreeProject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

/**
 * CSCI 373: Software Engineering. Term Project. This class is used as a representation of the entirety
 * of the family tree.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/2/16
 */

public class FamilyTree extends JScrollPane implements TreeWillExpandListener {
	
	protected DefaultMutableTreeNode rootNode; // Root of the tree.
	protected DefaultTreeModel model; // The basis of the family tree.
	protected JTree tree; // The entirety of the family tree.
	
	/**
	 * https://docs.oracle.com/javase/7/docs/api/javax/swing/tree/TreeNode.html
	 * https://docs.oracle.com/javase/7/docs/api/javax/swing/tree/DefaultMutableTreeNode.html
	 * @return
	 */
	public TreeNode addTreeNode(){
		MemberInfo ancestor = new MemberInfo("First Known Ancestor");
		MemberInfo ancestorChild = new MemberInfo("Ancestor's Child")
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(ancestor);
		DefaultMutableTreeNode rootChild = new DefaultMutableTreeNode(ancestorChild);
		root.add(rootChild);
		return root;
	}
	
	/*
	 * Add a child to the selected node.
	 */
	public DefaultMutableTreeNode add(){
		MemberInfo newChild = new MemberInfo(); // Default value for new node.
		DefaultMutableTreeNode parent = null;
		TreePath parentPath = tree.getSelectionPath();
		if(parentPath == null) parent = rootNode;
		else parent = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
		return add(parent, newChild);
	}
	
	public DefaultMutableTreeNode add(DefaultMutableTreeNode parent, MemberInfo newChild){
		DefaultMutableTreeNode 
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
