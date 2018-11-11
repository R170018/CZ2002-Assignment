import java.io.*;
/**
 * This class manages all functionalities 
 * related to file input and output.
 */
public class FileIOManager{
	/**
	 * This function reads in an object from a given file.
	 * @param fileName the path of the file
	 * @return object read from the file
	 */
	public static Object readObjectFromFile(String fileName){
		try{
			File file = new File(fileName);
			if(!file.exists()){
				return null;
			}
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			return in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This function writes an object to a given file.
	 * @param object the object to write
	 * @param fileName the path of the file
	 */
	public static void writeObjectToFile(Object object, String fileName){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(object);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}