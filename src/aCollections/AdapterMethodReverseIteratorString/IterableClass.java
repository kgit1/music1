package aCollections.AdapterMethodReverseIteratorString;

import java.util.Iterator;

public class IterableClass implements Iterable<String> {
	protected String[] words;

	public IterableClass(String[] words) {
		this.words = words;
	}

	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}

		};
	}

	public static void main(String[] args) {
		for (String string : new IterableClass(
				("And that is how we know the Earth to be " + "banana-shaped.")
						.split(" "))) {
			System.out.print(string + " ");
		}
	}
}
