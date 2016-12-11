package groupFamilyTreeProject;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

/**
 * CSCI 373: Software Engineering. Term Project. This class is used as a representation of the entirety
 * of the family tree.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/11/16
 */
public class FamilyTree extends JPanel {
	
	protected DefaultMutableTreeNode root; // Root of the tree.
	protected DefaultTreeModel model; // The basis of the family tree.
	protected JTree tree; // The entirety of the family tree.
	
	public FamilyTree(){
		MemberInfo ancestor = new MemberInfo("First Known Ancestor");
		root = new DefaultMutableTreeNode(ancestor);
		model = new DefaultTreeModel(root);
		model.addTreeModelListener(new Listener());
		tree = new JTree(model);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		JScrollPane pane = new JScrollPane(tree);
		add(pane);
	}
	/**
	 * 
	 * @author Ryan Fairbanks
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
		// need to get a filename from the user
/*		String fileName = null;
		MemberInfo[] convertedMembers = (MemberInfo[]) members.toArray();
		FileWriter writer = null;
		
		try
		{
			writer = new FileWriter(fileName, true);
			
			for(int i = 0; i < convertedMembers.length; i++)
			{
				writer.write("Name: " + convertedMembers[i].getName() + ".");
				writer.write("DOB: " + convertedMembers[i].getBirthDate());
				writer.write("Birth Place: " + convertedMembers[i].getPlaceOfBirth() + ".");
				writer.write("DOD: " + convertedMembers[i].getDeathDate() + ".");
				writer.write("Place of Death: " + convertedMembers[i].getPlaceOfDeath() + ".");
				writer.write("Occupation " + convertedMembers[i].getOccupation() + ".");
				writer.write("\n");
			}
			
			writer.close();
		}
		catch(IOException e)
		{
			// needs message and a way to start over.
		}*/
	}
	/**
	 * Contains functionality for the "Help" button in the GUI.
	 */
	public void help(){
		// Code to respond to user's need for help goes here.
	}
	/**
	 * Called from createMember methods to create the actual node using the MemberInfo object.
	 * @param newMember Information of the new member.
	 * @return New node containing the information of the new member.
	 */
	public DefaultMutableTreeNode addObj(MemberInfo newMember){
		DefaultMutableTreeNode parent = null;
		TreePath path = tree.getSelectionPath();
		if(path == null) parent = root;
		else parent = (DefaultMutableTreeNode)(path.getLastPathComponent());
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newMember);
		if(parent == null) parent = root;
		model.insertNodeInto(newNode, parent, parent.getChildCount());
		tree.scrollPathToVisible(new TreePath(newNode.getPath()));
		return newNode;
	}
	/**
	 * Create a default new member, user made.
	 */
	public void createMember(){
		MemberInfo member = new MemberInfo("New Member");
		addObj(member);
	}
	/**
	 * Create a new member, called from the method to produce a default tree.
	 * @param name Name of the person.
	 */
	public void createMember(String name){
		MemberInfo member = new MemberInfo(name);
		addObj(member);
	}
}
