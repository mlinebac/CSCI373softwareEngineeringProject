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

public class FamilyTree extends JPanel {
	
	protected DefaultMutableTreeNode root; // Root of the tree.
	protected DefaultTreeModel model; // The basis of the family tree.
	protected JTree tree; // The entirety of the family tree.
	

	public FamilyTree(){
		super(new GridLayout(1,0));
		MemberInfo ancestor = new MemberInfo("First Known Ancestor");
		root = new DefaultMutableTreeNode(ancestor);
		model = new DefaultTreeModel(root);
		model.addTreeModelListener(new Listener());
		tree = new JTree(model);
		
		// Change when text boxes are added?
		tree.setEditable(true);

		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	}
	
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
	public DefaultMutableTreeNode add(){
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
