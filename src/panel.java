import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class panel {
	//lets hope this works
	private JFrame frmStudent;

	Member m;
	/**
	 * Launch the application.
	 */
	
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member dum=new Member("David Friedman","12","DavidFriedman",ImageIO.read(new File("img/test.jpg")));
					panel window = new panel(dum);
					window.frmStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	

	/**
	 * Create the application.
	 */
	public panel(Member m1) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frmStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		m=m1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudent = new JFrame();
		frmStudent.setResizable(false);
		frmStudent.setTitle(m.full_name);
		frmStudent.setBounds(100, 100, 300, 500);
		frmStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudent.getContentPane().setLayout(null);
		ImageIcon testr = new ImageIcon(m.image);
		Image scaledTest=testr.getImage().getScaledInstance(164, 200, Image.SCALE_SMOOTH);
		testr=new ImageIcon(scaledTest);
		JLabel student = new JLabel("");
		student.setIcon(testr);
		student.setBounds(6, 6, 164, 200);
		frmStudent.getContentPane().add(student);
		
		JButton question = new JButton("Question");
		question.setBounds(182, 116, 117, 29);
		frmStudent.getContentPane().add(question);
		
		JButton interrupt = new JButton("Interruption");
		interrupt.setBounds(182, 87, 117, 29);
		frmStudent.getContentPane().add(interrupt);
		
		JButton cite = new JButton("Evidence Cited");
		cite.setBounds(182, 146, 117, 29);
		frmStudent.getContentPane().add(cite);
		
		JButton save = new JButton("Save");
		save.setBounds(182, 177, 117, 29);
		frmStudent.getContentPane().add(save);
		
		ImageIcon test2 = new ImageIcon("img/logo.png");
		Image logo = test2.getImage().getScaledInstance(74, 77, Image.SCALE_SMOOTH);
		JLabel logoIcon = new JLabel("");
		logoIcon.setIcon(new ImageIcon(logo));
		logoIcon.setBounds(203, 6, 74, 77);
		frmStudent.getContentPane().add(logoIcon);
		
		JTextArea comments = new JTextArea(m.comments);
		comments.setWrapStyleWord(true);
		comments.setLineWrap(true);
		comments.setText("Type your comments here.");
		comments.setBounds(6, 213, 288, 259);
		frmStudent.getContentPane().add(comments);
	}
}
