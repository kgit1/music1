package aLoggingException;

public class ExceptiomMethods {

	public static void main(String[] args) {
		try {
			throw new Exception("my Exception");
		} catch (Exception e) {
			System.out.println("Exception caught");
			System.out.println("getMessage(): " + e.getMessage());
			System.out.println(
					"getLocalizedMessage(): " + e.getLocalizedMessage());
			System.out.println("toString(): " + e);
			System.out.println("printStackTrace(): ");
			e.printStackTrace();
		}

	}

}
