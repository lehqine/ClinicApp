
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ClinicGUI extends JFrame{
	
	JPanel wlc,botpanel,pane;
	JButton start;
	JLabel title;
	JFrame frame;
	
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
	
	public ClinicGUI() {
		initialize();
	}
	
	public void initialize() {
		
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Clinic App");
		frame.setSize(350, 200);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		wlc=new JPanel();
		wlc.setLayout(new FlowLayout(FlowLayout.CENTER));
		wlc.setBackground(Color.cyan);
		title=new JLabel("Welcome to Clinic :)");
		title.setFont(new Font("MV Boli",Font.BOLD,15));
		wlc.add(title);
		
		botpanel=new JPanel();
		botpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		start=new JButton("Start");
		botpanel.add(start);
		
		frame.add(wlc,BorderLayout.NORTH);
		frame.add(botpanel);
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ClinicGUI2 c3=new ClinicGUI2();
			}
			
		});
	}

}
