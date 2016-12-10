package aThreads;
//app shows that jvm every time will give different time for every thread to work

//thread to start needs runnable object with method run which tell to tread 
//what to do
//so we implements Runnable interface to class which will tell thread what to do
public class RunThreads implements Runnable {

	public static void main(String[] args) {
		// instantiate
		RunThreads runner = new RunThreads();
		// create thread and give him Runnable object with directives
		// but thread will be just created but not started
		Thread alpha = new Thread(runner);
		// create thread and give him Runnable object with directives
		// but thread will be just created but not started
		Thread beta = new Thread(runner);
		// name the thread(optional)
		alpha.setName("Thread Alpha");
		// name the thread(optional)
		beta.setName("Thread Beta");
		// start the thread
		alpha.start();
		// start the thread
		beta.start();
		for (int i = 0; i < 25; i++) {
			System.out.println("-----Thread MAIN----");
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName);
		}
	}

}
