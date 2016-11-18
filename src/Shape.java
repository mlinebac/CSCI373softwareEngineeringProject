import java.awt.Graphics;

public abstract class Shape {
	
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	
	
	
	public Shape(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getWidth(){
		return this.width;
	}
	public int getHeight(){
		return this.height;
	}
	
	public abstract void paintComponents(Graphics g);

}
