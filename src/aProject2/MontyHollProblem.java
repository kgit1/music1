package aProject2;

import java.util.Random;

public class MontyHollProblem {

	public static void main(String[] args) {
		int[][] array = new int[100][3];

		// printArray(array);
		initWithOne(array);
		// printArray(array);
		initWithTwoThree(array);
		printArray(array);
		counterDeep(array);
		// for(int i = 0;i<100;i++){
		// System.out.print(randTwoThree()+" ");
		// }

	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void initWithOne(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int j = (int) (Math.random() * 3);
			array[i][j] = 1;
		}
	}

	public static void initWithTwoThree(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			boolean check = false;
			int a = randTwoThree();
			int b = 3;
			if (a == 3) {
				b = 2;
			}
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 1 && !check) {
					array[i][j] = a;
					check = true;
				}
				if (array[i][j] != 1 && array[i][j] != a && check) {
					array[i][j] = b;
					check = false;
				}
			}
		}
	}

	public static int randTwoThree() {
		return (int) (Math.random() * 2 + 2);
	}

	public static void counter(int[][] array) {
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1) {
					a++;
				} else if (array[i][j] == 2) {
					b++;
				} else {
					c++;
				}
			}
		}
		System.out.println("1 - " + a);
		System.out.println("2 - " + b);
		System.out.println("3 - " + c);
	}

	public static void counterDeep(int[][] array) {
		int a1 = 0, a2 = 0, a3 = 0, b1 = 0, b2 = 0, b3 = 0, c1 = 0, c2 = 0,
				c3 = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (j == 0) {
					if (array[i][j] == 1) {
						a1++;
					} else if (array[i][j] == 2) {
						b1++;
					} else {
						c1++;
					}
				}
				if (j == 1) {
					if (array[i][j] == 1) {
						a2++;
					} else if (array[i][j] == 2) {
						b2++;
					} else {
						c2++;
					}
				}
				if (j == 2) {
					if (array[i][j] == 1) {
						a3++;
					} else if (array[i][j] == 2) {
						b3++;
					} else {
						c3++;
					}
				}
			}
		}
		System.out.println("First position");
		System.out.println("1 = " + a1 + " 2 = " + b1 + " 3 = " + c1);
		System.out.println("Second position");
		System.out.println("1 = " + a2 + " 2 = " + b2 + " 3 = " + c2);
		System.out.println("Third position");
		System.out.println("1 = " + a3 + " 2 = " + b3 + " 3 = " + c3);
	}

}
