
package aFib;

public class ReverseNumber {
	public static void main(String[] args) {
		int number = 12345;
		System.out.println(
				digitsInNumber(number) + " digits in number " + number);
		System.out
				.println(reverseNumber(number) + " reversed number " + number);
		reverseNumberRecursive(number);

	}

	public static int reverseNumber(int number) {
		int counter = digitsInNumber(number);
		int tmp = number;
		int newNumber = 0;
		while (counter != 0) {
			newNumber += (tmp % 10) * Math.pow(10, counter - 1);
			
			
			tmp /= 10; // tmp = tmp / 10;
			counter--;
		}
		return newNumber;
	}

	public static void reverseNumberRecursive(int number) {
		System.out.println(number % 10);
		if (number > 1) {
			number /= 10;
			reverseNumberRecursive(number);
		}
	}

	public static int digitsInNumber(int number) {
		int counter = 0;
		int tmp = number;
		while (tmp != 0) {
			tmp /= 10;
			counter++;
		}
		return counter;
	}
}
