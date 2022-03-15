
public class Enrollee {
	
	//A Model For An Enrollee
	
	//Private member fields
	private String userID;
	private String firstName;
	private String lastName;
	private int version;
	private String insuranceCompany;
	
	//Constructor
	public Enrollee (String userID, String firstName, String lastName, int version, String insuranceCompany) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.version = version;
		this.insuranceCompany = insuranceCompany;
	}
	
	//Getters and Setters
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return userID + "," + firstName + "," + lastName + ","
				+ version + "," + insuranceCompany;
	}
}
