package aThreads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//we have object with synchronized methods which changing state of boolean to 
//true and to false this methods called by 2 different threads so it 
//can work in usual situation, because synchronized will block whole 
//object to one thread, but we have wait() which suspending thread and 
//unlocks it so another thread can use object before notify() or 
//notifyAll() invoked and wait stopped
//so
//one thread with one method do staff, then wait invokes,thread suspends 
//and object unleashes, second thread do staff invokes wait and 
//same time notifyAll() which notify all threads waiting for object that it 
//is ready for work
public class FThreadWaitNotify {
	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdown();
	}
}

class Car {
	private boolean waxOn = false;

	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}

	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}

	// when wait invokes - lock is unlocked but thread is
	// suspended(preostanovlen)
	public synchronized void waitForWaxing() throws InterruptedException {
		while (waxOn == false) {
			wait();
		}
	}

	public synchronized void waitForBuffing() throws InterruptedException {
		while (waxOn == true) {
			wait();
		}
	}
}

class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Wax On!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("Ending Wax On task");
	}
}

class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Wax Off!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("Ending Wax Off task");
	}
}