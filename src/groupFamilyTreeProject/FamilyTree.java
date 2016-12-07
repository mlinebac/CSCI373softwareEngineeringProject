package groupFamilyTreeProject;

import java.awt.*;
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

public class FamilyTree extends JTree {
	
	protected DefaultMutableTreeNode root; // Root of the tree.
	protected DefaultTreeModel model; // The basis of the family tree.
	protected JTree tree; // The entirety of the family tree.
	

	public FamilyTree(){

		//MemberInfo ancestor;
		//ancestor = new MemberInfo("First Known Ancestor");
		root = new DefaultMutableTreeNode("First Known Ancestor");
		model = new DefaultTreeModel(root);
		//model.addTreeModelListener(new Listener());
		tree = new JTree(model);
		// Change when text boxes are added?
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);

	}
	/**
	 * 
	 * @author bosto
	 * @version 12/6/16
	 */
	class Listener implements TreeModelListener{
		public void treeNodesChanged(TreeModelEvent e){
			DefaultMutableTreeNode node;
			node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());
			int index = e.getChildIndices()[0];
			node = (DefaultMutableTreeNode)(node.getChildAt(index));
			System.out.println("Node editing complete: " + node.getUserObject());
		}
		public void treeNodesInserted(TreeModelEvent e){}
		public void treeNodesRemoved(TreeModelEvent e){}
		public void treeStructureChanged(TreeModelEvent e){}
	}
	/**
	 * Contains functionality for the "Remove Person" button in the GUI.
	 */
	public void removeMember(){
		TreePath current = tree.getSelectionPath();
		if(current != null){ // Current family member exists in the family tree.
			DefaultMutableTreeNode tempNode = (DefaultMutableTreeNode)(current.getLastPathComponent());
			MutableTreeNode parent = (MutableTreeNode)(tempNode.getParent());
			if(parent != null){ // Current member has an existing parent in the family tree.
				model.removeNodeFromParent(tempNode); // Delete the designated member.
			}
		}
	}
	/**
	 * Contains functionality for the "Delete Tree" button in the GUI using existing methods of Javax.
	 */
	public void deleteTree(){
		root.removeAllChildren();
		model.reload();
	}
	/**
	 * Contains functionality for the "Print Tree" button in the GUI.
	 */
	public void printTree(){
		// Code goes here to print the tree.
	}
	/**
	 * Contains functionality for the "Help" button in the GUI.
	 */
	public void help(){
		// Code to respond to user's need for help goes here.
	}
	/**
	 * Does not have functionality at the moment...
	 * 
	 * https://docs.oracle.com/javase/7/docs/api/javax/swing/tree/TreeNode.html
	 * https://docs.oracle.com/javase/7/docs/api/javax/swing/tree/DefaultMutableTreeNode.html
	 * @return
	 */
	public TreeNode addTreeNode(){
		MemberInfo ancestor = new MemberInfo("First Known Ancestor");
		MemberInfo ancestorChild = new MemberInfo("Ancestor's Child");
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(ancestor);
		DefaultMutableTreeNode rootChild = new DefaultMutableTreeNode(ancestorChild);
		root.add(rootChild);
		return root;
	}
	
	/*
	 * Add a child to the selected node.
	 */
	public DefaultMutableTreeNode add(DefaultMutableTreeNode parent, String parentName){
		MemberInfo newChild = new MemberInfo(); // Default value for new node.
		DefaultMutableTreeNode parent = null;
		TreePath parentPath = tree.getSelectionPath();
		if(parentPath == null) parent = root;
		else parent = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
		return add(parent, newChild);
	}
	
	public DefaultMutableTreeNode add(DefaultMutableTreeNode parent, MemberInfo newChild){
		//DefaultMutableTreeNode 
		return null;
	}
	
	public void removeMember(String Name, Integer birthDate, String placeOfBirth)
	{
		
	}
	

/**	@Override
	public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		
	}*/
}
