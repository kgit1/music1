package aLoggingException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggengExceptions2 {

	// create logger object with String with name of the Object
	// this object returns his out put in System.err form
	private static Logger logger = Logger.getLogger("Logging exception");

	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		// create e.printStackTrace(), usually it dosn't return String,
		// so we need printStackTrace with PrintWriter in argument
		// and StringWriter will help to return data with simple toString()
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}

	public static void main(String[] args) {
		try {
			int a = 0;
			int b = 2;
			int c = b / a;
			 System.out.println(c);
		} catch (Exception e) {
			logException(e);
			System.out.println("===========");
			e.printStackTrace();
		}
	}

}
