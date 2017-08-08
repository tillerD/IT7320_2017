package version1;

public class PersonInfo {
	private String firstName;
	private String lastName;
	private String id;
	
	public PersonInfo()
	{
		firstName = null;
		lastName = null;
		id = null;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
