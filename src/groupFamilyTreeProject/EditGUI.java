package groupFamilyTreeProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * CSCI 373: Software Engineering. Term Project. The methods of this class can be called to produce a window that will display the 
 * GUI for editing the MemberInfo parameters.
 * 
 * 
 * @author Ryan Fairbanks
 * @version 12/10/2016
 */


public class EditGUI extends JPanel implements ActionListener{
	private JLabel actionLabel;
	private MemberInfo tempMember;
	private String[] boxText = {"Birth Date", "Birth Place", "Death Date", "Death Place", "Other Parent", "First Spouse", "Second Spouse", "Occupation"};
	/*
	 * Create the window and call method to create the GUI.
	 * @param member Object of MemberInfo containing the information on the family member clicked.
	 */
	public static void createEditWindow(MemberInfo member){
		// Create new window for editing information on family members.
		JFrame editFrame = new JFrame("Edit " + member.name);
		editFrame.setBounds(300,300,600,600);
		editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create and set up the content pane.
		EditGUI paneForEdit = new EditGUI(member);
		paneForEdit.setOpaque(true);
		editFrame.setContentPane(paneForEdit);
		// Display the window.
		editFrame.pack();
		editFrame.setVisible(true);
	}
	/**
	 * Constructor to create the GUI interface. Creates editable text boxes for each parameter of MemberInfo, aside for name.
	 * @param member Object of MemberInfo containing the information on the family member clicked.
	 */
	public EditGUI(MemberInfo member) {
		this.tempMember = member;
		setLayout(new BorderLayout());
		// Create text fields
		JTextField[] fields = {new JTextField(member.getBirthDate(), 25), new JTextField(member.getPlaceOfBirth(), 25), new JTextField(member.getDeathDate(), 25), new JTextField(member.getPlaceOfDeath(), 25), new JTextField(member.getParentHidden(), 25), new JTextField(member.getSpouse1(), 25), new JTextField(member.getSpouse2(), 25), new JTextField(member.getOccupation(), 25)};
		for(int i = 0; i < fields.length; i++){
			fields[i].setActionCommand(boxText[i]);
			fields[i].addActionListener(this);
		}
		// Create labels for text fields
		JLabel[] labels = new JLabel[9];
		for(int i = 0; i < boxText.length; i++){
			labels[i] = new JLabel("Enter " + boxText[i] + ":");
			labels[i].setLabelFor(fields[i]);
		}
		// Layout components
		JPanel textPane = new JPanel();
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		textPane.setLayout(grid);
		addTextRows(labels, fields, grid, textPane);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.anchor = GridBagConstraints.EAST;
		con.weightx = 1.0;
		textPane.add(actionLabel, con);
	}
	/**
	 * Used to determine which text box was edited and calls the setter for the edited parameter.
	 */
	public void actionPerformed(ActionEvent e){
		JTextField entry = (JTextField)e.getSource();
		if(boxText[0].equals(e.getActionCommand())) {
			tempMember.setBirthDate(entry.getText());
		}
		else if(boxText[1].equals(e.getActionCommand())) {
			tempMember.setPlaceOfBirth(entry.getText());
		}
		else if(boxText[2].equals(e.getActionCommand())) {
			tempMember.setDeathDate(entry.getText());
		}
		else if(boxText[3].equals(e.getActionCommand())) {
			tempMember.setDeathPlace(entry.getText());
		}
		else if(boxText[4].equals(e.getActionCommand())) {
			tempMember.setParentHidden(entry.getText());
		}
		else if(boxText[5].equals(e.getActionCommand())) {
			tempMember.setSpouse1(entry.getText());
		}
		else if(boxText[6].equals(e.getActionCommand())) {
			tempMember.setSpouse2(entry.getText());
		}
		else { // Set occupation, only remaining possibility.
			tempMember.setOccupation(entry.getText());
		}
	}
	/**
	 * Setup the text boxes.
	 * @param labels
	 * @param fields
	 * @param grid
	 * @param con
	 */
	private void addTextRows(JLabel[] labels, JTextField[] fields, GridBagLayout grid, Container con){
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.EAST;
		for (int i = 0; i < labels.length; i++) {
			c.gridwidth = GridBagConstraints.RELATIVE;
			c.fill = GridBagConstraints.NONE;	
			c.weightx = 0.0;
			con.add(labels[i], c);
			c.gridwidth = GridBagConstraints.REMAINDER;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.0;
			con.add(fields[i], c);
		}
	}
}