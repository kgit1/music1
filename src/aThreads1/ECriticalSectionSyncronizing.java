package aThreads1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ECriticalSectionSyncronizing {

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

class PairManager1 extends PairManager {

	@Override
	public void increment() {
		// TODO Auto-generated method stub

	}

}