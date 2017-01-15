package aThreads1;

public class BTestThreads {

	public static void main(String[] args) {
		AThreadOne one = new AThreadOne();
		AThreadTwo two = new AThreadTwo();
		Thread t1 = new Thread(one);
		Thread t2 = new Thread(two);
		t1.run();
		t2.run();
	}

}
