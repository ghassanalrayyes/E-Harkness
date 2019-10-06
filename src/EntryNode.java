import java.time.LocalTime;


public class EntryNode<E> {
	
	E member;
	LocalTime time;
	
	public EntryNode(E member) {
		this.member = member;
		time = LocalTime.now();
	}

}
