package quizes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import aStore.Generator;

//demonstrates two classes haven't implementation of one interface, 
//but still working together and using one interface with help of inside anonymous classes of one interface
public class BankTeller {

	public static void serve(Teller t, Customer c) {
		System.out.println(t + " is serving " + c);
	}

	public static void main(String[] args) {
		Random rand = new Random(47);
		Queue<Customer> line = new LinkedList<Customer>();
		Generators.fill(line, Customer.generator(), 15);
		List<Teller> tellers = new ArrayList<Teller>();
		Generators.fill(tellers, Teller.generator, 4);

		for (Customer c : line) {
			serve(tellers.get(rand.nextInt(tellers.size())), c);
		}
	}

}

class Customer {

	// create static variable for counter
	private static long counter = 1;
	// create unchangeable private variable to hold counter and increment it
	// every time object created
	private final long id = counter++;

	// empty private constructor
	private Customer() {
	}

	@Override
	// toString returning objects id to keep tracking
	public String toString() {
		return "Customer [id=" + id + "]";
	}

	// method using anonymous class of interface Generator
	// to return new object of this class through method next()
	public static Generator<Customer> generator() {
		return new Generator<Customer>() {
			public Customer next() {
				return new Customer();
			};
		};
	}
}

class Teller {

	// create static variable for counter
	private static long counter = 1;
	// create unchangeable private variable to hold counter and increment it
	// every time object created
	private final long id = counter++;

	// empty private constructor
	private Teller() {
	}

	@Override
	// toString returning objects id to keep tracking
	public String toString() {
		return "Teller [id=" + id + "]";
	}

	// anonymous class of interface Generator
	// with method next() creating new object of this class
	public static Generator<Teller> generator = new Generator<Teller>() {
		// method inside anonymous class
		public Teller next() {
			return new Teller();
		};
	};
}

class Generators {
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen,
			int n) {
		for (int i = 0; i < n; i++) {
			coll.add(gen.next());
		}
		return coll;
	}
}
