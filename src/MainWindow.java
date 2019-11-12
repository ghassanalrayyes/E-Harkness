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
	 * @throws IOException 
	 */
	public MainWindow() throws IOException {
	
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
		points[12]=new Point(700,325,false);
		points[13]=new Point(600,370,false);
		points[14]=new Point(500,390,false);
		points[15]=new Point(400,390,false);
		points[16]=new Point(300,390,false);
		points[17]=new Point(200,370,false);
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
						g.fillOval(points[i].getX(),points[i].getY(),10,10);
						
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
		
		JLabel p1 = new JLabel("");
		p1.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p1.setBounds(152, 295, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p1);
		
		JLabel p2 = new JLabel("");
		p2.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p2.setBounds(180, 183, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p2);
		
		JLabel p3 = new JLabel("");
		p3.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p3.setBounds(275, 100, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p3);
		
		JLabel p4 = new JLabel("");
		p4.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p4.setBounds(367, 65, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p4);
		
		JLabel p5 = new JLabel("");
		p5.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p5.setBounds(460, 45, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p5);
		
		JLabel p6 = new JLabel("");
		p6.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p6.setBounds(738, 45, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p6);
		
		JLabel p7 = new JLabel("");
		p7.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p7.setBounds(831, 65, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p7);
		
		JLabel p8 = new JLabel("");
		p8.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p8.setBounds(923, 100, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p8);
		
		JLabel p9 = new JLabel("");
		p9.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p9.setBounds(1018, 183, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p9);
		
		JLabel p10 = new JLabel("");
		p10.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p10.setBounds(1046, 295, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p10);
		
		JLabel p11 = new JLabel("");
		p11.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p11.setBounds(1018, 407, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p11);
		
		JLabel p12 = new JLabel("");
		p12.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p12.setBounds(923, 490, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p12);
		
		JLabel p13 = new JLabel("");
		p13.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p13.setBounds(831, 525, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p13);
		
		JLabel p14 = new JLabel("");
		p14.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p14.setBounds(738, 545, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p14);
		
		JLabel p17 = new JLabel("");
		p17.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p17.setBounds(460, 545, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p17);
		
		JLabel p18 = new JLabel("");
		p18.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p18.setBounds(367, 525, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p18);
		
		JLabel p19 = new JLabel("");
		p19.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p19.setBounds(275, 490, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p19);
		
		JLabel p20 = new JLabel("");
		p20.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		p20.setBounds(180, 407, 82, 100);
		frmHarknessDiscussion.getContentPane().add(p20);
		canvas.setBounds(240, 145, 800, 400);
		frmHarknessDiscussion.getContentPane().add(canvas);
		
		JLabel kengs = new JLabel("");
		kengs.setIcon(new ImageIcon("img/logo.png"));
		kengs.setBounds(1042, 6, 232, 210);
		frmHarknessDiscussion.getContentPane().add(kengs);
		
		sID = new JTextField();
		sID.setText("Student ID");
		sID.setBounds(6, 6, 213, 26);
		frmHarknessDiscussion.getContentPane().add(sID);
		sID.setColumns(10);
		
		sP = new JTextField();
		sP.setText("Position");
		sP.setBounds(6, 31, 213, 26);
		frmHarknessDiscussion.getContentPane().add(sP);
		sP.setColumns(10);
		
		JButton addM = new JButton("Add");
		addM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.addMember(table.getMember(sID.getText()),Integer.parseInt(sP.getText())-1);
				
				//you forgot to enable the point
				points[Integer.parseInt(sP.getText())-1].draw = true;
				sChart=table.getSeatingChart();
				canvas.repaint();
			}
		});
		addM.setBounds(217, 6, 53, 51);
		frmHarknessDiscussion.getContentPane().add(addM);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		label.setBounds(599, 551, 82, 100);
		frmHarknessDiscussion.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/Users/adnanjabri/git/E-Harkness/img/test.jpg"));
		label_1.setBounds(599, 39, 82, 100);
		frmHarknessDiscussion.getContentPane().add(label_1);
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