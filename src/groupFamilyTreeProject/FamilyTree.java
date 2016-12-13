package groupFamilyTreeProject;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.image.*;
import java.io.IOException;
import javax.swing.event.*;
import javax.swing.tree.*;

/**
 * CSCI 373: Software Engineering. Term Project. This class is used as a representation of the entirety
 * of the family tree.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/12/16
 */
public class FamilyTree extends JPanel {
	
	protected DefaultMutableTreeNode root; // Root node of the family tree.
	protected DefaultTreeModel model; // The system of nodes that represent the family tree.
	protected JTree tree; // Displays model, the family tree.
	protected Integer fileCount = 0; // Used for the file name.
	
	/**
	 * Constructs the FamilyTree to be displayed in the GUI.
	 */
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
		tree.setPreferredSize(new Dimension(600, 600));
		add(pane);
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
	 * Contains functionality for the "Remove Person" button in the GUI. Deletes the last clicked member from family tree.
	 */
	public void removeMember(){
		TreePath current = tree.getSelectionPath();
		if(current != null){ // Current family member exists in the family tree.
			DefaultMutableTreeNode tempNode = (DefaultMutableTreeNode)(current.getLastPathComponent());
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)(tempNode.getParent());
			if(parent != null){ // Current member has an existing parent in the family tree.
				model.removeNodeFromParent(tempNode); // Delete the designated member.
			}
		}
	}
	/**
	 * Contains functionality for the "Delete Tree" button in the GUI using existing methods of Javax. Removes all children and
	 * reloads the family tree interface.
	 */
	public void deleteTree(){
		root.removeAllChildren();
		model.reload();
	}
	/**
	 * Contains functionality for the "Print Tree" button in the GUI. Calls methods ScreenGrab to produce a BufferedImage of the 
	 * family tree. Each created jpeg will be followed by a number after the first one.
	 * @throws IOException 
	 */
	public void printTree() throws IOException{
		BufferedImage image = ScreenGrab.createImage(tree);
		if(fileCount == 0) ScreenGrab.writeImage(image, "tree.jpg");
		else ScreenGrab.writeImage(image, "tree" + fileCount + ".jpg");
		fileCount++;
	}
	/**
	 * Contains functionality for the "Edit Person" button in the GUI. Detects the last clicked person and calls createEditWindow
	 * with the person node's MemberInfo to produce the edit window.
	 */
	public void editPerson(){
		//DefaultMutableTreeNode current = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
		MemberInfo currentMember = /*(MemberInfo)current.getUserObject()*/ new MemberInfo("Test Member");
		if(currentMember != null){
			javax.swing.SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					EditGUI.createEditWindow(currentMember);
				}
			});
		}
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
