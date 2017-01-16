package aThreads1;

//for simpleest cases we can extend Thread not implementing Runnable
public class ESimpleThreads extends Thread {
	private int countDown = 5;
	private static int threadCount = 0;

	public ESimpleThreads() {
		super(Integer.toString(++threadCount) + " thread");
		// it's not to good to leave start() inside constructor because can be
		// invoked
		// some procedure which will work with object when it is not yet fully
		// created
		start();
	}

	@Override
	public String toString() {
		return "#" + getName() + " (" + countDown + ")";
	}

	public void run() {
		while (true) {
			System.out.print(this);
			if (--countDown == 0) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new ESimpleThreads();
		}
	}

}
