package application;

import java.io.*;
import java.util.ArrayList;

public class FileManipulator {
	public FileManipulator() {

	}

	public void writeFileContents(String fileName, ArrayList<String> array) throws IOException {
		FileWriter filewrite;
		try {
			filewrite = new FileWriter(fileName);

			// Initialing BufferedWriter
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);

			for (String s : array) {
				bufferwrite.write(s);
				bufferwrite.newLine();
			}

			bufferwrite.close();
			System.out.println("Written successfully");
		} catch (IOException excpt) {
			excpt.printStackTrace();
		}
	}

	public ArrayList<String> readFileContents(String fileName) throws IOException{
		 File fi = new File(fileName); 
		 
		 BufferedReader br = new BufferedReader(new FileReader(fi)); 
		 
		 ArrayList<String> fileContents = new ArrayList<String>();
		 String st;
		 while ((st = br.readLine()) != null) 
			 fileContents.add(st);
		return fileContents;
	}
}
