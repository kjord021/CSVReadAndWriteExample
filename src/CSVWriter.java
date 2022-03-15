import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CSVWriter {

	private ArrayList<Enrollee> enrollees = new ArrayList<Enrollee>();
	
	public CSVWriter(ArrayList<Enrollee> enrollees) {
		this.enrollees = enrollees;
	}
	
	//This function creates a file for each corresponding company and writes all the information in it
	public void writeIndividualFiles() {
		
		//Get unique insurance companies
		ArrayList<String> namesOfCompanies = getUniqueInsuranceCompanies();
		
		//Alphabetize enrollees
		sortEnrollees(enrollees);
		
		//Loop the company names
		for (String companyName : namesOfCompanies) {
			
			//Create the new file with the company name
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/" + companyName + ".csv"))) {
		    	
		    	//Loop the enrollees
		    	for (Enrollee e : enrollees) {
		    		//If company name matches enrollees company name print to file
		    		if (e.getInsuranceCompany().equalsIgnoreCase(companyName)) {
		    			writer.write(e.toString());
		    			writer.newLine();
		    		}
		    	}
		    	
		      } catch (FileNotFoundException e) {
		        System.out.println(e.getMessage());	
		      } catch (IOException e) {
				e.printStackTrace();
			}

	    }
			
	}
	
	public static void sortEnrollees(ArrayList<Enrollee> enrollees) {
		Collections.sort(enrollees, new Comparator<Enrollee>() {
		       public int compare(Enrollee e1, Enrollee e2) {
		            int res =  e1.getLastName().compareToIgnoreCase(e2.getLastName());
		            if (res != 0)
		                return res;
		            return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
		       }
		   });
	}
	
	//This function gets the name of every unique insurance company
	public ArrayList<String> getUniqueInsuranceCompanies() {
		ArrayList<String> namesOfCompanies = new ArrayList<String>();
		
		for (Enrollee e : enrollees) {
			namesOfCompanies.add(e.getInsuranceCompany());
		}

		ArrayList<String> finalList = new ArrayList<String>();
		  
        for (String s : namesOfCompanies) {
            if (!finalList.contains(s)) {
                finalList.add(s);
            }
        }
		
		return finalList;
	}
	
}
