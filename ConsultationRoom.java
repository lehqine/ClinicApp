
public class ConsultationRoom implements Availability{
	private String roomnum;
	private int rid;
	private Patient patient;
	private boolean availability;
	
	public ConsultationRoom() {
		patient=null;
		availability=true;
	}
	
	public ConsultationRoom(Patient pat) {
		patient=pat;
		availability=false;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setID(int id) {
		rid=id;
		roomnum=Integer.toString(rid);
	}
	
	public String getroom() {
		return roomnum;
	}
	
	public String toString() {
		return "Room: "+roomnum;
	}

	@Override
	public boolean getAvailability() {
		if(patient==null) {
			return true;
		}
		else {
			return false;
		}
	}
}
