import java.awt.*;
import javax.swing.*;

/*
 * Chart class makes the Frame
 */
public class Chart extends JFrame implements FamilyChart {

	private static final long serialVersionUID = 1L;
	private final JFrame frame;

	public Chart() {

		frame = new JFrame("Family Tree");
		frame.setSize(1000, 800);
		frame.setLayout(new GridLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	@Override
	public void addRectangleToChart(int x, int y, int width, int height, String str) {
	Rectangle rect = new Rectangle(x, y, width, height, str);
		frame.add(rect);
	}

	public static void main(String args[]) {
		Chart chart = new Chart();
		chart.addRectangleToChart(100, 100, 200, 100, "this is a rectangle");
	}
	

}
