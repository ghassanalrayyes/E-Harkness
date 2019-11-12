
public class Point {

	private int x,y;
	boolean draw;
	
	public Point(int x, int y, boolean draw) {
		this.x=x;
		this.y=y;
		this.draw=draw;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setUse(boolean b) {
		b=draw;
	}
	
	public boolean used() {
		return draw;
	}
	
	public void seat(boolean z) {
		draw=z;
	}

}
