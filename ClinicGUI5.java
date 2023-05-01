
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class ClinicGUI5 extends JFrame{
	
	JPanel pane,top,bot,bot1,bot2,rpan1,rpan2,rpan3,pane1,toppan,top1,top2,top3,pane2;
	JLabel t,n,q,a;
	JTextField name,quan,avai;
	JButton clear,save,back;
	JTable med;
	JFrame frame=new JFrame();
	JScrollPane scroll;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicGUI5 window = new ClinicGUI5();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClinicGUI5() {
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
		
		top=new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBackground(Color.cyan);
		t=new JLabel("Medicine Info");
		t.setFont(new Font("MV Boli",Font.BOLD,20));
		top.add(t);
		
		bot=new JPanel();
		bot.setLayout(new BorderLayout());
		bot1=new JPanel();
		med=new JTable();
		scroll=new JScrollPane();
		med.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name", "Quantity","Availability"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scroll.setViewportView(med);
		bot1.add(scroll);
		
		bot2=new JPanel();
		bot2.setLayout(new GridLayout(3,1));
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
		bot2.add(rpan2);
		bot2.add(rpan3);
		bot2.add(rpan1);
		bot.add(bot2,BorderLayout.EAST);
		
		pane.add(bot1,BorderLayout.CENTER);
		
		pane1=new JPanel();
		pane1.setLayout(new BorderLayout());
		
		toppan=new JPanel();
		toppan.setLayout(new GridLayout(3,1));
		top1=new JPanel();
		top1.setLayout(new FlowLayout(FlowLayout.CENTER));
		n=new JLabel("Name:");
		name=new JTextField(15);
		top1.add(n);
		top1.add(name);
		
		top2=new JPanel();
		top2.setLayout(new FlowLayout(FlowLayout.CENTER));
		q=new JLabel("Quantity:");
		quan=new JTextField(15);
		top2.add(q);
		top2.add(quan);
		
		top3=new JPanel();
		top3.setLayout(new FlowLayout());
		a=new JLabel("Availability:");
		avai=new JTextField(15);
		top3.add(a);
		top3.add(avai);
		toppan.add(top1);
		toppan.add(top2);
		toppan.add(top3);
		
		pane1.add(toppan,BorderLayout.CENTER);
		
		pane2=new JPanel();
		pane2.setLayout(new GridLayout(2,1));
		pane2.add(pane);
		pane2.add(pane1);
		
		frame.add(top,BorderLayout.NORTH);
		frame.add(pane2,BorderLayout.CENTER);
		frame.add(bot,BorderLayout.EAST);
		
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
			String n=name.getText();
			String quantity=quan.getText();
			String availability=avai.getText();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				quan.setText("");
				avai.setText("");
			}
			
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)med.getModel();
				model.addRow(new Object[] {name.getText(), quan.getText(), avai.getText()
				});
				
				String filepath="Medicinelist.txt";
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
					
					for(int i=0;i<med.getColumnCount();i++) {
						bw.write((String)med.getColumnName(i)+"  ");
					}
					bw.newLine();
					
					for(int j=0;j<med.getRowCount();j++) {
						for(int k=0;k<med.getColumnCount();k++) {
							bw.write((String)med.getModel().getValueAt(j, k)+", ");
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
