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

}
