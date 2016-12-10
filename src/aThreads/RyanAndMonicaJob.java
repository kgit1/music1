package aThreads;

//app shows how unpredictable switches of threads in jvm
//creates situation where threads can put account "below zero" in spite of the 
//fact that we have if check ->"if (account.getBalance() >= amount)" to do 
//transaction only when it can and with positive number or zero on account
//it happens because during the time of operation
//thread can be switched by jvm, than another thread works his work, and 
//switched back and our thread doesn't kwon that he was sleeping in the middle 
//of the operation where check was already done, but transaction still 
//wasn't finished
public class RyanAndMonicaJob implements Runnable {

	private BankAccount account = new BankAccount();

	public static void main(String[] args) {
		RyanAndMonicaJob theJob = new RyanAndMonicaJob();
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
		System.out.println("-------" + Thread.currentThread().getName()
				+ " thread---------");

	}

	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			makeWithdraw(10);
			if (account.getBalance() < 0) {
				System.out.println("Warning!!! Overdraft!!!");
			}
		}
	}

	private void makeWithdraw(int amount) {
		if (account.getBalance() >= amount) {
			System.out.println(
					Thread.currentThread().getName() + " preparing to withraw");
			try {
				System.out.println(
						Thread.currentThread().getName() + " goes to sleep");
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " awakes");
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName()
					+ ": transaction complete");
		} else {
			System.out.println("Sorry, there are not enought money for client "
					+ Thread.currentThread().getName() + " on account");
		}
	}

}
