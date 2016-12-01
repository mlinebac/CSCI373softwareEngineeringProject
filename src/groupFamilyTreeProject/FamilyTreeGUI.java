package groupFamilyTreeProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.tree.*;
//import net.miginfocom.swing.MigLayout;

public class FamilyTreeGUI extends JPanel implements ActionListener{

	
	
	private FamilyTree familyTree;

	/**
	 * Create the application.
	 */
	public FamilyTreeGUI() {
		super(new BorderLayout());
		
		//create the components
		familyTree = new FamilyTree();
		familyTree.setPreferredSize(new Dimension(300,50));
		add(familyTree, BorderLayout.CENTER);
		
		JPanel panel = new JPanel (new GridLayout(0,4));
	
		// Add person button and operation.
		JButton addPersonButton = new JButton("Add Person");
		addPersonButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addPersonButtonPressed(e);
			}

			private void addPersonButtonPressed(MouseEvent e) {
				int row = familyTree.getRowForLocation(e.getX(), e.getY());
				TreePath path = tree.getPathForLocation(e.getX(), e.getY());
				if (row != -1) {
					if (e.getClickCount() == 1) {
						tree.startEditingAtPath(path);
					}
				}

			}
		});
		panel.add(addPersonButton);
		// Remove person button and operation.
		JButton removePersonButton = new JButton("Remove Person");
		removePersonButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removePersonButtonPressed(e);
			}

			private void removePersonButtonPressed(MouseEvent e) {
				int row = tree.getRowForLocation(e.getX(), e.getY());
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				TreePath path = tree.getPathForLocation(e.getX(), e.getY());
				if (row != -1) {
					if (e.getClickCount() == 1) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
						if (node.getParent() != null) {
							model.removeNodeFromParent(node);
						}
					}
				}
			}
		});
		panel.add(removePersonButton);

		// Delete tree button and operation.
		JButton deleteTreeButton = new JButton("Delete Tree");
		deleteTreeButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				deleteTreeButtonPressed(e);
			}
			private void deleteTreeButtonPressed(MouseEvent e){
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				model.setRoot(null);
				model.reload();
			}
		});
		panel.add(deleteTreeButton);
		
		// Print family tree button and operation.
		JButton printTreeButton = new JButton("Print Tree");
		printTreeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				printTreeButtonPressed(e);
			}
			private void printTreeButtonPressed(MouseEvent e){
				// INSERT CODE TO PRINT THE TREE DIAGRAM HERE
			}
		});
		panel.add(printTreeButton);
		add(panel,BorderLayout.NORTH);
		
		panel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				personClicked(e);
			}
				private void personClicked(MouseEvent e){
					int row = tree.getRowForLocation(e.getX(), e.getY());
					DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
					TreePath path = tree.getPathForLocation(e.getX(), e.getY());
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
	

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		//create and set up the window
		JFrame frame = new JFrame("Family Tree");
		frame.setBounds(300,500,600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create and set up the content pane
		FamilyTreeGUI paneForGUI = new FamilyTreeGUI();
		paneForGUI.setOpaque(true);
		frame.setContentPane(paneForGUI);
		
		//Displays the window
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
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initialize();
            }
        });
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
