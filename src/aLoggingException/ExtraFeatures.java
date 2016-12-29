package aLoggingException;

public class ExtraFeatures {

	public static void f() throws MyException {
		System.out.println("MyException in f()");
		// simple exception
		throw new MyException();
	}

	public static void g() throws MyException {
		System.out.println("MyException in g()");
		// exception with method name
		throw new MyException("Initiated in g()");
	}

	public static void h() throws MyException {
		System.out.println("MyException in h()");
		// exception with method name and some value
		throw new MyException("Initiated in h()", 47);
	}

	public static void main(String[] args) {

		try {
			f();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}

		try {
			g();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}

		try {
			h();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}

	}

}
