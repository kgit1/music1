
package aFib;

import java.util.Random;
import java.util.Scanner;

public class KostinMain {
	static Scanner num = new Scanner(System.in);
	static Random random = new Random();

	public static void main(String[] args) {
		int input = -1;
		while (input != 0) {
			System.out.print("Enter task number 1-5\n");
			input = num.nextInt();
			switch (input) {
			case 1:
				System.out.println("Task 1\n");
				task1();
				break;
			case 2:
				System.out.println("Task 2\n");
				task2();
				break;
			case 3:
				System.out.println("Task 3\n");
//				task3();
				break;
			case 4:
				System.out.println("Task 4\n");
				task4();
				break;
			case 5:
				System.out.println("Task 5\n");
				task5();
				break;
			}
		}
	}

	public static void task1() {
		int[][] arr1t1 = new int[8][5];
		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				arr1t1[i][j] = random.nextInt(89) + 10;
			}
		}
		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				System.out.print(arr1t1[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void task2() {
		int[][] arr1t1 = new int[5][8];
		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				arr1t1[i][j] = random.nextInt() % 100;
			}
		}
		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				System.out.print(arr1t1[i][j] + " ");
			}
			System.out.print("\n");
		}
		int max = 0;
		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				if (max < arr1t1[i][j]) {
					max = arr1t1[i][j];
				}
			}
		}
		System.out.print(max + " Max number");
		System.out.println("\n");
	}

//	public static void task3() {
//		int mod = 1;
//		int maxMod = 0;
//		int imax = 0;
//		int[][] arr1t1 = new int[7][4];
//		for (int i = 0; i < arr1t1.length; i++) {
//			for (int j = 0; j < arr1t1[i].length; j++) {
//				arr1t1[i][j] = random.nextInt(11) - 5;
//			}
//		}
//		for (int i = 0; i < arr1t1.length; i++) {
//			for (int j = 0; j < arr1t1[i].length; j++) {
//				System.out.print(arr1t1[i][j] + " ");
//			}
//			System.out.print("\n");
//		}
//		System.out.print("\n");
//		for (int i = 0; i < arr1t1.length; i++) {
//			for (int j = 0; j < arr1t1[i].length; j++) {
//				mod = mod * arr1t1[i][j];
//			}
//			if (Math.abs(maxMod) < Math.abs(mod)) {
//				imax = i;
//				maxMod = mod;
//			}
//			System.out.println(i + " " + mod + " mod");
//			mod = 1;
//		}
//		System.out.print("max mod index - " + imax);
//		System.out.println("\n");
//	}

	public static void task4() {
		int[][] arr1t1 = new int[6][7];
		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				arr1t1[i][j] = random.nextInt(10);
			}
		}
		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				System.out.print(arr1t1[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		for (int i = 0; i < arr1t1.length; i++) {
			int max = 0;
			int jmax = 0;
			for (int j = 0; j < arr1t1[i].length; j++) {
				if (max < arr1t1[i][j]) {
					max = arr1t1[i][j];
					jmax = j;
				}
			}
			int tmp = arr1t1[i][jmax];
			arr1t1[i][jmax] = arr1t1[i][0];
			arr1t1[i][0] = tmp;
		}
		System.out.print("\n");

		for (int i = 0; i < arr1t1.length; i++) {
			for (int j = 0; j < arr1t1[i].length; j++) {
				System.out.print(arr1t1[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void task5() {
		int[][] arr1t5 = new int[15][2];
		boolean flag = true;
		for (int i = 0; i < arr1t5.length; i++) {
			arr1t5[i][0] = random.nextInt(7) + 2;
			arr1t5[i][1] = random.nextInt(7) + 2;
			if (i != 0) {
				do {
					for (int j = 0; j < i; j++) {
						if ((arr1t5[i][0] == arr1t5[j][0]
								&& arr1t5[i][1] == arr1t5[j][1])
								|| (arr1t5[i][0] == arr1t5[j][1]
										&& arr1t5[i][1] == arr1t5[j][0])) {
							arr1t5[i][0] = random.nextInt(7) + 2;
							arr1t5[i][1] = random.nextInt(7) + 2;
							flag = false;
							break;
						} else {
							flag = true;
						}
					}
				} while (!flag);
			}
			if (flag) {
				System.out.println(arr1t5[i][0] + " * " + arr1t5[i][1]);
			}
			flag = true;
		}
		System.out.print("\n");
	}
}
