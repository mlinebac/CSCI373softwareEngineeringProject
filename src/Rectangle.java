import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Rectangle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //not sure what this is?
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	private final String str;
	
	public Rectangle(int x, int y, int width, int height,String str){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.str = str;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public Dimension getPreferredSize(){
		return new Dimension(200,100);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString(str, x, y); //this is where you put Person Name
		g.setColor(Color.BLACK);
		g.drawRect(x,y,width,height);
	}
}
