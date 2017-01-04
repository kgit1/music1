package aTupleGeneric;

//tuple - "kortez" - method how to return couple of elements not just one
//too return more than one parameter via return in method
//we create class with so many parameters how many we need to return 
//and with types which they must be
//and then just return this parameters through object of this class
public class TupleTest {
	static TwoTuple<String, Integer> f() {
		return new TwoTuple("hi", 47);
	}

	static ThreeTuple<Amphibian, String, Integer> g() {
		return new ThreeTuple(new Amphibian(), "hi", 47);
	}

	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return new FourTuple(new Vehicle(), new Amphibian(), "hi", 47);
	}

	static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
		return new FiveTuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);

		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}

}

class TwoTuple<A, B> {

	// final make field unchangeable after construction
	public final A first;
	public final B second;

	public TwoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + ",  " + second + ")";
	}

}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
	public final C third;

	public ThreeTuple(A first, B second, C third) {
		super(first, second);
		this.third = third;
	}

	@Override
	public String toString() {
		return "(" + first + ",  " + second + ", " + third + ")";
	}

}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
	public final D fourth;

	public FourTuple(A first, B second, C third, D fourth) {
		super(first, second, third);
		this.fourth = fourth;
	}

	@Override
	public String toString() {
		return "(" + first + ",  " + second + ", " + third + ", " + fourth
				+ ")";
	}

}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
	public final E fifth;

	public FiveTuple(A first, B second, C third, D fourth, E fifth) {
		super(first, second, third, fourth);
		this.fifth = fifth;
	}

	@Override
	public String toString() {
		return "(" + first + ",  " + second + ", " + third + ", " + fourth
				+ ", " + fifth + ")";
	}

}

class Amphibian {
}

class Vehicle {
}