package aThreads1;

public class Accum {
	// static instance of class, and with private constructor will make this
	// class - singleton
	private static Accum a = new Accum();
	private int counter;

	// private constructor
	private Accum() {
	}

	public static Accum getAccum() {
		return a;
	}

	public void updateCounter(int add) {
		counter += add;
	}

	public int getCounter() {
		return counter;
	}

}
