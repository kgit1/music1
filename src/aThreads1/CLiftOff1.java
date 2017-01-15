package aThreads1;

//simple countdown
public class CLiftOff1 implements Runnable {

	protected int countDown = 10;
	// object counter
	private static int taskCount = 0;
	// increments every object created
	private final int id = taskCount++;

	public CLiftOff1() {
	}

	public CLiftOff1(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!")
				+ "). ";
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}
}
