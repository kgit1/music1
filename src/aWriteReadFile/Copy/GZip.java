package aWriteReadFile.Copy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import aWriteReadFile.DirFilter;

//compress file
//app - takes files, compresses, writes to new file, than decopress and print
public class GZip {

	public static void main(String[] args)
			throws FileNotFoundException, IOException {
		args = new String[1];
		// /aMusic1/src/aWriteReadFile/Copy/GZip.java
		args[0] = "src/aWriteReadFile/Copy/GZip.java";
		
		printDir(new File("src"));

		if (args.length == 0) {
			System.out.println("GZip");
			System.exit(1);
		}
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream("test.gz")));

		System.out.println("writing");

		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
		System.out.println("reading");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(new FileInputStream("test.gz"))));

		String s;
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
