package aLoggingException;

public class MyException extends Exception {

	int x;

	// empty constructor
	public MyException() {
	}
	
	//not empty constructors to support more useful data
	// constructor with String argument
	public MyException(String mgs) {
		super(mgs);
	}

	// constructor with String and int arguments
	public MyException(String mgs, int x) {
		super(mgs);
		this.x = x;
	}

	public int value() {
		return x;
	}

	//method to return overall data
	public String getMessage() {
		return "Detailed report: " + x + " " + super.getMessage();
	}

}
