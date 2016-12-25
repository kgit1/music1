package animal.b;

public class Feline extends Animal {
	String name = "feline";

	@Override
	public void voice() {
		System.out.println("I'm feline");

	}

	@Override
	public String toString() {
		return "Feline [name=" + name + "]";
	}

}
