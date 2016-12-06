package groupFamilyTreeProject;

/**
 * Code based on the DynamicTreeDemo.
 * 
 * @author Ryan Fairbanks, Adam McCann
 * @version 12/5/2016
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.tree.*;

public class Family extends JPanel implements ActionListener {
	
	private FamilyMember familyTree; // The family tree.
	
	/**
	 * Creates the contents of the window/GUI including buttons, the family tree, and the associated information on each member.
	 */
	public Family(){
		// Create family tree.
		super(new BorderLayout());
		familyTree = new FamilyMember();
		// Add code to fill the tree here.
		
		// Begin creation of the GUI
		JPanel foreground = new JPanel(new GridLayout(0, 5));
		foreground.setPreferredSize(new Dimension(400, 200));
		add(foreground, BorderLayout.CENTER);
		// Declaration of buttons to be displayed at the top of the GUI.
		JButton addButton = new JButton("Add Person");
		JButton removeButton = new JButton("Remove Person");
		JButton deleteButton = new JButton("Delete Tree");
		JButton printButton = new JButton("Print Tree");
		JButton helpButton = new JButton("Help");
		// Add button functionality
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on addPersonButton and calls the addPersonButtonPressed.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e) {
				addPersonButtonPressed(e);
			}
			/**
			 * Button has been pressed, add person to the family tree.
			 * @param e Detected mouse operation.
			 */
			private void addPersonButtonPressed(MouseEvent e) {
				familyTree.addObject("New Child");
			}
		});
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on removePersonButton and calls removePersonButtonPressed.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e) {
				removePersonButtonPressed(e);
			}
			/**
			 * Button has been pressed, remove clicked person from family tree (and thus their descendants).
			 * @param e Detected mouse operation.
			 */
			private void removePersonButtonPressed(MouseEvent e) {
				familyTree.removeCurrentNode();
			}
		});
		deleteButton.addMouseListener(new MouseAdapter(){
			@Override
			/**
			 * Used to detect a mouse click on deleteTreeButton and calls deleteTreeButtonPressed.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				deleteTreeButtonPressed(e);
			}
			/**
			 * Button has been pressed, delete the existing family tree with the default family tree.
			 * @param e Detected mouse operation.
			 */
			private void deleteTreeButtonPressed(MouseEvent e){
				familyTree.clear();
			}
		});
		printButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on printTreeButton and calls printTreeButtonPressed.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				printTreeButtonPressed(e);
			}
			/**
			 * Button has been pressed, output the existing family tree to a PDF file within the base folder.
			 * @param e Detected mouse operation.
			 */
			private void printTreeButtonPressed(MouseEvent e){
				// INSERT CODE TO PRINT THE TREE DIAGRAM HERE
			}
		});
		helpButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on helpButton and calls helpButtonPressed.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				helpButtonPressed(e);
			}
			/**
			 * Button has been pressed, bring up help options.
			 * @param e Detected mouse operation.
			 */
			private void helpButtonPressed(MouseEvent e){
				// INSERT CODE TO PERFORM HELP OPERATION
			}
		});
		// Add the buttons to the GUI
		foreground.add(addButton);
		foreground.add(removeButton);
		foreground.add(deleteButton);
		foreground.add(printButton);
		foreground.add(helpButton);
	}
	/**
	 * Creates the window for the GUI to be displayed in and calls the constructor to create the GUI's contents.
	 */
	public static void initializeGUI(){
		JFrame window = new JFrame("Family Tree"); // Begin creating the window.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Family interior = new Family(); // Set content of the window.
		interior.setOpaque(true);
		window.setContentPane(interior);
		window.pack(); // Make the window visible to the user.
		window.setVisible(true);
	}
	/**
	 * Starts the program, calls the initializeGUI method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				initializeGUI();
			}
		});
	}
}