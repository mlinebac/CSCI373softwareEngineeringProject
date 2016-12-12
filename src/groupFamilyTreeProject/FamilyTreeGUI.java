package groupFamilyTreeProject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 * CSCI 373: Software Engineering. Term Project. The purpose of this class is to create a graphic user interface. Through this 
 * interface, the family tree can be viewed and edited. Includes operations for selecting a person in the family tree, add a 
 * person, remove a person, delete the tree, and print the tree to a PDF file.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/12/16
 */

public class FamilyTreeGUI extends JPanel implements MouseListener{

	private FamilyTree tree;

	/**
	 * Create the application; the panels and buttons inside the window.
	 */
	public FamilyTreeGUI() {
		super(new BorderLayout());
		//create the tree
		tree = new FamilyTree();
		// Declaration of buttons to be displayed at the top of the GUI.
		JButton addPersonButton = new JButton("Add Person");
		JButton removePersonButton = new JButton("Remove Person");
		JButton deleteTreeButton = new JButton("Delete Tree");
		JButton printTreeButton = new JButton("Print Tree");
		JButton editPersonButton = new JButton("Edit Person");
		// Add created buttons into the GUI window.
		JPanel panel = new JPanel (new GridLayout(0,5)); // Creates the area for adding graphical components.
		panel.add(addPersonButton);
		panel.add(removePersonButton);
		panel.add(deleteTreeButton);
		panel.add(printTreeButton);
		panel.add(editPersonButton);
		add(panel,BorderLayout.NORTH);
		tree.setPreferredSize(new Dimension(300,300));
		add(tree, BorderLayout.CENTER);
		// Implementation of the proper actions on the respective button being clicked.
		addPersonButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on addPersonButton and calls another method in FamilyTree to add the member.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e) {
				tree.createMember();
			}
		});
		removePersonButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on removePersonButton and calls another method in FamilyTree to remove the member.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e) {
				tree.removeMember();
			}
		});
		deleteTreeButton.addMouseListener(new MouseAdapter(){
			@Override
			/**
			 * Used to detect a mouse click on deleteTreeButton and calls another method in FamilyTree to delete the tree.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				tree.deleteTree();
			}
		});
		printTreeButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on printTreeButton and calls another method in FamilyTree to print the tree.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				try {
					tree.printTree();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		editPersonButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on editPersonButton and performs appropriate action.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				tree.editPerson();
			}
		});
	}
	/**
	 * Initialize size, closing, panes, and other features of the frame for the GUI (window).
	 */
	protected static void initialize() {
		// Create the window, set the size/location, and close operation.
		JFrame frame = new JFrame("Family Tree");
		frame.setBounds(300,500,600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create and set up the content pane.
		FamilyTreeGUI paneForGUI = new FamilyTreeGUI();
		paneForGUI.setOpaque(true);
		frame.setContentPane(paneForGUI);
		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	/*
	 * Unused mouse methods to appease compiler.
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}