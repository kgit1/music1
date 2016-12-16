package aFib;

public class EvenOrOdd {
	public static void main(String[] args) {
		System.out.println("455 is even = " + isEven(455));
		System.out.println("455 is even = " + isOdd(455));

	}

	public static boolean isEven(int k) {
		if (k == 0) {
			return true; // 0 - четное число
		} else {
			return isOdd(k - 1);
		}
	}

	// проверка на НЕчетность
	public static boolean isOdd(int k) {
		if (k == 0) {
			return false; // 0 - НЕ НЕчетное число
		} else {
			return isEven(k - 1);
		}
	}
}
