
public class Application{
	/**
	 * Main function
	 */
	public static void main(String args[]){
		String dataFile = "data/data.txt";
		SchoolManager schoolManager = null;
		Object tempObject = FileIOManager.readObjectFromFile(dataFile);
		if(tempObject instanceof SchoolManager){
		 	schoolManager = (SchoolManager)tempObject;
		}

		if(schoolManager == null){
			schoolManager = new SchoolManager();
		}
		
		schoolManager.start();
		

		FileIOManager.writeObjectToFile(schoolManager, dataFile);
	}
}