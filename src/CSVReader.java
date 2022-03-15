import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	private ArrayList<Enrollee> enrollees = new ArrayList<Enrollee>();
	private BufferedReader br;
	
	//This function Reads the file and sets the corresponding enrollees
	public void ReadFile(String fileLocation) {
		
		String line = "";
		String delimiter = ",";
		
		try {
			
			//Create a buffered reader to read the file at the location
			br = new BufferedReader(new FileReader(fileLocation));
			
			//While the line is not null continue to read the file
			while ((line = br.readLine()) != null) {
				
				//Assign the current line to an array of Strings
				String[] currentEnrollee = line.split(delimiter);
				
				//If the enrollees size is greater then 0 we need to make sure there are no duplicated values
				if (enrollees.size() > 0) {
					//Check for a duplicated entry
					if (checkForDuplicateEntry(currentEnrollee)) {
						updateExistingEnrollee(currentEnrollee);
					}
					else {
						createNewEnrollee(currentEnrollee);
					}
				}
				else {
					createNewEnrollee(currentEnrollee);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//This function loops the current enrollees to see if a duplicate entry has been entered
	public boolean checkForDuplicateEntry(String[] currentEnrollee) {
		for (Enrollee e : enrollees) {
			if (e.getUserID().equalsIgnoreCase(currentEnrollee[0])) {
				return true;
			}
		}
		return false;
	}
	
	//This function creates a new enrollee and adds it to the array list
	public void createNewEnrollee(String[] currentEnrollee) {
		Enrollee enrollee = new Enrollee(currentEnrollee[0], currentEnrollee[1], currentEnrollee[2], Integer.parseInt(currentEnrollee[3]), currentEnrollee[4]);
		enrollees.add(enrollee);
	}
	
	//This function updates an existing enrollee if the version number is higher
	public void updateExistingEnrollee (String[] currentEnrollee) {
		
		String firstName = currentEnrollee[1];
		String lastName = currentEnrollee[2];
		int newVersion = Integer.parseInt(currentEnrollee[3]);
		String insuranceCompany = currentEnrollee[4];
		
		for (Enrollee e : enrollees) {
			if (e.getUserID() == currentEnrollee[0]) {
				if (e.getVersion() < newVersion) {
					e.setFirstName(firstName);
					e.setLastName(lastName);
					e.setVersion(newVersion);
					e.setInsuranceCompany(insuranceCompany);
				}
			}
		}
	}
	
	//Getter for enrollee
	public ArrayList<Enrollee> getEnrollees() {
		return enrollees;
	}
	
}
