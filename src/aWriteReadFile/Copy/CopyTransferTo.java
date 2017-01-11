package aWriteReadFile.Copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

//copy file with FileChannel object
public class CopyTransferTo {

	private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {
		args = new String[2];
		args[0] = "AAB.jpeg";
		args[1] = "BAB.jpeg";
		if (args.length != 2) {
			System.out.println("error");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel(),
				out = new FileOutputStream(args[1]).getChannel();
		
		long start = System.nanoTime();
		in.transferTo(0, in.size(), out);
		double duration = System.nanoTime() - start;
		System.out.format("%.4f\n", duration / 1.0e9);
		// or
		// out.transferFrom(in, 0, in.size());
	}

}
