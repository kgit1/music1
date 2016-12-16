package cLiner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		String fileName = "test.txt";
		List<String> list = new ArrayList<>();
		try {
			Scanner scan = new Scanner(new File(fileName));

			while (scan.hasNextLine()) {
				String temp = scan.nextLine();
				if(!temp.isEmpty()){
					temp = "<p>" + temp + "</p>";
				}
				list.add(temp);
			}

			System.out.println("check 2");
			for (String string : list) {
				System.out.println(string);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		File f = new File(fileName + "-lined");
		try {
			if (!f.createNewFile()) {
				f.delete();
			}
			;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter(f, true);
			for (String string : list) {
				System.out.println(string);
				writer.write(string + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
