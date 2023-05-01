
import java.util.*;
import java.io.*;

public class ClinicApp {

	public static void main(String[] args){
		
		int sum=0;
		
		try {
			Scanner f1=new Scanner(new File("PatientList.txt"));
			Scanner f2=new Scanner(new File("DoctorList.txt"));
			Scanner f3=new Scanner(new File("Medicinelist.txt"));
			FileWriter fw=new FileWriter("output.txt");
			PrintWriter pw=new PrintWriter(fw);
			
			while(f1.hasNext()&&f2.hasNext()&&f3.hasNext()) {
				if(sum==0) {
					String waste1=f1.nextLine();
					String waste2=f2.nextLine();
					String waste3=f3.nextLine();
				}
				
				String info1=f1.nextLine().trim();
				String [] str1=info1.split(",");
				String patname=str1[0];
				String patid=str1[1];
				String disease=str1[2];
				String time=str1[3];
				String room=str1[4];
				String problem=str1[5];
				
				String info2=f2.nextLine().trim();
				String [] str2=info2.split(",");
				String drname=str2[0];
				String drid=str2[1];
				String r=str2[2];
				String appointime=str2[3];
				String resttime=str2[4];
				
				String info3=f3.nextLine().trim();
				String [] str3=info3.split(",");
				String medicine=str3[0];
				String quantity=str3[1];
				String avai=str3[2];
				
				pw.println("Room "+room);
				pw.println("Doctor's name: "+drname);
				pw.println("Dortor's ID: "+drid);
				pw.println("Room doctor: "+r);
				pw.println("Appointment Time: "+appointime);
				pw.println("Rest time: "+resttime);
				pw.println("Patient's name: "+patname);
				pw.println("Patient's ID: "+patid);
				pw.println("Time: "+time);
				pw.println("Disease: "+disease);
				pw.println("Health problem: "+problem);
				pw.println("Medicine: "+medicine);
				pw.println("Quantity: "+quantity);
				pw.println("Availability: "+avai);
				pw.println();
				
				sum++;
				
			}
			pw.close();
			System.out.println("Output file complete.");
		}catch(IOException e) {
			System.out.println("An error occured.");
		}
		
	}

}
