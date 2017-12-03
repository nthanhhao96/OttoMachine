package OttoMachine;

public class User {
	private int userId;
	private String firstname;
	private String lastname;
	
	/**
	Constructs a customer with an id, first name, last name
	*/
	public User (int userId, String firstname, String lastname) {
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/**
	Gets the user id.
	@return the user id
	*/
	public int getUserId() {
		return userId;
	}

	/**
	Gets the user first name.
	@return the user first name
	*/
	public String getfirstname() {
		return firstname;
	}
	
	/**
	Gets the user last name.
	@return the user last name
	*/
	public String getlastname() {
		return lastname;
	}
}
