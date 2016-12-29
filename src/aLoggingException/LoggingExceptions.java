package aLoggingException;

public class LoggingExceptions {

	public static void main(String[] args) {
		try{
			throw new LoggingException();
		}catch(LoggingException e){
			System.err.println("Exception cought: " + e);
		}
		
		try{
			throw new LoggingException();
		}catch(LoggingException e){
			System.err.println("Exception cought: " + e);
		}

	}

}
