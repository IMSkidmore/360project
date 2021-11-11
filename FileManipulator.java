package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManipulator {
	public FileManipulator() {

	}

	public void writeFileContents(String fileName, ArrayList<String >array) throws IOException {
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
}
