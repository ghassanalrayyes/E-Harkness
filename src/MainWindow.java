import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainWindow {

	private JFrame frmHarknessDiscussion;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmHarknessDiscussion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		
		Table table = new Table();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHarknessDiscussion = new JFrame();
		frmHarknessDiscussion.setBackground(Color.LIGHT_GRAY);
		frmHarknessDiscussion.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHarknessDiscussion.getContentPane().setLayout(null);
		
		JLabel table = new JLabel("");
		table.setIcon(new ImageIcon("img/table.jpg"));
		table.setBounds(240, 145, 800, 400);
		frmHarknessDiscussion.getContentPane().add(table);
		frmHarknessDiscussion.setResizable(false);
		frmHarknessDiscussion.setTitle("Harkness Discussion");
		frmHarknessDiscussion.setBounds(100, 100, 1280, 720);
		frmHarknessDiscussion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
