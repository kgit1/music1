package aWriteReadFile.Copy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

//compress file
//app - takes files, compress, write to new file, than decompress and print
public class GZip {

	public static void main(String[] args)
			throws FileNotFoundException, IOException {
		// fake command line arguments
		args = new String[1];
		args[0] = "src/aWriteReadFile/Copy/GZip.java";

		// print content of given directory
		// printDir(new File("src"));

		if (args.length == 0) {
			System.out.println("GZip");
			System.exit(1);
		}
		// create BufferedReader which takes FileReader stream from File
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		// create bufferedOutputStream which takes GZipped stream with usual
		// FileOutputStream inside with given file
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream("test.gz")));

		System.out.println("writing");

		int c;
		// read from file to buffer
		while ((c = in.read()) != -1) {
			// write compressed stream to new file
			out.write(c);
		}
		// close input
		in.close();
		// close output
		out.close();
		System.out.println("reading");
		// create new BufferedReader with InputStreamReader Wich gets
		// decopressed stream from GZipInputStream with FileInputStream to File
		BufferedReader in2 = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(new FileInputStream("test.gz"))));

		String s;
		// print bufferedReader line by line
		while ((s = in2.readLine()) != null) {
			System.out.println(s);
		}
	}

	public static void printDir(File path) {
		// File path = new File("bin");
		String[] list;

		// print all directories and files from selected directory
		// method list executed to file - returns array of file names if
		// File object is directory
		list = path.list();

		for (String string : list) {
			System.out.println(string);
		}
	}
}
