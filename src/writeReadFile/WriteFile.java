package writeReadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		// instantiate our class
		WriteFile wf = new WriteFile();
		String s1 = "First string";
		String s2 = "Second string";
		String s3 = "Third string";
		// file - represents file, but haven't file content inside - just path
		File file = new File("Strings");
		wf.writeFile(file, s1, s2, s3);
		wf.writeRewriteFile(file, true, s1, s2, s3);
		wf.writeRewriteFile(file, true, s1, s2, s3);

	}

	public void writeFile(File file, String... args) {
		try {
			// knows how to connect to the file and write it
			FileWriter fw = new FileWriter(file);
			// wrap fileWriter with buffwredFileWriter
			// because fileWriter calls file and writes it on every string
			// but buffered - puts all strings to buffer and calls\writes only
			// one time before close
			BufferedWriter bw = new BufferedWriter(fw);

			for (String string : args) {
				// write string to buffer
				bw.write(string + "\n");
			}
			// write string to buffer
			bw.write("----------------------------\n");
			// write all string from buffer to file and close bufferedWriter
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeRewriteFile(File file, Boolean bool, String... args) {
		try {
			// knows how to connect to the file and write it
			// boolean flag shows writing policy
			// true - means content every time will be added to the end of file
			// false - rewrite whole file from scratch every time
			FileWriter fw = new FileWriter(file, bool);
			// wrap fileWriter with buffwredFileWriter
			// because fileWriter calls file and writes it on every string
			// but buffered - puts all strings to buffer and calls\writes only
			// one time before close
			BufferedWriter bw = new BufferedWriter(fw);

			for (String string : args) {
				// write string to buffer
				bw.write(string + "\n");
			}
			// write string to buffer
			bw.write("----------------------------\n");
			// write all string from buffer to file and close bufferedWriter
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
