package quizes;

class Father {

	public String name = "John Senior";

	public void shine() {

		System.out.println(name + "'s shining");

	}

}

class Son extends Father {

	public String name = "John Junior";

	public void shine() {

		System.out.println(name + "'s shining");

	}

}

public class Quiz9 {

	public static void main(String[] args) {

		Father f1 = new Son();

		System.out.println(f1.name);

		f1.shine();

	}

}
