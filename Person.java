
public class Person {
	private String name,ID,role;
	
	public Person(String n,String id,String rl) {
		name=n;
		ID=id;
		role=rl;
	}
	
	public String getName() {
		return name;
	}
	
	public String getID() {
		return ID;
	}
	
	public String toString() {
		return "Name: "+name+"\nID: "+ID+"\nRole: "+role;
	}
}
