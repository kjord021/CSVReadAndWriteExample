
public class Main {

	public static void main(String[] args) {
		
		String fileLocation = (System.getProperty("user.dir") + "/" + "myFile0.csv");
		
		CSVReader reader = new CSVReader();
		reader.ReadFile(fileLocation);
		
		CSVWriter writer = new CSVWriter(reader.getEnrollees());
		writer.writeIndividualFiles();
		
	}

}
