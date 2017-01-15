package aThreads1;

public class AThreadOne implements Runnable {
	AAccum a = AAccum.getAccum();

	@Override
	public void run() {
		for (int x = 0; x < 98; x++) {
			a.updateCounter(1000);
			try {
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("one " + a.getCounter());
	}

}
