package aCollections.MapEntrySet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapEntrySet {

	// every Collection item runs Iterable and can run foreach except Maps
	// to use foreach and iterable with Maps
	// we have method entrySet() to convert map to Set with elements Map.Entry
	public static void main(String[] args) {

		Map<String, String> color1 = new HashMap<>();
		Map<String, String> color2 = new TreeMap<>();
		Map<String, String> color3 = new LinkedHashMap<>();

		putToMap(color1);
		putToMap(color2);
		putToMap(color3);

		System.out.println("HashMap");
		printMap(color1);
		System.out.println("TreeMap");
		printMap(color2);
		System.out.println("LinkedHashMap");
		printMap(color3);

		// ====Map by entry by iterator
		Iterator it = color1.entrySet().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// ====Map by entry in foreach
		for (Entry entry : color1.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();

		printMap(System.getenv());

	}

	public static void putToMap(Map<String, String> map) {
		map.put("one", "red");
		map.put("two", "orange");
		map.put("three", "yellow");
		map.put("four", "green");
		map.put("five", "lightblue");
		map.put("six", "blue");
		map.put("seven", "purple");
	}

	public static void printMap(Map<String, String> map) {

		for (Entry entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();
	}
}
