package aThreads1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//example of not thread safe class saved by another class
//with two techniques - 
//1- use synchronization on method inside of which critacal methods invokes
//2 - use critical section synchronization, when not whole method but 
//only critical part inside of it synchronized
public class ECriticalSectionSyncronizing {
	
	public static void main(String[] args) {
		PairManager pman1 = new PairManager1();
		PairManager pman2 = new PairManager2();
		testApproaches(pman1, pman2);
	}
	
	
	static void testApproaches(PairManager pman1, PairManager pman2) {
		ExecutorService exec = Executors.newCachedThreadPool();

		PairManipulator pm1 = new PairManipulator(pman1);
		PairManipulator pm2 = new PairManipulator(pman2);
		PairChecker pcheck1 = new PairChecker(pman1);
		PairChecker pcheck2 = new PairChecker(pman2);

		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pcheck1);
		exec.execute(pcheck2);

		try {
			TimeUnit.MICROSECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("pm1: "+pm1+"\npm2: "+pm2);
		System.exit(0);
	}
}

// not thread safe class
class Pair {
	private int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	@Override
	public String toString() {
		return " [x=" + x + ", y=" + y + "]";
	}

	public class PaiValuesNotEqualException extends RuntimeException {
		public PaiValuesNotEqualException() {
			super("Pair values not equal: " + Pair.this);
		}
	}

	public void checkState() {
		if (x != y) {
			throw new PaiValuesNotEqualException();
		}
	}
}

// make Pair safe with another specialized class
abstract class PairManager {
	AtomicInteger checkCounter = new AtomicInteger();
	// create Pair Object
	protected Pair p = new Pair();
	private List<Pair> storage = Collections
			.synchronizedList(new ArrayList<Pair>());

	// create copy of Pair Object to save in safe place
	public synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}

	protected void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public abstract void increment();
}

// usual whole method synchronization
class PairManager1 extends PairManager {
	@Override
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}

// critical section synchronization
class PairManager2 extends PairManager {
	@Override
	public void increment() {
		Pair temp;
		// here critical section
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}

class PairManipulator implements Runnable {
	private PairManager pm;

	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		while (true) {
			pm.increment();
		}
	}

	@Override
	public String toString() {
		return "Pair " + pm.getPair() + " checkCounter = "
				+ pm.checkCounter.get();
	}
}

class PairChecker implements Runnable {
	private PairManager pm;

	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		while (true) {
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}

	}
}