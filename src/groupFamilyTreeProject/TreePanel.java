package groupFamilyTreeProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

 
public class TreePanel extends JPanel 
                             implements ActionListener {
    private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
     
    private TreeFrame treePanel;
 
    public TreePanel() {
        super(new BorderLayout());
         
        //Create the components.
        treePanel = new TreeFrame();
        populateTree(treePanel);
 
        JButton addButton = new JButton("Add Member");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);
         
        JButton removeButton = new JButton("Remove Member");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);
         
        JButton clearButton = new JButton("Clear");
        clearButton.setActionCommand(CLEAR_COMMAND);
        clearButton.addActionListener(this);
 
        //Lay everything out.
        treePanel.setPreferredSize(new Dimension(300, 50));
        add(treePanel, BorderLayout.CENTER);
 
        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(addButton);
        panel.add(removeButton); 
        panel.add(clearButton);
    add(panel, BorderLayout.EAST);
    }
 
    public void populateTree(TreeFrame treePanel) {
        String p1Name = new String("Parent 1");
        String p2Name = new String("Parent 2");
        String c1Name = new String("Child 1");
        String c2Name = new String("Child 2");
 
        DefaultMutableTreeNode p1, p2;
 
        p1 = treePanel.addObject(null, p1Name);
        p2 = treePanel.addObject(null, p2Name);
 
        treePanel.addObject(p1, c1Name);
        treePanel.addObject(p1, c2Name);
 
        treePanel.addObject(p2, c1Name);
        treePanel.addObject(p2, c2Name);
    }
     
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
         
        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
            treePanel.addObject("New Node " + newNodeSuffix++);
        } else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            treePanel.removeCurrentNode();
        } else if (CLEAR_COMMAND.equals(command)) {
            //Clear button clicked.
            treePanel.clear();
        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Family Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TreePanel newContentPane = new TreePanel();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}