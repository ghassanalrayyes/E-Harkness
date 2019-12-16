import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ClassManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassManager window = new ClassManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	
	public void load() throws IOException {
		try (Stream<Path> filePathStream=Files.walk(Paths.get("/home/you/Desktop"))) {
		    filePathStream.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		            try {
						Files.lines(filePath);
						
						try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

							//1. filter line 3
							//2. convert all content to upper case
							//3. convert it into a List
							list = stream
									.filter(line -> !line.startsWith("line3"))
									.map(String::toUpperCase)
									.collect(Collectors.toList());
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            
		        }
		    });
		}
	}
	
	public ClassManager() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 52, 558, 415);
		frame.getContentPane().add(tabbedPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(562, 66, 81, 34);
		frame.getContentPane().add(toolBar);
		
		JPanel panel = new JPanel();
		
		Icon icon = new ImageIcon ("img/red-x.png");
		
		JButton btnRemove = new JButton(icon);
		panel.add(btnRemove);
		btnRemove.setPreferredSize(new Dimension(25,25));
		
		Icon icon1 = new ImageIcon ("img/green-plus.png");
		
		JButton btnAddStudent = new JButton(icon1);
		btnAddStudent.setPreferredSize(new Dimension(25,25));
		panel.add(btnAddStudent);
		
		
		toolBar.add(panel);
		
		
		
		JButton btnAddClass = new JButton("New Class...");
		btnAddClass.setFont(new Font("Arial", Font.PLAIN, 13));
		
		btnAddClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check if file exists
				
			    String class_name = JOptionPane.showInputDialog("Name of class:", "name");
			    System.out.println(class_name);
			    
			    Class c = new Class(class_name);
			    
			    File myObj = new File("storage/Classes/" + class_name + ".txt");
			    try {
					if (myObj.createNewFile()) {
						//load
					}else {
						 String class_name_trial2 = JOptionPane.showInputDialog(null, "A class with that name already exists. Pick a unique name:", "name", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
				
			}
		});
		
		btnAddClass.setBounds(581, 388, 91, 49);
		frame.getContentPane().add(btnAddClass);
		frame.setLocationRelativeTo(null);
	}
}
