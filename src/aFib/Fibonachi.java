package aFib;

public class Fibonachi {
	public static void main(String[] args) {
		System.out.println(fibonacciRecursive(15));
		System.out.println(fibonacciIterative(15));
		fibonacciIteration(15);
	}

	public static void fibonacciIteration(int number) {
		System.out.println("Fibonacci numbers");
		for (int i = 0; i <= number; i++) {
			System.out.println(i + " - " + fibonacciRecursive(i));
		}
	}

	public static int fibonacciRecursive(int arg) {
		if (arg == 0) {
			return 0;
		}
		// if (arg == 1) {
		// return 1;
		//
		// } else {
		// return fibonacci(arg - 2) + fibonacci(arg - 1);
		// }
		return arg < 3 ? 1
				: fibonacciRecursive(arg - 2) + fibonacciRecursive(arg - 1);
	}

	public static int fibonacciIterative(int arg) {
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
}
