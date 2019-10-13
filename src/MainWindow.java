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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class MainWindow {

	private JFrame frmHarknessDiscussion;
	private Point[] points = new Point[20];

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
		
		points[0]=new Point(400,0,true);
		points[1]=new Point(400,395,true);
		points[2]=new Point(0,200,true);
		points[3]=new Point(795,200,true);
		points[4]=new Point(600,25,true);
		points[5]=new Point(600,375,true);//
		points[6]=new Point(200,25,true);
		points[7]=new Point(200,375,true);
		points[8]=new Point(700,70,true);
		points[9]=new Point(700,330,true);
		points[10]=new Point(100,70,true);
		points[11]=new Point(100,330,true);
		points[12]=new Point(500,5,true);
		points[13]=new Point(500,395,true);
		points[14]=new Point(300,5,true);
		points[15]=new Point(300,395,true);
		points[16]=new Point(30,125,true);
		points[17]=new Point(770,125,true);
		points[18]=new Point(770,275,true);
		points[19]=new Point(30,275,true);
		
		Table table = new Table(10, false);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHarknessDiscussion = new JFrame();
		frmHarknessDiscussion.setResizable(false);
		frmHarknessDiscussion.setBackground(Color.LIGHT_GRAY);
		frmHarknessDiscussion.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHarknessDiscussion.getContentPane().setLayout(null);
		frmHarknessDiscussion.setLocationRelativeTo(null);
		
	
		Canvas canvas = new Canvas() {
			public void paint(Graphics g) {
				//g.drawImage(ImageIO.read(new File("img/table.jpg")), 0, 0, 800, 400,this);
				g.setColor(new Color(213,191,134));
				g.fillOval(0, 0, 800, 400);
				g.setColor(Color.BLACK);
				for(int i=0;i<20;i++) {
					if(points[i].used())
						g.fillOval(points[i].getX(),points[i].getY(),5,5);
				}
			}
		};
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX());
				System.out.println(e.getY());
			}
		});
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
