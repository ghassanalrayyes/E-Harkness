import java.util.HashMap;


/*
 * 
 * Represents every class taught by the teacher (user)
 * 
 * */

public class Class {
	
	String name = "";
	
	private int max_members = 20;
	public HashMap<String, Member> members;
	
	//a chart denoted by student IDs
	//not denoted by Member instances one list containing all the data already exists
	public String[] seat_chart = new String[max_members];
	
	public Class(String class_name) {
		name = class_name;
		members = new HashMap<>();
	}

}
