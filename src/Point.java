import java.awt.Rectangle;

public class Point extends Rectangle{


	boolean draw;
	boolean clicked;
	
	public Point(int x, int y, boolean draw) {
		this.x=x;
		this.y=y;
		this.height = 10;
		this.width = 10;
		this.draw=draw;
		clicked = false;
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
