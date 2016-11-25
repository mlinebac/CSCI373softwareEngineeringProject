package groupFamilyTreeProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollBar;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[217px][][][][][][][]", "[236px]"));

		JTree tree = new JTree();
		frame.getContentPane().add(tree, "cell 0 0 7 1,grow");

		JScrollBar scrollBar = new JScrollBar();
		frame.getContentPane().add(scrollBar, "cell 7 0,growy");

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);

		JButton btnNewButton = new JButton("Add Person");
		menuBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Remove Person");
		menuBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete Tree");
		menuBar.add(btnNewButton_2);

		textField = new JTextField();
		menuBar.add(textField);
		textField.setColumns(10);
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
