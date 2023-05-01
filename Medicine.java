
public class Medicine implements Availability{
	
	private String medi;
	private boolean available;
	
	@Override
	public boolean getAvailability() {
		return false;
	}

}
