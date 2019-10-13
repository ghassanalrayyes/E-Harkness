import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Member {
	
	String full_name;
	String student_id;
	BufferedImage image;
	
	ArrayList<Interruption> interruptions;
	ArrayList<Question> questions;
	
	int frequency = 0;
	
	//to be filled out by teacher as the discussion progresses
	String comments = "";
	
	
	public Member(String full_name, String student_id, BufferedImage image) {
		this.full_name = full_name;
		this.student_id = student_id;
		this.image = image;
		
		interruptions = new ArrayList<Interruption>();
		questions = new ArrayList<Question>();
	}
	
	public void addInterrption(long time) {
		interruptions.add(new Interruption(time));
	}
	
}
