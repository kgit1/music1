package aThreads1;

public class TestThreads {

	public static void main(String[] args) {
		ThreadOne one = new ThreadOne();
		ThreadTwo two = new ThreadTwo();
		Thread t1 = new Thread(one);
		Thread t2 = new Thread(two);
		t1.run();
		t2.run();
	}

}
