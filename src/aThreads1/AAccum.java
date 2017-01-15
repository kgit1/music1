package aThreads1;

public class AAccum {
	// static instance of class, and with private constructor will make this
	// class - singleton
	private static AAccum a = new AAccum();
	private int counter;

	// private constructor
	private AAccum() {
	}

	public static AAccum getAccum() {
		return a;
	}

	public void updateCounter(int add) {
		counter += add;
	}

	public int getCounter() {
		return counter;
	}

}
