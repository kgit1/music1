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
		for (int i = 0; i < array.length; i++) {
			int[] temp = new int[2];
			boolean addCounter = false;
			boolean addSecond = false;
			int checker = (int) (Math.random() * 2);
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] && j != arrayR[i]) {
					if (array[i][j]) {
						if (addCounter) {
							temp[0] = j;
							addCounter = true;
						} else {
							temp[1] = j;
						}
					} else if (j == arrayR[i]) {
						if (addCounter) {
							temp[0] = j;
							addCounter = true;
						} else {
							temp[1] = j;
						}
					}
				} else {
					if (array[i][j]) {
						if (addCounter) {
							temp[0] = j;
							addCounter = true;
						} else {
							temp[1] = j;
						}
					} else {
						if (checker > 0 && !addSecond) {
							if (addCounter) {
								temp[0] = j;
								addCounter = true;
								addSecond = true;
							} else {
								temp[1] = j;
							}
						} else if (checker < 0 && !addSecond) {
						}
					}
				}
			}
			System.out.println(Arrays.toString(temp));
		}
		System.out.println(winCounter + " - WINS");
	}

	// public static void initWithOne(int[][] array) {
	// for (int i = 0; i < array.length; i++) {
	// int j = (int) (Math.random() * 3);
	// array[i][j] = 1;
	// }
	// }

	// public static void initWithTwoThree(int[][] array) {
	// for (int i = 0; i < array.length; i++) {
	// boolean check = false;
	// int a = randTwoThree();
	// int b = 3;
	// if (a == 3) {
	// b = 2;
	// }
	// for (int j = 0; j < array[i].length; j++) {
	// if (array[i][j] != 1 && !check) {
	// array[i][j] = a;
	// check = true;
	// }
	// if (array[i][j] != 1 && array[i][j] != a && check) {
	// array[i][j] = b;
	// check = false;
	// }
	// }
	// }
	// }

	// public static void initCounter(int[][] array) {
	// int a = 0, b = 0, c = 0;
	// for (int i = 0; i < array.length; i++) {
	// for (int j = 0; j < array[i].length; j++) {
	// if (array[i][j] == 1) {
	// a++;
	// } else if (array[i][j] == 2) {
	// b++;
	// } else {
	// c++;
	// }
	// }
	// }
	// System.out.println("1 - " + a);
	// System.out.println("2 - " + b);
	// System.out.println("3 - " + c);
	// }

	// public static void initCounterDeep(int[][] array) {
	// int a1 = 0, a2 = 0, a3 = 0, b1 = 0, b2 = 0, b3 = 0, c1 = 0, c2 = 0,
	// c3 = 0;
	// for (int i = 0; i < array.length; i++) {
	// for (int j = 0; j < array[i].length; j++) {
	// if (j == 0) {
	// if (array[i][j] == 1) {
	// a1++;
	// } else if (array[i][j] == 2) {
	// b1++;
	// } else {
	// c1++;
	// }
	// }
	// if (j == 1) {
	// if (array[i][j] == 1) {
	// a2++;
	// } else if (array[i][j] == 2) {
	// b2++;
	// } else {
	// c2++;
	// }
	// }
	// if (j == 2) {
	// if (array[i][j] == 1) {
	// a3++;
	// } else if (array[i][j] == 2) {
	// b3++;
	// } else {
	// c3++;
	// }
	// }
	// }
	// }
	// System.out.println("First position");
	// System.out.println("1 = " + a1 + " 2 = " + b1 + " 3 = " + c1);
	// System.out.println("Second position");
	// System.out.println("1 = " + a2 + " 2 = " + b2 + " 3 = " + c2);
	// System.out.println("Third position");
	// System.out.println("1 = " + a3 + " 2 = " + b3 + " 3 = " + c3);
	// }

	public static void initArrayOfRandoms(int[] arrayR) {
		for (int i = 0; i < arrayR.length; i++) {
			arrayR[i] = (int) (Math.random() * 3);
		}
	}

	// public static void problem1(int[][] array, int[] arrayR) {
	// int winCounter = 0;
	// for (int i = 0; i < array.length; i++) {
	// for (int j = 0; j < array[i].length; j++) {
	// if (array[i][j] == 1) {
	// if (arrayR[i] == j) {
	// winCounter++;
	// System.out.println("Tray " + i + " WIN!!!");
	// System.out.println(Arrays.toString(array[i]));
	// System.out.println("My number = " + (arrayR[i] + 1));
	// }
	// }
	// }
	// }
	// System.out.println(winCounter + " - WINS");
	// }

	// public static void problem2(int[][] array, int[] arrayR) {
	// int winCounter = 0;
	// int[] temp = new int[2];
	// for (int i = 0; i < array.length; i++) {
	// for (int j = 0; j < array[i].length; j++) {
	// if (j != temp[i] && array[i][j] != 1) {
	//
	// }
	//
	// // if (array[i][j] == 1) {
	// // if (arrayR[i] == j) {
	// // winCounter++;
	// // System.out.println("Tray " + i + " WIN!!!");
	// // System.out.println(Arrays.toString(array[i]));
	// // System.out.println("My number = " + (arrayR[i] + 1));
	// // }
	// // }
	// }
	// }
	// System.out.println(winCounter + " - WINS");
	// }

}
