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
	Member[] seat_chart = new Member[max_members];
	
	int num_members;
	
	public Table(int num_members) {
		isActive = true;
		discussion = new LinkedList<Member>();
		members = new HashMap<String, Member>();
		this.num_members = num_members; 
		distributeMemebrs();
	}
	
	public void addMember(Member m) {
		members.put(m.student_id, m);
		for (int i = 0; i < seat_map.length; i++) {
			if(seat_map[i] && seat_chart[i] == null) {
				seat_chart[i] = m;
			}
		}
	}
	
	public void removeMember(Member m) {
		if(!isActive)
			members.remove(m.student_id);
	}
	
	public void transitionTo(String studentID) {
		if(!isActive)
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
			int occupied = 0;
			spaces = (int)((double)max_members / (double)num_members) + 1;
			for (int i = 0; i < seat_map.length; i+= spaces) {
				seat_map[i] = true;
				occupied++;
			}
			
			if(occupied < num_members) {
				for (int i = spaces/2; i < seat_map.length && occupied < num_members; i+= spaces) {
					seat_map[i] = true;
					occupied++;
				}
			}
		}
	}
	
	public void endSession() {
		isActive = false;
		
		//can
	}
	
	
	
	
	
	
	
}
