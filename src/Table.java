import java.util.*;


public class Table {
	
	//representing the flow of the discussion
	LinkedList<Member> discussion; 
	//keeping track of how often students contribute
	HashMap<String, Integer> member_frequency;
	ArrayList<Member> members;
	
	//tracking the state of the discussion
	boolean isActive = false;
	
	
	public Table() {
		discussion = new LinkedList<Member>();
		member_frequency = new HashMap<String, Integer>();
		members = new ArrayList<Member>();
	}
	
	public void addMember(Member m) {
		members.add(m);
		member_frequency.put(m.student_id, 0);
	}
	
	public void removeMember(Member m) {
		if(!isActive)
			member_frequency.remove(m.student_id);
	}
	
	
}
