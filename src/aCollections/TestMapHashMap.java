package aCollections;

import java.util.HashMap;

public class TestMapHashMap {

	public static void main(String[] args) {

		HashMap<String, Integer> scores = new HashMap<>();

		scores.put("Catty", 42);
		scores.put("Bert", 343);
		scores.put("Scyller", 420);

		System.out.println(scores);
		System.out.println(scores.get("Bert"));

	}

}
