package aFib;

public class Fibonacci {

	public static void main(String[] args) {
		printFibonacciSequence1(10);
		printFibonacciSequence2(10);
		printFibonacciSequence3(10);
		printFibonacciSequence4(10);
	}

	public static int fibonacciIterative(int number) {
		if (number == 0) {
			return 0;
		}
		if (number < 3) {
			return 1;
		}
		int one = 1;
		int two = 1;
		int fib = 0;
		for (int i = 2; i < number; i++) {
			fib = one + two;
			one = two;
			two = fib;
		}
		return fib;
	}

	public static int[] fibonacciIterative1(int number) {
		int[] result = new int[number + 2];		
		result[0] = 0;
		result[1] = 1;
		result[2] = 1;
		for (int k = 3; k < result.length; k++) {
			result[k] = result[k - 2] + result[k - 1];
		}
		return result;
	}

	public static int fibonacciRecursive(int number) {
		if (number == 0) {
			return 0;
		}
		if (number < 3) {
			return 1;
		}
		return fibonacciRecursive(number - 2) + fibonacciRecursive(number - 1);
	}

	public static int fibonacciRecursive1(int arg) {
		if (arg == 0) {
			return 0;
		}
		return arg < 3 ? 1
				: fibonacciRecursive1(arg - 2) + fibonacciRecursive1(arg - 1);
	}

	public static void printFibonacciSequence1(int number) {
		for (int i = 0; i <= number; i++) {
			System.out.print(fibonacciIterative(i) + " ");
		}
		System.out.println(" Fibonacci numbers fibonacciIterative");
	}

	public static void printFibonacciSequence2(int number) {
		int[] array = fibonacciIterative1(number);
		for (int i = 0; i <= number; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" Fibonacci numbers fibonacciIterative1");
	}

	public static void printFibonacciSequence3(int number) {
		for (int i = 0; i <= number; i++) {
			System.out.print(fibonacciRecursive(i) + " ");
		}
		System.out.println(" Fibonacci numbers fibonacciRecursive");
	}

	public static void printFibonacciSequence4(int number) {
		for (int i = 0; i <= number; i++) {
			System.out.print(fibonacciRecursive1(i) + " ");
		}
		System.out.println(" Fibonacci numbers fibonacciRecursive1");
	}

}
