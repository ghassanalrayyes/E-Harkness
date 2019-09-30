import java.awt.image.BufferedImage;

public class Member {
	
	String full_name;
	String student_id;
	BufferedImage image;
	int frequency = 0;
	//add image
	
	public Member(String full_name, String student_id, BufferedImage image) {
		this.full_name = full_name;
		this.student_id = student_id;
		this.image = image;
	}
	

}
