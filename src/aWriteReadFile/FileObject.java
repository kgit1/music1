package aWriteReadFile;

import java.io.File;

public class FileObject {

	public static void main(String[] args) {
		// file - represents file, but haven't file content inside - just path
		File file = new File("Strings");

		// print absolute path to file or directory
		System.out.println(file.getAbsolutePath());

		// file - represents file, but haven't file content inside - just path
		File dir = new File("Chapter7");
		// make directory
		dir.mkdir();
		// delete directory
		// dir.delete();
		// implement new path to file object
		dir = new File("D:\\J\\workspace1\\aMusic1");

		// if file object is directory
		if (dir.isDirectory()) {
			// convert names of files and dirs inside this directory to list of
			// strings and assign to out list of strings
			String[] dirContent = dir.list();
			// print list of strings
			for (int i = 0; i < dirContent.length; i++) {
				System.out.println(dirContent[i]);
			}
		}
	}

}
