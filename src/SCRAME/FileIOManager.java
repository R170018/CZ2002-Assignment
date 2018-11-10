import java.io.*;

public class FileIOManager{
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