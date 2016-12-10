package groupFamilyTreeProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 * 
 * @author Ryan Fairbanks
 *
 */

/*
public class EditGUI extends JPanel implements ActionListener{


	private MemberInfo tempMember;
	private String[] boxText = {"Birth Date", "Birth Place", "Death Date", "Death Place", "Other Parent", "First Spouse", "Second Spouse", "Occupation"};
	public  void createEditWindow(MemberInfo member){
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
	public MemberInfo doEverything(MemberInfo member){
		return this.tempMember;
	}

*/