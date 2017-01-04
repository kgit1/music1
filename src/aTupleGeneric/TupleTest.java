package aTupleGeneric;

//tuple - "kortez" - method how to return couple of elements not just one
public class TupleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TwoTuple<A, B> {
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