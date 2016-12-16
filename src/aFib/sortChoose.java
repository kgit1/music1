package aFib;

import java.util.Arrays;
import java.util.Random;

public class sortChoose {

	public static void main(String[] args) {
		arrayGenerator(2, 50);
	}

	public static void sortChoose(int[] arr) {
		for (int moveCounter = 0; moveCounter < arr.length; moveCounter++) {
			int min = moveCounter;
			for (int i = moveCounter + 1; i < arr.length; i++) {
				if (arr[i] < arr[min]) {
					min = i;
				}
			}
			int tmp = arr[min];
			for (int j = min; j > moveCounter; j--) {
				arr[j] = arr[j - 1];
			}
			arr[moveCounter] = tmp;
		}
	}

	public static void randArray(int size) {
		int[] arr = new int[size];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(150) + 1;
		}
		System.out.println("Random array       " + Arrays.toString(arr));
		sortChoose(arr);
		System.out.println("Random sorted array" + Arrays.toString(arr));
	}

	public static void arrayGenerator(int number, int size) {
		for (int i = 0; i < number; i++) {
			randArray(size);
		}
	}
}
