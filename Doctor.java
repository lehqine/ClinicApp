
public class Doctor extends Person implements Availability{
	boolean available;
	private Patient patient=null;
	
	public Doctor(String n,String id,String rl) {
		super(n,id,rl);
		available=false;
	}
	
	public Doctor(String n,String id,String rl,Patient pat) {
		super(n,id,rl);
		patient=pat;
		available=false;
	}
	
	public void setpatient(Patient pat) {
		patient=pat;
	}
	
	public Patient getpatient() {
		return patient;
	}
	
	public String toString() {
		return super.toString();
	}

	public boolean getAvailability() {
		if(patient==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
