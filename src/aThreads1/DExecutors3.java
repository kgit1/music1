package aThreads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DExecutors3 {

	public static void main(String[] args) {
		// FixedThreadPool makes limited amount of threads for all tasks
		// makes all needed threads before started task so no additional time
		// wasted during operations to create new threads
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			exec.execute(new CLiftOff1());
		}
		exec.shutdown();
	}
}
