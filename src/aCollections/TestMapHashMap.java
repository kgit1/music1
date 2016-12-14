package aCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestMapHashMap {

	public static void main(String[] args) {

		HashMap<String, Integer> scores = new HashMap<>();

		scores.put("Catty", 42);
		scores.put("Bert", 343);
		scores.put("Scyller", 420);

		System.out.println(scores);
		System.out.println(scores.get("Bert"));

//		ArrayList<Dog> dogs1 = new ArrayList<Animal>();
//		ArrayList<Animal> animals = new ArrayList<Dog>();
		List<Animal> list = new ArrayList<Animal>();
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		List<Dog> dogs2 = new ArrayList<Dog>();
//		ArrayList<Animal> a = dogs;
		ArrayList<Dog> d = dogs;
		List<Dog> ld = dogs;
		list(d);
		list(dogs);
//		list(dogs2);
	}
	
	static public void list(ArrayList<Dog> d){}

	public class Animal {
	}

	public class Dog extends Animal {
	}
}
