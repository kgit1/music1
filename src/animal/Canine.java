package animal;

public class Canine implements Animal{

	String name = "canine";

	@Override
	public void voice() {
		System.out.println("I'm canine");

	}

	@Override
	public String toString() {
		return "Canine [name=" + name + "]";
	}
	

}
