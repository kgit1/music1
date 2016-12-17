package aFib;

import java.util.Arrays;
import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		Sort s = new Sort();
		s.printAndSort(s.arrayGenerator(150, 50));
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

	public void printAndSort(int[] array) {
		System.out.println("Random array       " + Arrays.toString(array));
		sortChoose(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	public int[] arrayGenerator(int randMax, int size) {
		int[] array = new int[size];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(randMax);
		}
		return array;
	}

}
