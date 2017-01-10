package aWriteReadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		// instantiate our class
		ReadFile rf = new ReadFile();
		// file - represents file, but haven't file content inside - just path
		File file = new File("Strings");

		rf.readFile(file);
		rf.readFileScanner(file);

	}

	public void readFile(File file) {
		try {
			// knows how to connect to the file and read it
			FileReader fr = new FileReader(file);
			// wrap fileReader with buffererdReader to read whole file at once
			// not 1 line on call
			BufferedReader br = new BufferedReader(fr);
			String line;

			// readLine() reads line from file and increments next line counter
			// by 1 so next readLine() will read next line
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFileScanner(File file) {
		try {
			// instantiate scanner with our file
			Scanner scan = new Scanner(file);

			// check if it is not the end of the file
			while (scan.hasNextLine()) {
				// nextLine() reads next line from file and increments next line
				// counter by 1 so next nextLine() will read next line
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
