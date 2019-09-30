import java.util.*;


public class Table {
	
	//representing the flow of the discussion
	LinkedList<Member> discussion; 
	//keeping track of student data
	HashMap<String, Member> members;
	
	//tracking the state of the discussion
	boolean isActive = false;
	
	int max_members = 20;

	//how the members are distributed
	boolean[] seat_map = new boolean[max_members];
	
	int num_members;
	
	public Table(int num_members) {
		discussion = new LinkedList<Member>();
		members = new HashMap<String, Member>();
		this.num_members = num_members; 
		distributeMemebrs();
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
	
	private void distributeMemebrs() {
		int spaces = 0;
		if(max_members % num_members == 0) {
			spaces = max_members / num_members;
			for (int i = 0; i < seat_map.length; i+= spaces) {
				seat_map[i] = true;
			}
		}else {
			
		}
	}
	
	
	
	
	
}
