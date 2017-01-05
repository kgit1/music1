package aFib;

import java.util.Iterator;

public class Fibonacii1 implements Generator<Integer> {

	private int count = 0;

	public Integer next() {
		return fibonacii(count++);
	}

	private int fibonacii(int number) {
		if (number < 2) {
			return 1;
		} else {
			return fibonacii(number - 1) + fibonacii(number - 2);
		}
	}

	public static void main(String[] args) {
		Fibonacii1 generate = new Fibonacii1();
		for (int i = 0; i < 18; i++) {
			System.out.print(generate.next() + " ");
		}
		System.out.println("\n================================");

		for (int i : new IterableFibonacii(18)) {
			System.out.print(i + " ");
		}
	}

}
class IterableFibonacii extends Fibonacii1 implements Iterable<Integer> {
	private int number;
	
	public IterableFibonacii(int number) {
		this.number = number;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			
			@Override
			public boolean hasNext() {
				return number > 0;
			}
			
			@Override
			public Integer next() {
				number--;
				return IterableFibonacii.this.next();
			}
			
		};
	}
	
}
