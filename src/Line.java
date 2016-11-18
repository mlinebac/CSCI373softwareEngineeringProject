
import java.awt.Color;
import java.awt.Graphics;


public class Line extends Shape{
	
	
	public Line(int x, int y, int length, int height){
		super(x,y,length,height);
	}
	
	public void drawVerticalLine(){
		
	}
	public void drawHorizontalLine(){
		
	}

	@Override
	public void paintComponents(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(this.getX(),this.getY(), this.getWidth(), this.getHeight());
		
	}
}
