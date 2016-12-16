package aFib;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(factorial(10));

	}

	public static int factorial(int arg) {
		if (arg == 0) {
			return 1;
		} else {
			return arg * factorial(arg - 1);
		}
	}
}
