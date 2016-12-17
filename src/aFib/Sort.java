package aFib;

import java.util.Arrays;
import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		Sort s = new Sort();
		s.printAndSort(s.arrayGenerator(150, 50));
	}

	// generate array with random numbers up to "randMax" with size - "size"
	public int[] arrayGenerator(int randMax, int size) {
		int[] array = new int[size];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(randMax);
		}
		return array;
	}

	// sort array with selection algorithm
	// 
	public static void sortSelection(int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length - 1; i++) {
			// hold index of minimal number
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					// if arr[j] < arr[min], assign j to mi
					min = j;
				}
			}
			// if min not equals to min - switch arr[i] with arr[min]
			if (i != min) {
				counter++;
				int tmp = array[min];
				array[min] = array[i];
				array[i] = tmp;
			}
		}
		System.out.println("Counter: " + counter);

	}

	// print incoming array and sorted version
	public void printAndSort(int[] array) {
		System.out.println("Random array       " + Arrays.toString(array));
		sortSelection(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

}
