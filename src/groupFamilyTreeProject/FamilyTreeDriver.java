package groupFamilyTreeProject;
/**
 * CSCI 373: Software Engineering. Term Project. This class is used to start the program; runs the FamilyTreeGUI.
 * 
 * @author Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
 * @version 12/12/16
 */
public class FamilyTreeDriver {
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(() -> FamilyTreeGUI.initialize());
	}
}
