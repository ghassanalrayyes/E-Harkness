import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.pdfbox.contentstream.PDFStreamEngine;


public class Table {
	
	//representing the flow of the discussion
	private LinkedList<EntryNode> discussion; 
	//keeping track of student data
	private HashMap<String, Member> members;
	Reader reader;
	//tracking the state of the discussion
	boolean isActive = false;
	
	int max_members = 20;
	
	long startTime;
	
	//how the members are distributed
	private boolean[] seat_map = new boolean[max_members];
	private String[] seat_chart = new String[max_members];
	
	int num_members;
	private boolean shuffle_positions;
	
	//pass in true if we want the program to automatically equally distribute the positions
	//pass in false if the teacher wants to manually add the students at their designated positions
	public Table(int num_members, boolean shuffle_positions) throws IOException {
		
		reader = new Reader();
		
		this.shuffle_positions = shuffle_positions;
		
		discussion = new LinkedList<EntryNode>();
		members = new HashMap<String, Member>();
		this.num_members = num_members; 
		if(this.shuffle_positions)
			distributeMemebrs();
	}
	
	public void startHarkness() {
		isActive = true;
		startTime = System.currentTimeMillis();
		
	}
	
	public String getElapsedTime() {
		long millis = System.currentTimeMillis() - startTime;
		return String.format("%02d min, %02d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(millis),
			    TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
			);
	}
	
	//add member at one of the distributed positions, automatically
	public void addMember(Member m) {
		if(shuffle_positions) {
			members.put(m.student_id, m);
			for (int i = 0; i < seat_map.length; i++) {
				if(seat_map[i] && seat_chart[i] == null) {
					seat_chart[i] = m.student_id;
					seat_map[i] = true;
				}
			}
		}
		
	}
	
	//teacher selects which seat on the table to add member at
	public void addMember(Member m, int position) {
		
		members.put(m.student_id, m);
		seat_chart[position] = m.student_id;
		seat_map[position] = true;
		
	}
	
	
	public void removeMember(Member m) {
		if(!isActive)
			members.remove(m.student_id);
	}
	
	//to get the current state of the table -- for painting the layout and getting student information
	public Member[] getSeatingChart(){
		Member[] output = new Member[max_members];
		for (int i = 0; i < output.length; i++) {
			output[i] = members.get(seat_chart[i]);
		}
		return output;
	}
	
	public void transitionTo(String studentID) {
		if(isActive)
			discussion.add(new EntryNode(members.get(studentID)));
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
	
	public void endHakrness() {
		isActive = false;
		
	}
	
	public Member getMember(String student_id) {
		return reader.members.get(student_id);
	}
	
	
	/*public static void main(String[] args) {
		Table t = new Table(10, true);
		System.out.println(t.getElapsedTime());
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
