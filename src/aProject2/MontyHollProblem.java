package aProject2;

import java.util.Arrays;

public class MontyHollProblem {

	public static void main(String[] args) {
		int size = 100;
		boolean[][] array = new boolean[size][3];
		int[] arrayR = new int[size];

		initArray(array);
		printArray(array);

		// // printArray(array);
		// initWithOne(array);
		// // printArray(array);
		// initWithTwoThree(array);
		// // printArray(array);
		// // initCounter(array);
		// // initCounterDeep(array);
		initArrayOfRandoms(arrayR);
		//
		problem1(array, arrayR);
		problem2(array, arrayR);
		// for (int i = 0; i < arrayR.length; i++) {
		// System.out.print(arrayR[i] + " ");
		// }
	}

	public static void printArray(boolean[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j]) {
					System.out.print("\u0023" + " ");
				} else {
					System.out.print("?" + " ");
				}
			}
			System.out.println();
		}
	}

	public static void initArray(boolean[][] array) {
		for (int i = 0; i < array.length; i++) {
			int initializer = (int) (Math.random() * 3);
			for (int j = 0; j < array[i].length; j++) {
				if (j == initializer) {
					array[i][j] = true;
				}
			}
		}
	}

	public static int randTwoThree() {
		return (int) (Math.random() * 2 + 2);
	}

	public static void problem1(boolean[][] array, int[] arrayR) {
		int winCounter = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j]) {
					if (arrayR[i] == j) {
						winCounter++;
						System.out.println("Try " + i + " WIN!!!");
						System.out.println(Arrays.toString(array[i]));
						System.out.println("My number = " + (arrayR[i] + 1));
					}
				}
			}
		}
		System.out.println(winCounter + " - WINS");
	}

	public static void problem2(boolean[][] array, int[] arrayR) {
		int winCounter = 0;
		int winChangedCounter = 0;
		for (int i = 0; i < array.length; i++) {
			int[] afterOneOutHolder = new int[2];
			int counter = 0;
			int checker = (int) (Math.random() * 2);
			boolean checkerB = false;
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j]) {
					afterOneOutHolder[0] = j;
					counter++;
				} else if (j == arrayR[i]) {
					afterOneOutHolder[1] = j;
					counter++;
				}
			}
			if (counter < 2) {
				for (int j = 0; j < array[i].length; j++) {
					if (!array[i][j] && checker > 0 && !checkerB) {
						afterOneOutHolder[1] = j;
					} else if (!array[i][j] && checkerB) {
						afterOneOutHolder[1] = j;
					} else if (!array[i][j]) {
						checkerB = true;
					}
				}
			}
			// System.out.println(Arrays.toString(temp));
			int chancgedChoice = 0;
			if (afterOneOutHolder[0] == arrayR[i]) {
				chancgedChoice = afterOneOutHolder[1];
			} else {
				chancgedChoice = afterOneOutHolder[0];
			}
			if (afterOneOutHolder[0] == chancgedChoice) {
				winChangedCounter++;
			}

			if (afterOneOutHolder[0] == arrayR[i]) {
				winCounter++;
			}
		}
		System.out.println(winCounter + " - WINS");
		System.out.println(winChangedCounter + " - WINS!!!!!!");
	}

	public static void initArrayOfRandoms(int[] arrayR) {
		for (int i = 0; i < arrayR.length; i++) {
			arrayR[i] = (int) (Math.random() * 3);
		}
	}
}
