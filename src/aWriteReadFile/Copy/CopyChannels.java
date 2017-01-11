package aWriteReadFile.Copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//copy file with FileChannel object
public class CopyChannels {
	
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

		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (in.read(buffer) != -1) {
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		System.out.println("1");

	}

}
