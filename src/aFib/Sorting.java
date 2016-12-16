package aFib;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		//
		// int[] array1D = {0, 1, 2, 3};
		// int[][] array2D = {{0, 1}, {2, 3}};
		// System.out.println(array1D);
		// System.out.println(Arrays.deepToString(array2D));
		// invert(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		// invert(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
		// invert(new int[]{0});
		// invert(new int[]{});
		Random rnd = new Random();
		int[] array = new int[32 * 1024];
		for (int k = 0; k < array.length; k++) {
			array[k] = rnd.nextInt();
		}
		int[] array1 = new int[3];
		for (int k = 0; k < array1.length; k++) {
			array1[k] = rnd.nextInt();
		}
		long t1 = System.nanoTime();
		// minMaxBubbleSort(new int[]{5, 12, 43, 2, 55, 22, 86, 86, 55, 13, 92,
		// 91, 4, 15, 22, 33, 74, 1, 9, 68, 17, 55, 2});
		// minMaxBubbleSort1(new int[]{5, 12, 43, 2, 55, 22, 86, 86, 55, 13, 92,
		// 91, 4, 15, 22, 33, 74, 1, 9, 68, 17, 55, 2});
		// minMaxBubbleSort2(new int[]{5, 12, 43, 2, 55, 22, 86, 86, 55, 13, 92,
		// 91, 4, 15, 22, 33, 74, 1, 9, 68, 17, 55, 2});
		minMaxBubbleSort2(array);
		System.out.println("t1 - " + (System.nanoTime() - t1) / 1000000000.0);
		System.out.println(factorial(5));

		System.out.println(fibona44i(6) + " fibona44i");
		System.out.println(fibona44iIteration(15) + " fibona44iIteration");

		System.out.println("23 - нечетное число: " + isOdd(23));
		System.out.println("1222 - четное число:   " + isEven(1222));
		System.out.println("Hello!".substring(1, 6));
		System.out.println("Hello!".startsWith("h"));
		System.out.println("Hello!".charAt(1));
		System.out.println("Factorial 15 = " + factorial(15));
		peremeshivalka(new int[] { 1, 2, 3 }, 3);
		peremeshivalka(array1, array1.length);

	}

	public static void invertTest(int[] data) {
		for (int k = data.length / 2; k >= 0; k--) {
			int tmp = data[k];
			data[k] = data[data.length - 1 - k];
			data[data.length - 1 - k] = tmp;
		}
	}

	public static void invert(int[] data) {
		System.out.print(Arrays.toString(data) + " -> ");
		invertTest(data);
		System.out.println(Arrays.toString(data));
	}

	public static void minMaxBubbleSort(int[] data) {
		int count = 0;
		int exchange = 0;
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1; j++) {
				count++;
				if (data[j] > data[j + 1]) {
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
					exchange++;
				}
			}
			// System.out.println(Arrays.toString(data) + " count: " + count + "
			// exchange: " + exchange);
		}
		System.out.println(
				data.length + " count: " + count + " exchange: " + exchange);

		System.out.println();
		System.out.println();
	}

	public static void minMaxBubbleSort1(int[] data) {
		int count = 0;
		int exchange = 0;
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				count++;
				if (data[i] > data[j]) {
					int tmp = data[j];
					data[j] = data[i];
					data[i] = tmp;
					exchange++;
				}
			}
			// System.out.println(Arrays.toString(data) + " count: " + count + "
			// exchange: " + exchange);
		}
		System.out.println(
				data.length + " count: " + count + " exchange: " + exchange);

		System.out.println();
		System.out.println();
	}

	public static void minMaxBubbleSort2(int[] data) {
		int count = 0;
		int exchange = 0;
		for (int i = 0; i < data.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < data.length; j++) {
				count++;
				if (data[min] > data[j]) {
					min = j;
				}
				if (j == data.length - 1) {
					int tmp = data[i];
					data[i] = data[min];
					data[min] = tmp;
					exchange++;
				}
			}
			// System.out.println(Arrays.toString(data) + " count: " + count + "
			// exchange: " + exchange);
		}
		System.out.println(
				data.length + " count: " + count + " exchange: " + exchange);

		System.out.println();
		System.out.println();
	}

	public static int factorial(int arg) {
		if (arg == 0) {
			System.out.println(arg);
			return 1;
		} else {
			System.out.println(arg);
			return arg * factorial(arg - 1);
		}
	}

	public static int fibona44i(int arg) {
		if (arg == 0) {
			return 0;
		}
		// if (arg == 1) {
		// return 1;
		//
		// } else {
		// return fibona44i(arg - 2) + fibona44i(arg - 1);
		// }
		return arg < 3 ? 1 : fibona44i(arg - 2) + fibona44i(arg - 1);
	}

	public static int fibona44iIteration(int arg) {
		if (arg == 0)
			return 0;
		if (arg < 3)
			return 1;
		int[] result = new int[arg + 2];
		result[0] = 0;
		result[1] = 1;
		result[2] = 1;
		for (int k = 3; k < result.length; k++) {
			result[k] = result[k - 2] + result[k - 1];
		}
		return result[arg];
	}

	public static boolean isEven(int k) {
		if (k == 0) {
			return true; // 0 - четное число
		} else {
			return isOdd(k - 1);
		}
	}

	// проверка на НЕчетность
	public static boolean isOdd(int k) {
		if (k == 0) {
			return false; // 0 - НЕ НЕчетное число
		} else {
			return isEven(k - 1);
		}
	}

	public static void peremeshivalka(int[] arr, int size) {
		if (size < 2) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int k = 0; k < size; k++) {
				swap(arr, k, size - 1);
				peremeshivalka(arr, size - 1);
			}
		}
	}

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
