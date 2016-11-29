package groupFamilyTreeProject;

import javax.swing.JScrollPane;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeNode;

public class FamilyTree extends JScrollPane implements TreeWillExpandListener {
	
	
	public TreeNode addTreeNode(){
		DefaultMutableTreeNode root;
		DefaultMutableTreeNode grandparent;
		root = new DefaultMutableTreeNode("Ryan");
		grandparent = new DefaultMutableTreeNode("Ryans Father");
		root.add(grandparent);
		return root;
	}
	
	public void removeMember(String Name, Integer birthDate, String placeOfBirth)
	{
		
	}
	
	public void toString(String Name, Integer birthDate, String placeOfBirth)
	{
		
	}

	@Override
	public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		
	}
}
