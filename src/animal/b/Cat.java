package animal.b;

public class Cat extends Feline{
	String name = "cat";

	@Override
	public void voice() {
		System.out.println("I'm a cat");

	}

	@Override
	public String toString() {
		return "Canine [name=" + name + "]";
	}
}
