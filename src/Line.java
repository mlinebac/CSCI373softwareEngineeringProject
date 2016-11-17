import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Line extends JPanel{
	private final int length;
	private final int x;
	private final int y;
	public Line(int length, int x, int y){
		this.length = length;
		this.x = x;
		this.y = y;
	}
	public int getLength(){
		return this.length;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void drawVerticalLine(){
		
	}
	public void drawHorizontalLine(){
		
	}
}
