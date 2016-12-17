package aFib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		Sort s = new Sort();
		s.writeArray(s.arrayGenerator(150, 50));
		int[] arr = s.readArray();
		int[] arr1 = new int[50];
		arr1 = s.readArray();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
		s.printAndSort(arr);
		s.printAndSort1(arr1);
		// s.sortInsertion(s.arrayGenerator(50, 50));
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

	// sort array with Selection Sort
	public void sortSelection(int[] array) {
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

	// sort array with Insertion Sort
	public void sortInsertion(int[] array) {
		int counter = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
				counter++;
				int tmp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = tmp;
			}
		}
		System.out.println(counter);
	}

	// print incoming array and sorted version
	public void printAndSort(int[] array) {
		System.out.println("Random array       " + Arrays.toString(array));
		sortSelection(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// print incoming array and sorted version
	public void printAndSort1(int[] array) {
		System.out.println("Random array       " + Arrays.toString(array));
		sortInsertion(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// write array to file
	public void writeArray(int[] array) {
		File file = new File("TestArray.txt");
		try {
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(array);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// get array from file
	public int[] readArray() {
		int[] array = new int[50];
		File file = new File("TestArray.txt");
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(in);
			array = (int[]) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return array;
	}

}
