package application;

import java.io.*;
import java.util.ArrayList;

public class FileManipulator {
	public FileManipulator() {

	}

	public void writeFileContents(String fileName, ArrayList<String> array) throws IOException {
		FileWriter filewrite;
		try {
			filewrite = new FileWriter(fileName, true);

			// Initialing BufferedWriter
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);

			for (String s : array) {
				bufferwrite.write(s);
				bufferwrite.newLine();
			}

			bufferwrite.close();
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
	
	public ArrayList<Patient> readFilePatientInfo() throws IOException{
		 ArrayList<Patient> fromFile = new ArrayList<Patient>();
		 File fi = new File("src/application/PatientInfo.txt"); 
		 
		 BufferedReader br = new BufferedReader(new FileReader(fi)); 
		 		 String st;
		 while ((st = br.readLine()) != null) 
			 fromFile.add(Parser.lineToPatient(st));
		return fromFile;
	}
	
	public ArrayList<String[]> readFilePatientHistory(String id) throws IOException{
		 File fi = new File("src/application/" + id + ".txt"); 
		 
		 BufferedReader br = new BufferedReader(new FileReader(fi)); 
		 
		 ArrayList<String[]> fileContents = new ArrayList<String[]>();
		 String st;
		 while ((st = br.readLine()) != null) 
			 fileContents.add(Parser.lineToHistoryArray(st));
		return fileContents;
	}
	
}
