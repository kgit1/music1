package animal.b;

public abstract class Animal {
	String name = "animal";

	abstract void voice();
	
	void getName(){
		System.out.println(name);
	}

}
