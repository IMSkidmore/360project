package application;

import java.io.*;
import java.util.ArrayList;

public class FileManipulator {
	public FileManipulator() {

	}

	public void writeFileContents(String fileName, ArrayList<String> array) throws IOException {
		File file = new File("src/application/" + fileName + ".txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		FileWriter filewrite;
		try {
			filewrite = new FileWriter("src/application/" + fileName + ".txt", true);

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

	public ArrayList<String> readFileContents(String fileName) throws IOException {
		File fi = new File("src/application" + fileName + ".txt");

		BufferedReader br = new BufferedReader(new FileReader(fi));

		ArrayList<String> fileContents = new ArrayList<String>();
		String st;
		while ((st = br.readLine()) != null)
			fileContents.add(st);
		return fileContents;
	}

	public ArrayList<String[]> readFilePatientHistory(String id) throws IOException {

		File fi = new File("src/application/" + id + ".txt");
		BufferedReader br = new BufferedReader(new FileReader(fi));

		ArrayList<String[]> fileContents = new ArrayList<String[]>();
		String st;
		while ((st = br.readLine()) != null)
			fileContents.add(Parser.lineToHistoryArray(st));
		return fileContents;
	}

	public ArrayList<Patient> readFilePatientInfo() throws IOException {
		ArrayList<Patient> fromFile = new ArrayList<Patient>();
		File fi = new File("src/application/PatientInfo.txt");

		BufferedReader br = new BufferedReader(new FileReader(fi));
		String st;
		while ((st = br.readLine()) != null)
			fromFile.add(Parser.lineToPatient(st));
		return fromFile;
	}

	public void writeFileContentsPatientInfo(ArrayList<String> array) throws IOException {
		File file = new File("src/application/PatientInfo.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		FileWriter filewrite;
		try {
			filewrite = new FileWriter("src/application/PatientInfo.txt", true);
			// Initialing BufferedWriter
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);

			int i = 0;
			for (String s : array) {
				if (i >= 11) {
					bufferwrite.write(s);
				} else if (i < 11) {
					bufferwrite.write(s + ",");
				}
				i++;
			}
			bufferwrite.newLine();

			bufferwrite.close();
		} catch (IOException excpt) {
			excpt.printStackTrace();
		}
	}
	public String[] readFileContentsVitals(String fileName) throws IOException {
		File fi = new File("src/application/" + fileName + "Vitals.txt");

		BufferedReader input = new BufferedReader(new FileReader(fi));
	    String last=""; 
	    String line;

	    while ((line = input.readLine()) != null) { 
	        last = line;
	    }
		String[] fromFile = last.split(",");
		fi.delete();
		return fromFile;
	}

	public void writeFileContentsVitals(String fileName, ArrayList<String> array) throws IOException {
		File file = new File("src/application/" + fileName + "Vitals.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		FileWriter filewrite;
		try {
			filewrite = new FileWriter("src/application/" + fileName + ".txt", true);
			// Initialing BufferedWriter
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);

			int i = 0;
			for (String s : array) {
				if (i >= 5) {
					bufferwrite.write(s);
				} else if (i < 5) {
					bufferwrite.write(s + ",");
				}
				i++;
			}
			bufferwrite.newLine();

			bufferwrite.close();
		} catch (IOException excpt) {
			excpt.printStackTrace();
		}
	}

	public void writeFileContentsExam(String fileName, ArrayList<String> array) throws IOException {
		String[] vitals = readFileContentsVitals(fileName);
		for(String s: vitals) {
			array.add(s);
		}
		File file = new File("src/application/" + fileName + ".txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		FileWriter filewrite;
		try {
			filewrite = new FileWriter("src/application/" + fileName + ".txt", true);
			// Initialing BufferedWriter
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);

			int i = 0;
			for (String s : array) {
				if (i >= 11) {
					bufferwrite.write(s);
				} else if (i < 11) {
					bufferwrite.write(s + ",");
				}
				i++;
			}
			bufferwrite.newLine();

			bufferwrite.close();
		} catch (IOException excpt) {
			excpt.printStackTrace();
		}
	}

}
