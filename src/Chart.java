import java.awt.*;
import java.util.List;
import javax.swing.*;

/*
 * Chart class makes the Frame
 */
public class Chart extends JFrame implements FamilyChart  {

	private static final long serialVersionUID = 1L;
	private final JFrame frame;
	List <Shape> shape;
	
	

	public Chart() {

		frame = new JFrame("Family Tree");
		frame.setSize(1000, 800);
		frame.setLayout(new GridLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		Chart chart = new Chart();
	}
	

}
