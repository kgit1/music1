package aFib;

import java.util.Arrays;

public class PrimeNumberEratosthenes {

	public static void main(String[] args) {
		boolean[] a = new boolean[1000];
		init(a);
		prime(a);
		System.out.println(Arrays.toString(a));
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i]) {
				count++;
				String s = "";
				// if number smaller than 10 - add 2 spaces
				if (i / 10 < 1) {
					s = "  ";
					// if smaller than 100 - add 1 space
				} else if (i / 100 < 1) {
					s = " ";
				}
				System.out.print(s + i + " ");
				if (count % 12 == 0) {
					System.out.println();
				}
			}
		}

	}

	// resheto eratosfena
	public static boolean sieveOfErathosthenes(int max) {
		boolean[] flags = new boolean[max + 1];
		int count = 0;

		return false;
	}

	public static void init(boolean[] flags) {
		flags[2] = true;
		for (int i = 3; i < flags.length; i++) {
			if (i % 2 != 0) {
				flags[i] = true;
			}
		}
	}

	public static void prime(boolean[] flags) {
		for (int i = 4; i < flags.length; i++) {
			if (flags[i]) {
				int sqrt = (int) Math.sqrt(i);
				for (int j = 2; j <= sqrt; j++) {
					if (flags[j]) {
						if (i % j == 0) {
							flags[i] = false;
						}
					}
				}
			}
		}
	}

}
