package aThreads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DExecutors2 {

	public static void main(String[] args) {
		// SingleThreadExecutor makes 1 thread for all tasks
		// executing tasks one by one in own internal order
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec.execute(new CLiftOff1());
		}
		exec.shutdown();
	}
}
