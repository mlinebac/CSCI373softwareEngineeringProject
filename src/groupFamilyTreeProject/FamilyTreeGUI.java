package groupFamilyTreeProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

/**
 * CSCI 373: Software Engineering. Term Project. The purpose of this class is to create a graphic user interface. Through this 
 * interface, the family tree can be viewed and edited. Includes operations for selecting a person in the family tree, add a 
 * person, remove a person, delete the tree, and print the tree to a PDF file.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/2/16
 */

public class FamilyTreeGUI extends JPanel implements TreeSelectionListener{

	private FamilyTree familyTree;

	/**
	 * Create the application.
	 */
	public FamilyTreeGUI() {
		super(new BorderLayout());
		

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

		//create the tree
		familyTree = new FamilyTree();
		addFamilyMembersToTree(familyTree);
		JTree tree = familyTree.tree;
		tree.setPreferredSize(new Dimension(300,50));
		add(tree, BorderLayout.CENTER);
		add(panel,BorderLayout.NORTH);
		// Implementation of the proper actions on the respective button being clicked.
		addPersonButton.addMouseListener(new MouseAdapter() {
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
			public void addPersonButtonPressed(MouseEvent e) {
				int row = familyTree.tree.getRowForLocation(e.getX(), e.getY());
				TreePath path = familyTree.tree.getPathForLocation(e.getX(), e.getY());
				if (row != -1) {
					if (e.getClickCount() == 1) {
						familyTree.tree.startEditingAtPath(path);

					}
				}
			}
		});
		removePersonButton.addMouseListener(new MouseAdapter() {
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
				familyTree.removeMember();
				
				// Old remove member code.
				
				/*int row = familyTree.tree.getRowForLocation(e.getX(), e.getY());
				DefaultTreeModel model = (DefaultTreeModel) familyTree.tree.getModel();
				TreePath path = familyTree.tree.getPathForLocation(e.getX(), e.getY());
				if (row != -1) {
					if (e.getClickCount() == 1) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
						if (node.getParent() != null) {
							model.removeNodeFromParent(node);
						}
					}
				}*/
			}
		});
		deleteTreeButton.addMouseListener(new MouseAdapter(){
			@Override
			/**
			 * Used to detect a mouse click on deleteTreeButton and calls deleteTreeButtonPressed.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				deleteTreeButtonPressed(e);
			}
			/**
			 * Button has been pressed, delete the existing family tree.
			 * @param e Detected mouse operation.
			 */
			private void deleteTreeButtonPressed(MouseEvent e){
				familyTree.deleteTree();
			}
		});
		printTreeButton.addMouseListener(new MouseAdapter() {
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

		// Detect when a person within the family tree has been clicked.
		panel.addMouseListener(new MouseAdapter(){
			/**
			 * Used to detect a mouse click on a person within the family tree.
			 * @param e Detected mouse operation.
			 */
			public void mouseClicked(MouseEvent e){
				personClicked(e);
			}
			/**
			 * 
			 * @param e Detected mouse operation.
			 */
			private void personClicked(MouseEvent e){
				int row = familyTree.tree.getRowForLocation(e.getX(), e.getY());
				DefaultTreeModel model = (DefaultTreeModel) familyTree.tree.getModel();
				TreePath path = familyTree.tree.getPathForLocation(e.getX(), e.getY());
				if (row != -1) {
					if (e.getClickCount() == 1) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
						if (node.getParent() != null) {
							//?????????????????		
							}
						}
					}
					panel.getComponentAt(e.getX(), e.getY());
				}
		});
	}

	private void addFamilyMembersToTree(FamilyTree familyTree) {

		DefaultMutableTreeNode parent;
		parent = (DefaultMutableTreeNode) familyTree.addTreeNode().getParent();
		familyTree.add(parent, "parent 1");

	}


	/**
	 * Initialize size, closing, panes, and other features of the frame for the GUI (window).
	 */
	private static void initialize() {
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
		
		
	public void MouseClicked (MouseEvent e){
		
	}
	
	

	// Incomplete code for left side of the GUI, text fields that can be edited for each family member.
	/*public FamilyMember FamilyMemberInformation(FamilyMember member){
		setLayout(new BorderLayout());
		JTextField nameField = new JTextField(member.getName(), 25); // Name field
		nameField.setActionCommand(nameText);
		nameField.addActionListener(this);
		JTextField birthField = new JTextField(member.getBirthDate(), 25); // Birth date field
		birthField.setActionCommand(birthText);
		birthField.addActionListener(this);
		JTextField deathField = new JTextField(member.getDeathDate(), 25); // Death date field
		deathField.setActionCommand(deathText);
		deathField.addActionListener(this);
		onUse = new JLabel("Enter data");
		onUse.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
	}*/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(() -> initialize());
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {

    }
}
