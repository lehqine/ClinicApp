
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class ClinicGUI3 extends JFrame{
	
	JPanel info,pane,botpanel,botpanel1,botpanel2,rpanel1,rpanel2,rpanel3,
	pane1,cenpanel, cenpanel1,cenpanel2,botpan,cenname,name1,
	cenid,i1,cendi,dis1,cent,ti1,cenr,ro1,cenpr,pro1,cenme,med1,pane2;
	JButton save,back,clear;
	JTable pat;
	JLabel patinfo,n,id,di,t,r,pr,me;
	JTextField n1,id1,di1,t1,pr1,me1,r1;
	JFrame frame=new JFrame();
	JScrollPane scroll;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicGUI3 window = new ClinicGUI3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClinicGUI3() {
		initialize();
	}
	
	public void initialize() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Clinic App");
		frame.setSize(850,550);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		pane=new JPanel();
		pane.setLayout(new BorderLayout());
		
		info=new JPanel();
		info.setLayout(new FlowLayout(FlowLayout.CENTER));
		info.setBackground(Color.cyan);
		patinfo=new JLabel("Patient Info");
		patinfo.setFont(new Font("MV Boli",Font.BOLD,20));
		info.add(patinfo);
		
		botpanel=new JPanel();
		botpanel.setLayout(new BorderLayout());
		botpanel1=new JPanel();
		pat=new JTable();
		scroll=new JScrollPane();
		pat.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name", "ID", "Disease", "Time", "Room", "Problem","Medicine"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class,String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scroll.setViewportView(pat);
		botpanel1.add(scroll);
		
		botpanel2=new JPanel();
		botpanel2.setLayout(new GridLayout(3,1));
		rpanel1=new JPanel();
		rpanel1.setLayout(new FlowLayout());
		clear=new JButton("Clear");
		rpanel1.add(clear);
		rpanel2=new JPanel();
		rpanel2.setLayout(new FlowLayout());
		save=new JButton("Save");
		rpanel2.add(save);
		rpanel3=new JPanel();
		rpanel3.setLayout(new FlowLayout());
		back=new JButton("Back");
		rpanel3.add(back);
		botpanel2.add(rpanel2);
		botpanel2.add(rpanel3);
		botpanel2.add(rpanel1);
		botpanel.add(botpanel2,BorderLayout.EAST);
		
		pane.add(botpanel1,BorderLayout.CENTER);
		
		pane1=new JPanel();
		pane1.setLayout(new BorderLayout());
		
		cenpanel=new JPanel();
		cenpanel.setLayout(new GridLayout(1,2));
		cenpanel1=new JPanel();
		cenpanel1.setLayout(new FlowLayout());
		
		cenname=new JPanel();
		cenname.setLayout(new GridLayout(1,2));
		name1=new JPanel();
		name1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		n=new JLabel("Name:");
		n1=new JTextField(10);
		name1.add(n);
		cenname.add(name1);
		cenname.add(n1);
		
		cenid=new JPanel();
		cenid.setLayout(new GridLayout(1,2));
		i1=new JPanel();
		i1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		id=new JLabel("ID:");
		id1=new JTextField(10);
		i1.add(id);
		cenid.add(i1);
		cenid.add(id1);
		
		cendi=new JPanel();
		cendi.setLayout(new GridLayout(1,2));
		dis1=new JPanel();
		dis1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		di=new JLabel("Disease:");
		di1=new JTextField(10);
		dis1.add(di);
		cendi.add(dis1);
		cendi.add(di1);
		
		cent=new JPanel();
		cent.setLayout(new GridLayout(1,2));
		ti1=new JPanel();
		ti1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		t=new JLabel("Time:");
		t1=new JTextField(10);
		ti1.add(t);
		cent.add(ti1);
		cent.add(t1);
		cenpanel1.add(cenname);
		cenpanel1.add(cenid);
		cenpanel1.add(cendi);
		cenpanel1.add(cent);
		
		cenpanel2=new JPanel();
		cenpanel2.setLayout(new FlowLayout());
		cenr=new JPanel();
		cenr.setLayout(new GridLayout(1,2));
		ro1=new JPanel();
		ro1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		r=new JLabel("Room:");
		r1=new JTextField(10);
		ro1.add(r);
		cenr.add(ro1);
		cenr.add(r1);
		
		cenpr=new JPanel();
		cenpr.setLayout(new GridLayout(1,2));
		pro1=new JPanel();
		pro1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pr=new JLabel("Problem:");
		pr1=new JTextField(10);
		pro1.add(pr);
		cenpr.add(pro1);
		cenpr.add(pr1);
		
		cenme=new JPanel();
		cenme.setLayout(new GridLayout(1,2));
		med1=new JPanel();
		med1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		me=new JLabel("Medicine:");
		me1=new JTextField(10);
		med1.add(me);
		cenme.add(med1);
		cenme.add(me1);
		cenpanel2.add(cenr);
		cenpanel2.add(cenpr);
		cenpanel2.add(cenme);
		
		cenpanel.add(cenpanel1);
		cenpanel.add(cenpanel2);
		
		pane1.add(cenpanel,BorderLayout.CENTER);
		
		pane2=new JPanel();
		pane2.setLayout(new GridLayout(2,1));
		pane2.add(pane);
		pane2.add(pane1);
		
		frame.add(info,BorderLayout.NORTH);
		frame.add(pane2,BorderLayout.CENTER);
		frame.add(botpanel,BorderLayout.EAST);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ClinicGUI2 c2=new ClinicGUI2();
			}
			
		});
		
		clear.addActionListener(new ActionListener() {
			String name=n1.getText();
			String idno=id1.getText();
			String disease=di1.getText();
			String time=t1.getText();
			String problem=pr1.getText();
			String medicine=me1.getText();
			String roomno=r1.getText();
			@Override
			public void actionPerformed(ActionEvent e) {
				n1.setText("");
				id1.setText("");
				di1.setText("");
				t1.setText("");
				pr1.setText("");
				me1.setText("");
				r1.setText("");
			}
			
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)pat.getModel();
				model.addRow(new Object[] {n1.getText(), id1.getText(), di1.getText(), t1.getText(), r1.getText(), pr1.getText(),me1.getText()
				});
				
				String filepath="PatientList.txt";
				File file=new File(filepath);
				
				if(!file.exists()) {
					try {
						file.createNewFile();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
				try {
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw=new BufferedWriter(fw);
					
					for(int i=0;i<pat.getColumnCount();i++) {
						bw.write((String)pat.getColumnName(i)+"  ");
					}
					bw.newLine();
					
					for(int j=0;j<pat.getRowCount();j++) {
						for(int k=0;k<pat.getColumnCount();k++) {
							bw.write((String)pat.getModel().getValueAt(j, k)+", ");
						}
						bw.newLine();
					}
					bw.close();
					fw.close();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Save Successfully!","Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}

}
