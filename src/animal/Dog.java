package animal;

public class Dog extends Canine{

	String name = "dog";

	@Override
	public void voice() {
		System.out.println("I'm a dog");

	}

	@Override
	public String toString() {
		return "Canine [name=" + name + "]";
	}
}
