package aWriteReadFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//read input from console
public class Echo {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		String s;
		// with reader.readLine() reads line feom console and print it, if null
		// - quits
		while ((s = reader.readLine()) != null && s.length() != 0) {
			System.out.println(s);
		}

	}

}
