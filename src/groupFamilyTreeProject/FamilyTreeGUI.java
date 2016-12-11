package groupFamilyTreeProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * CSCI 373: Software Engineering. Term Project. The purpose of this class is to create a graphic user interface. Through this 
 * interface, the family tree can be viewed and edited. Includes operations for selecting a person in the family tree, add a 
 * person, remove a person, delete the tree, and print the tree to a PDF file.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/11/16
 */

public class FamilyTreeGUI extends JPanel implements MouseListener{

	private FamilyTree tree;

	/**
	 * Create the application.
	 */
	public FamilyTreeGUI() {
		super(new BorderLayout());
		//create the tree
		tree = new FamilyTree();
		tree.setPreferredSize(new Dimension(300,50));
		

		// Declaration of buttons to be displayed at the top of the GUI.
		JButton addPersonButton = new JButton("Add Person");
		JButton removePersonButton = new JButton("Remove Person");
		JButton deleteTreeButton = new JButton("Delete Tree");
		JButton printTreeButton = new JButton("Print Tree");
		JButton helpButton = new JButton("Help");
		// Add created buttons into the GUI window.
		JPanel panel = new JPanel (new GridLayout(0,5)); // Creates the area for adding graphical components.
		panel.add(addPersonButton);
		panel.add(removePersonButton);
		panel.add(deleteTreeButton);
		panel.add(printTreeButton);
		panel.add(helpButton);
		add(panel,BorderLayout.NORTH);
		add(tree, BorderLayout.WEST);
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
				tree.printTree();
			}
		});
		helpButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Used to detect a mouse click on helpButton and performs appropriate action.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				// INSERT CODE TO PERFORM HELP OPERATION
			}
		});

		// Detect when a person within the family tree has been clicked.
		panel.addMouseListener(new MouseAdapter(){
			/**
			 * Used to detect a mouse click on a person within the family tree.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				// CREATE CODE TO PASS MEMBER BEING EDITED TO AND CALL EditGUI CONSTRUCTOR
				MemberInfo editMember = tree.getMemberInfo();
				javax.swing.SwingUtilities.invokeLater(() -> EditGUI.createEditWindow(editMember));
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

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
    public void mouseExited(MouseEvent e){

	}
}
