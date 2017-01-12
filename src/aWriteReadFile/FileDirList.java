package aWriteReadFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

//prints names of files in directory or files in directory by some mask
public class FileDirList {

	public static void main(String[] args) {
//		 fake command line argument
		 args = new String[1];
		 args[0] = ".jpeg";
		// File - presents file, or group of files if points on directory and in
		// that case array of files can be returned with help of method list()

		printDir(new File("."), args);

	}

	public static void printDir(File path, String[] args) {
		// File path = new File("bin");
		String[] list;

		// print all directories and files from selected directory
		if (args.length == 0) {
			// method list executed to file - returns array of file names if
			// File object is directory
			list = path.list();
		} else {
			// print directories and files by mask
			list = path.list(new DirFilter(args[0]));
			Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
}

// to have opportunity select some type of files(for example which are ".java")
// during list() method execution to File object - we need object of class which
// implements FilenameFilter interface
class DirFilter implements FilenameFilter {
	// create Pattern object
	private Pattern pattern;

	public DirFilter(String regex) {
		// execute compile on pattern to compile expression to pattern
		pattern = Pattern.compile(regex);
	}

	@Override
	// list() invokes this method on every file name one by one
	// method that takes File object as argument to know where dig, and String
	// object as example of what to seek
	// and returns result of exam is given file name equals to example
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}
