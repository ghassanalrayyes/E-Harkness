import java.util.ArrayList;
import java.util.HashMap;

public class Class {
	
	String name = "";
	
	private int max_members = 20;
	public HashMap<String, Member> members;
	public String[] seat_chart = new String[max_members];
	
	
	public Class(String class_name) {
		name = class_name;
		members = new HashMap<>();
	}

}
