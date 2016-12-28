package aCollections.AdapterMethodReverseIteratorString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MultiIterableClass extends IterableClass {
	public MultiIterableClass(String[] words) {
		super(words);
	}

	public Iterable<String> reversed() {
		return new Iterable<String>() {
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					int current = words.length - 1;

					public boolean hasNext() {
						return current > -1;
					}

					public String next() {
						return words[current--];
					}

				};
			}
		};
	}

	public Iterable<String> randomized() {
		return new Iterable<String>() {
			public Iterator<String> iterator() {
				List<String> shuffled = new ArrayList<>(Arrays.asList(words));
				Collections.shuffle(shuffled, new Random(47));
				return shuffled.iterator();
			}
		};
	}

	public static void main(String[] args) {
		MultiIterableClass mul = new MultiIterableClass(
				("And that is how we know the Earth to be " + "banana-shaped.")
						.split(" "));

		for (String string : mul) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.println();
		for (String string : mul.reversed()) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.println();
		for (String string : mul.randomized()) {
			System.out.print(string + " ");
		}
	}
}
