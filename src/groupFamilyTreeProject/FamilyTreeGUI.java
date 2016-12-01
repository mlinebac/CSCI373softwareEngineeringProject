package groupFamilyTreeProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.tree.*;
//import net.miginfocom.swing.MigLayout;

public class FamilyTreeGUI extends JPanel implements ActionListener{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public FamilyTreeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Family Tree");
		frame.setBounds(200, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0,3));
		FamilyTree tree = new FamilyTree();
		//tree.setEditable(true);
		frame.getContentPane().add(tree, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);

		// Add person button and operation.
		JButton addPersonButton = new JButton("Add Person");
		addPersonButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addPersonButtonPressed(e);
			}

			private void addPersonButtonPressed(MouseEvent e) {
				int row = tree.getRowForLocation(e.getX(), e.getY());
				TreePath path = tree.getPathForLocation(e.getX(), e.getY());
				if (row != -1) {
					if (e.getClickCount() == 1) {
						tree.startEditingAtPath(path);
					}
				}

			}
		});
		menuBar.add(addPersonButton);
		
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
		menuBar.add(removePersonButton);

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
		menuBar.add(deleteTreeButton);
		
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
		menuBar.add(printTreeButton);

		textField = new JTextField();
		menuBar.add(textField);
		textField.setColumns(10);
		frame.addMouseListener(new MouseAdapter(){
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
					frame.getComponentAt(e.getX(), e.getY());
				
			}
		});
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamilyTreeGUI window = new FamilyTreeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
