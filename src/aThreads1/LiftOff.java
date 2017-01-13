package aThreads1;

public class LiftOff {

	public static void main(String[] args) {
		LiftOff1 launch = new LiftOff1();
		launch.run();
	}
}

class LiftOff1 implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;
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