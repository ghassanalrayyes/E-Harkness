import java.awt.BorderLayout;
import java.awt.Component;
import org.apache.commons.io.*;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JLabel;


public class ClassManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 * 
	 */
	
	public List<String> list;
	private ArrayList<Class> classes = new ArrayList<Class>();
	
	
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
	
	public void getClasses() {
		
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	
	//helper function
	public boolean contains_str(ArrayList<String> list, String str) {
		for (String title : list) {
			if(title.equals(str))
				return true;
		}
		return false;
	}
	
	

	ArrayList<String> file_names_list = new ArrayList<>();
	ArrayList<JPanel> tabbed_panels = new ArrayList<>();
	
	public void load(JTabbedPane tabbedPane) throws IOException {
		
		
		//get the files in the Classes folder --> each txt file represents a class with student data inside
		FilenameFilter filter = new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".txt");
		    }
		};
		

		File folder = new File("storage/Classes");
		File[] listOfFiles = folder.listFiles(filter);

		
		for (int i = 0; i < listOfFiles.length; i++) {
			
			File file = listOfFiles[i];
			
			//to avoid re-adding an already-existing file to the tabbed pane
			if (!contains_str(file_names_list, file.getName())) {
				@SuppressWarnings("deprecation")
			    JPanel panel = new JPanel();
			    panel.setLayout(new BorderLayout());
			    
			    //set up the tabbed panel here + loop over names in content
			    
			    List<String> lst = Files.readAllLines(Paths.get("storage/Classes/" + file.getName()));
			    System.out.println(lst);
			    String[] str = new String[lst.size()];
			    
			    JList<String> list = new JList<>(lst.toArray(str));
			    
			    //add the names of students to the panel view
			    panel.add(list, BorderLayout.CENTER);
			    tabbed_panels.add(panel);
			    
			    tabbedPane.addTab(file.getName().substring(0, file.getName().length()-4), panel);
			    file_names_list.add(file.getName());
			    
			    
			}else {
				
			}
		   
		}
		
	}
	
	public ClassManager() throws IOException {
		initialize();
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private void initialize() throws IOException {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane.setBounds(6, 82, 558, 385);
		frame.getContentPane().add(tabbedPane);
		
		
		
		
		load(tabbedPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(562, 95, 81, 34);
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
						System.out.println("kkkj");
						//reload the pane after adding a new file --> this approach instead of adding straight to the interface here
						load(tabbedPane);
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
		
		JLabel lblYouClasses = new JLabel("Your Classes:");
		lblYouClasses.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblYouClasses.setBounds(16, 31, 139, 39);
		frame.getContentPane().add(lblYouClasses);
		frame.setLocationRelativeTo(null);
	}
}
