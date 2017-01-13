package aThreads1;

public class LiftOff {

	public static void main(String[] args) {
		// we can create object and invoke run
		// but it will be in the same Thrad where invoked - in the Thread of
		// main method
		LiftOff1 launch = new LiftOff1();
		launch.run();
		// or create thread and give runnable object to it - he will run run()
		// method by himself
		// this time new Thread created and start working on start()
		// invoke
		Thread t = new Thread(new LiftOff1());
		t.start();
		System.out.println("Waiting for liftOff");
	}
}

// simple countdown
class LiftOff1 implements Runnable {

	protected int countDown = 10;
	// object counter
	private static int taskCount = 0;
	// increments every object created
	private final int id = taskCount++;

	public LiftOff1() {
	}

	public LiftOff1(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!")
				+ "). ";
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}

	}

}