package aLoggingException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception {

	// create logger object with String with name of the Object
	// this object returns his out put in System.err form
	private static Logger logger = Logger.getLogger("Logging exception");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		// create e.printStackTrace(), usually it dosn't return String,
		// so we need printStackTrace with PrintWriter in argument
		// and StringWriter will help to return data with simple toString()
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}

}
