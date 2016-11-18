import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{

	
	private final String str;
	
	public Rectangle(int x, int y, int width, int height,String str){
		super(x,y,width,height);
		this.str = str;
	}
	
	public String getStr(){
		return this.str;
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		paintComponents(g);
		g.setColor(Color.BLACK);
		g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
		g.setColor(Color.BLUE);
		g.drawString(this.str, this.getX(), this.getY());
		
	}
}
