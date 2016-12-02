package groupFamilyTreeProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * CSCI 373: Software Engineering. Term Project.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/1/16
 */

public class FamilyTreeApp {

	private JFrame frame;
	private JTextField textField_1;
	/**
	 * Create the application.
	 */
	public FamilyTreeApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Family Tree");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[217px][][][][][][][]", "[236px]"));
		
		JTree tree = new JTree();
		frame.getContentPane().add(tree, "cell 0 0 7 1,grow");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);
		
		JButton addPerson = new JButton("Add Person");
		addPerson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addPersonButtonPressed(e);
			}

			private void addPersonButtonPressed(MouseEvent e) {
				TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
				if (tp != null)
					textField_1.setText(tp.toString());
				else
					textField_1.setText("");
			}
		});
		menuBar.add(addPerson);
		
		JButton btnNewButton_1 = new JButton("Remove Person");
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Tree");
		menuBar.add(btnNewButton_2);
		
		textField_1 = new JTextField();
		menuBar.add(textField_1);
		textField_1.setColumns(10);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamilyTreeApp window = new FamilyTreeApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

	