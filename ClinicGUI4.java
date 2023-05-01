
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class ClinicGUI4 extends JFrame {
	
	JLabel dr,n,id,start,r,rest;
	JPanel pane,pane1,pane2,toppan, botpan,botpan1,botpan2,rpan1,rpan2,rpan3,
	cenpanel,cenpanel1,cenpanel2,cenname,name1,cenid,i1,cenr,ro1,
	censtart,start1,cenrest,rest1;
	JButton back,clear,save;
	JTable d;
	JTextField n1,id1,startt1,r1,restt1;
	JFrame frame=new JFrame();
	JScrollPane scroll;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicGUI4 window = new ClinicGUI4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClinicGUI4() {
		initialize();
	}
			
	public void initialize() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Clinic App");
		frame.setSize(850,550);
		frame.setVisible(true);
		
		pane=new JPanel();
		pane.setLayout(new BorderLayout());
		
		toppan=new JPanel();
		toppan.setLayout(new FlowLayout(FlowLayout.CENTER));
		toppan.setBackground(Color.cyan);
		dr=new JLabel("Doctor Info");
		dr.setFont(new Font("MV Boli",Font.BOLD,20));
		toppan.add(dr);
		
		botpan=new JPanel();
		botpan.setLayout(new BorderLayout());
		botpan1=new JPanel();
		d=new JTable();
		scroll=new JScrollPane();
		d.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name", "ID", "Room", "Appointment Time","Rest Time"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class,String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scroll.setViewportView(d);
		botpan1.add(scroll);
		
		botpan2=new JPanel();
		botpan2.setLayout(new GridLayout(3,1));
		rpan1=new JPanel();
		rpan1.setLayout(new FlowLayout());
		clear=new JButton("Clear");
		rpan1.add(clear);
		rpan2=new JPanel();
		rpan2.setLayout(new FlowLayout());
		save=new JButton("Save");
		rpan2.add(save);
		rpan3=new JPanel();
		rpan3.setLayout(new FlowLayout());
		back=new JButton("Back");
		rpan3.add(back);
		botpan2.add(rpan2);
		botpan2.add(rpan3);
		botpan2.add(rpan1);
		botpan.add(botpan2,BorderLayout.EAST);
		
		pane.add(botpan1,BorderLayout.CENTER);
		
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
		
		cenr=new JPanel();
		cenr.setLayout(new GridLayout(1,2));
		ro1=new JPanel();
		ro1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		r=new JLabel("Room:");
		r1=new JTextField(10);
		ro1.add(r);
		cenr.add(ro1);
		cenr.add(r1);
		
		cenpanel1.add(cenname);
		cenpanel1.add(cenid);
		cenpanel1.add(cenr);
		
		cenpanel2=new JPanel();
		cenpanel2.setLayout(new FlowLayout());
		
		censtart=new JPanel();
		censtart.setLayout(new GridLayout(1,2));
		start1=new JPanel();
		start1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		start=new JLabel("Operation Time:");
		startt1=new JTextField(10);
		start1.add(start);
		censtart.add(start1);
		censtart.add(startt1);
		
		cenrest=new JPanel();
		cenrest.setLayout(new GridLayout(1,2));
		rest1=new JPanel();
		rest1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		rest=new JLabel("Rest Time:");
		restt1=new JTextField(10);
		rest1.add(rest);
		cenrest.add(rest1);
		cenrest.add(restt1);
		
		cenpanel2.add(censtart);
		cenpanel2.add(cenrest);
		
		cenpanel.add(cenpanel1);
		cenpanel.add(cenpanel2);
		
		pane1.add(cenpanel,BorderLayout.CENTER);
		
		pane2=new JPanel();
		pane2.setLayout(new GridLayout(2,1));
		pane2.add(pane);
		pane2.add(pane1);
		
		frame.add(toppan,BorderLayout.NORTH);
		frame.add(pane2,BorderLayout.CENTER);
		frame.add(botpan,BorderLayout.EAST);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==back) {
					frame.dispose();
					ClinicGUI2 c2=new ClinicGUI2();
				}
			}
			
		});
		
		clear.addActionListener(new ActionListener() {
			String name=n1.getText();
			String idno=id1.getText();
			String roomno=r1.getText();
			String starttime=startt1.getText();
			String resttime=restt1.getText();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				n1.setText("");
				id1.setText("");
				r1.setText("");
				startt1.setText("");
				restt1.setText("");
			}
			
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)d.getModel();
				model.addRow(new Object[] {n1.getText(), id1.getText(), r1.getText(), startt1.getText(), restt1.getText()
				});
				
				String filepath="DoctorList.txt";
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
					
					for(int i=0;i<d.getColumnCount();i++) {
						bw.write((String)d.getColumnName(i)+"  ");
					}
					bw.newLine();
					
					for(int j=0;j<d.getRowCount();j++) {
						for(int k=0;k<d.getColumnCount();k++) {
							bw.write((String)d.getModel().getValueAt(j, k)+", ");
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
