
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ClinicGUI2 extends JFrame{
	
	JPanel pane,toppanel, cenpanel,botpanel;
	JLabel page;
	JButton patient,doctor,medi,exit;
	JFrame frame=new JFrame();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicGUI window = new ClinicGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClinicGUI2() {
		initialize();
	}
	
	public void initialize() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Clinic App");
		frame.setSize(350, 250);
		frame.setVisible(true);
		
		pane=new JPanel();
		pane.setLayout(new BorderLayout());
		
		toppanel=new JPanel();
		toppanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		toppanel.setBackground(Color.cyan);
		page=new JLabel("Information Page");
		page.setFont(new Font("MV Boli",Font.BOLD,20));
		toppanel.add(page);
		
		cenpanel=new JPanel();
		cenpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		patient=new JButton("Patient");
		doctor=new JButton("Doctor");
		medi=new JButton("Medicine");
		cenpanel.add(patient);
		cenpanel.add(doctor);
		cenpanel.add(medi);
		
		botpanel=new JPanel();
		botpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		exit=new JButton("Exit");
		botpanel.add(exit);
		
		pane.add(toppanel,BorderLayout.NORTH);
		pane.add(cenpanel,BorderLayout.CENTER);
		pane.add(botpanel,BorderLayout.SOUTH);
		
		frame.add(pane);
		
		patient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==patient) {
					frame.dispose();
					ClinicGUI3 page=new ClinicGUI3();
				}
			}
			
		});
		
		doctor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==doctor) {
					frame.dispose();
					ClinicGUI4 page=new ClinicGUI4();
				}
			}
			
		});
		
		medi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==medi) {
					frame.dispose();
					ClinicGUI5 page=new ClinicGUI5();
				}
			}
			
		});
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==exit) {
					frame.dispose();
				}
			}
			
		});
	}
}
