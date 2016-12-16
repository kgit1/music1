package aFib;

public class EvenOrOdd {
	public static void main(String[] args) {
		System.out.println("455 is even = " + isEven(455));
		System.out.println("455 is even = " + isOdd(455));

	}

	public static boolean isEven(int k) {
		if (k == 0) {
			return true;
		} else {
			return isOdd(k - 1);
		}
	}

	public static boolean isOdd(int k) {
		if (k == 0) {
			return false;
		} else {
			return isEven(k - 1);
		}
	}
}
