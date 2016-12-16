package aFib;

public class Fibonacci {

	public static void main(String[] args) {
		for (int i = 2; i < 10; i++) {

			System.out.println(new Fibonacci().fibonacci(i));
		}
	}

	public int fibonacci(int number) {
		int one = 1;
		int two = 1;
		int fib = 0;
		for (int i = 1; i < number; i++) {
			fib = one + two;
			one = two;
			two = fib;
		}
		return fib;
	}

	public int fibonacci1(int number) {
		if (number == 0) {
			return 0;
		}
		if (number == 1) {
			return 1;
		}
		int fib = fibonacci(number - 1) + fibonacci(number - 2);
		return fib;
	}
	
	public void fibonacciIteration(int number) {
		System.out.println("Fibonacci numbers");
		for (int i = 0; i <= number; i++) {
			System.out.println(i + " - " + fibonacciRecursive(i));
		}
	}

	public int fibonacciRecursive(int arg) {
		if (arg == 0) {
			return 0;
		}
		return arg < 3 ? 1
				: fibonacciRecursive(arg - 2) + fibonacciRecursive(arg - 1);
	}

	public int fibonacciIterative(int arg) {
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
