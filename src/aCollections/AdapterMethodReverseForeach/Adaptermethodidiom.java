package aCollections.AdapterMethodReverseForeach;

import java.util.Arrays;

public class Adaptermethodidiom {

	public static void main(String[] args) {
		ReversibleArrayList<String> reversible = new ReversibleArrayList<>(
				Arrays.asList("To be or not to be".split(" ")));

		//usual foreach over usual iterable
		for (String string : reversible) {
			System.out.print(string + " ");
		}
		
		System.out.println();
		System.out.println();
		//usual foreach over our iterable
		for (String string : reversible.reversed()) {
			System.out.print(string + " ");
		}

	}

}
