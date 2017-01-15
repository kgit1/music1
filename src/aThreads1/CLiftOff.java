package aThreads1;

public class CLiftOff {

	public static void main(String[] args) {
		// we can create object and invoke run
		// but it will be in the same Thrad where invoked - in the Thread of
		// main method
		CLiftOff1 launch = new CLiftOff1();
		launch.run();
		// or create thread and give runnable object to it - he will run run()
		// method by himself
		// this time new Thread created and start working on start()
		// invoke
		Thread t = new Thread(new CLiftOff1());
		t.start();
		System.out.println("Waiting for liftOff");
	}
}
