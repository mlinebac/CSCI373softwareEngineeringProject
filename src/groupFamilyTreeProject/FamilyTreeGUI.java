package groupFamilyTreeProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
//import net.miginfocom.swing.MigLayout;

public class FamilyTreeGUI {

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
		JTree tree = new JTree();
		tree.setEditable(true);
		frame.getContentPane().add(tree, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);

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
