package aThreads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DExecutors1 {

	public static void main(String[] args) {
		// CachedThreadPool makes different thread for every task
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new CLiftOff1());
		}
		exec.shutdown();
	}
}
