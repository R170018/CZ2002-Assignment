/**
 * Application class of running the application
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class Application {
    /**
     * Main function of the application
     *
     * @param args any arguements to be added
     */
    public static void main(String args[]) {
        String dataFile = "data/data.txt";
        SchoolManager schoolManager = null;
        Object tempObject = FileIOManager.readObjectFromFile(dataFile);
        if (tempObject instanceof SchoolManager) {
            schoolManager = (SchoolManager) tempObject;
        }

        if (schoolManager == null) {
            schoolManager = new SchoolManager();
        }

        schoolManager.start();


        FileIOManager.writeObjectToFile(schoolManager, dataFile);
    }
}