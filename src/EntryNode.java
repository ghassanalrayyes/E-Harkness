import java.time.LocalTime;


public class EntryNode<E> {
	
	E member;
	LocalTime time;
	Point p;
	
	public EntryNode(E member, Point p) {
		this.member = member;
		time = LocalTime.now();
		this.p = p;
	}

}
