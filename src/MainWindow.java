import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Canvas;

public class MainWindow {

	private JFrame frmHarknessDiscussion;
	private ArrayList<Point> points = new ArrayList<Point>();

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
		
		Table table = new Table(10);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHarknessDiscussion = new JFrame();
		frmHarknessDiscussion.setBackground(Color.LIGHT_GRAY);
		frmHarknessDiscussion.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHarknessDiscussion.getContentPane().setLayout(null);
		
	
		Canvas canvas = new Canvas() {
			public void paint(Graphics g) {
				//g.drawImage(ImageIO.read(new File("img/table.jpg")), 0, 0, 800, 400,this);
				g.setColor(new Color(213,191,134));
				g.fillOval(0, 0, 800, 400);
				g.setColor(Color.BLACK);
				g.fillOval(100, 100, 100,100);
			}
		};
		canvas.setBounds(240, 145, 800, 400);
		frmHarknessDiscussion.getContentPane().add(canvas);
		frmHarknessDiscussion.setTitle("Harkness Discussion");
		frmHarknessDiscussion.setBounds(100, 100, 1280, 720);
		frmHarknessDiscussion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		JLabel table = new JLabel("");
		table.setIcon(new ImageIcon("img/table.jpg"));
		table.setBounds(240, 145, 800, 400);
		frmHarknessDiscussion.getContentPane().add(table);*/
	}
	
}
