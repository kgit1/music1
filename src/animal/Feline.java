package animal;

public class Feline implements Animal {
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
