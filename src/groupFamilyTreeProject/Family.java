package groupFamilyTreeProject;

/**
 * Code based on the DynamicTreeDemo.
 * 
 * @author bosto
 * @version 12/5/2016
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.tree.*;

public class Family extends JPanel implements ActionListener {
	
	private FamilyMember familyTree;
	
	public Family(){
		// Create family tree.
		super(new BorderLayout());
		familyTree = new FamilyMember();
		// Add code to fill the tree here.
		
		// Begin creation of the GUI
		JPanel foreground = new JPanel(new GridLayout(0, 5));
		// Declaration of buttons to be displayed at the top of the GUI.
		JButton addPersonButton = new JButton("Add Person");
		JButton removePersonButton = new JButton("Remove Person");
		JButton deleteTreeButton = new JButton("Delete Tree");
		JButton printTreeButton = new JButton("Print Tree");
		JButton helpButton = new JButton("Help");
	}
	public static void main(String[] args) {
		

	}

}
