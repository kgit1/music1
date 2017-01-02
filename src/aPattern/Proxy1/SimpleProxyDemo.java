package aPattern.Proxy1;

//proxy pattern - posrednik
public class SimpleProxyDemo {

	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}

}

interface Interface {
	void doSomething();

	void somethingElse(String string);
}

class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("doSomething real");

	}

	@Override
	public void somethingElse(String string) {
		System.out.println("somethingElse real " + string);

	}

}

// our proxy
class SimpleProxy implements Interface {

	// for realObject
	Interface proxied;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		System.out.println("doSomething proxy");
		proxied.doSomething();

	}

	@Override
	public void somethingElse(String string) {
		System.out.println("somethingElse proxy " + string);
		proxied.somethingElse(string);
	}

}
