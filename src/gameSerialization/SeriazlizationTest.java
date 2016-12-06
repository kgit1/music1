package gameSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriazlizationTest {

	public static void main(String[] args) {

		Character characterOne = new Character("Adrian", "Axe", 100);
		Character characterTwo = new Character("Jox", "Maul", 200);
		Character characterTree = new Character("Gabilion", "Spear", 120);

		try {
			// create object FileOutPutStream - knows how to connect to file
			// and to create if not exists
			FileOutputStream fos = new FileOutputStream("MyGame.ser");

			// create OutPutStram object - knows how to write down object
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// serialize and write objects to file
			oos.writeObject(characterOne);
			oos.writeObject(characterTwo);
			oos.writeObject(characterTree);

			// when we close top lvl stream - FileOutPutStream will be closed
			// automatically
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			// create object FileInputStream - knows how to connect to file
			FileInputStream fis = new FileInputStream("MyGame.ser");
			// create object ObjectInputStream - knows how to read file object
			// by object
			ObjectInputStream ois = new ObjectInputStream(fis);

			Character characterFour = (Character) ois.readObject();
			Character characterFive = (Character) ois.readObject();
			Character characterSix = (Character) ois.readObject();
			ois.close();
			System.out.println(characterFour);
			System.out.println(characterFive);
			System.out.println(characterSix);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
