import java.util.*;


public class Table {
	
	//representing the flow of the discussion
	LinkedList<Member> discussion; 
	//keeping track of student data
	HashMap<String, Member> members;
	
	//tracking the state of the discussion
	boolean isActive = false;
	
	
	public Table() {
		discussion = new LinkedList<Member>();
		members = new HashMap<String, Member>();
	}
	
	public void addMember(Member m) {
		members.put(m.student_id, m);
	}
	
	public void removeMember(Member m) {
		if(!isActive)
			members.remove(m.student_id);
	}
	
	public void transitionTo(String studentID) {
		discussion.add(members.get(studentID));
	}
	
	
	
	
	
}
