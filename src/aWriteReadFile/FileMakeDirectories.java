package aWriteReadFile;

import java.io.File;

public class FileMakeDirectories {
	public static void main(String[] args) {
		args = new String[3];
		// args[0] = "-r";
		// args[1] = "BBA";
		// args[2] = "AAB.jpeg";
		args[0] = "-r";
		args[1] = "BBA";
		args[2] = "AAB.jpeg";
		if (args.length < 1) {
			usage();
		}
		if (args[0].equals("-r")) {
			if (args.length != 3) {
				usage();
			}
			File old = new File(args[1]), rname = new File(args[2]);
			old.renameTo(rname);
			fileData(old);
			fileData(rname);
			return;
		}
		int count = 0;
		boolean del = false;
		if (args[0].equals("-d")) {
			count++;
			del = true;
		}
		count--;
		while (++count < args.length) {
			File f = new File(args[count]);
			if (f.exists()) {
				System.out.println(f + " exists");
				if (del) {
					System.out.println("deleting.. " + f);
				}
			} else {
				if (!del) {
					f.mkdirs();
					System.out.println("directory " + f + " created");
				}
			}
			fileData(f);
		}
	}

	private static void usage() {
		System.err.println("use");
		System.exit(1);
	}

	private static void fileData(File f) {
		System.out.println("Full name: " + f.getAbsolutePath() + "\n readable: "
				+ f.canRead() + "\n writable: " + f.canWrite() + "\n name: "
				+ f.getName() + "\n parent: " + f.getParent() + "\n rpath: "
				+ f.getPath() + "\n size: " + f.length() + "\n last modified: "
				+ f.lastModified());
		if (f.isFile()) {
			System.out.println("This is a file");
		} else if (f.isDirectory()) {
			System.out.println("This is a directory");
		}
	}
}
