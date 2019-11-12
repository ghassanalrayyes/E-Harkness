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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {
//kkkhuhh
	private JFrame frmHarknessDiscussion;
	private Point[] points = new Point[20];
	private JTextField sID;
	private JTextField sP;
	private Table table;
	private Member[] sChart=new Member[20];
	
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
	
		table = new Table(10, false);
		sChart=table.getSeatingChart();
		
		points[0]=new Point(0,200,false);
		points[1]=new Point(30,125,false);
		points[2]=new Point(100,70,false);
		points[3]=new Point(200,25,false);
		points[4]=new Point(300,5,false);
		points[5]=new Point(400,0,false);
		points[6]=new Point(500,5,false);
		points[7]=new Point(600,25,false);
		points[8]=new Point(700,70,false);
		points[9]=new Point(770,125,false);
		points[10]=new Point(795,200,false);
		points[11]=new Point(770,275,false);
		points[12]=new Point(700,330,false);
		points[13]=new Point(600,375,false);
		points[14]=new Point(500,395,false);
		points[15]=new Point(400,395,false);
		points[16]=new Point(300,395,false);
		points[17]=new Point(200,375,false);
		points[18]=new Point(100,330,false);
		points[19]=new Point(30,275,false);
		
		for(int i=0;i<points.length;i++) {
			if(sChart[i]!=null) {
				points[i].setUse(true);
			}
		}
		
		initialize();
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
				g.setColor(new Color(213,191,134));
				g.fillOval(0, 0, 800, 400);
				g.setColor(Color.BLACK);
				for(int i=0;i<20;i++) {
					if(points[i].used()) {
						g.fillOval(points[i].getX(),points[i].getY(),5,5);
						
					}
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/logo.png"));
		lblNewLabel.setBounds(-12, 6, 232, 210);
		frmHarknessDiscussion.getContentPane().add(lblNewLabel);
		
		sID = new JTextField();
		sID.setText("Student ID");
		sID.setBounds(232, 6, 213, 26);
		frmHarknessDiscussion.getContentPane().add(sID);
		sID.setColumns(10);
		
		sP = new JTextField();
		sP.setText("Position");
		sP.setBounds(232, 37, 213, 26);
		frmHarknessDiscussion.getContentPane().add(sP);
		sP.setColumns(10);
		
		JButton addM = new JButton("Add");
		addM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.addMember(table.getMember(sID.getText()),Integer.parseInt(sP.getText())-1);
				sChart=table.getSeatingChart();
				canvas.repaint();
			}
		});
		addM.setBounds(449, 6, 53, 57);
		frmHarknessDiscussion.getContentPane().add(addM);
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