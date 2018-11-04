import java.io.*;

public class TxtRW {
	public static void main(String args[]) {
		try { 
 			
			// /* Overwrite Txt File */
			// File writename = new File(".data\\data.txt"); // if file doesn't exist create a new one
			// writename.createNewFile();
			// BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			// out.write("New content\r\n"); 
			// out.flush(); 
			// out.close(); 

			BufferedWriter out = null;
			try {
				String pathname = "data/data.txt";
				File filename = new File(pathname);
				out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename, true)));
				out.write("Appended content\r\n");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}


			/* read txt file */
			String pathname = "data/data.txt"; 
			File filename = new File(pathname); 
			InputStreamReader reader = new InputStreamReader(
			new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader); 
			String line = "";
			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine(); // read one line at a time
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}