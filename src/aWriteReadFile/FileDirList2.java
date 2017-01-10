package aWriteReadFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

//prints names of files in directory or files in directory by some mask
//same DirList but with anonymos class for FilenameFileter
public class FileDirList2 {

	public static void main(String[] args) {
		// fake command line argument
		// args = new String[1];
		// args[0] = ".java";
		// File - presents file, or group of files if points on directory and in
		// that case array of files can be returned with help of method list()
		File path = new File("bin");
		String[] list;
		if (args.length == 0) {
			// method list executed to file - returns arrey of file names if
			// File object is directory
			list = path.list();
		} else {
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);

				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
			Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
}
