
public interface FamilyChart {

	void addRectangleToChart(int x, int y, int width, int height, String str);

	public static void main(String args[]) {
		Chart chart = new Chart();
		chart.addRectangleToChart(100, 100, 200, 100, "this is a rectangle");
	}

}
