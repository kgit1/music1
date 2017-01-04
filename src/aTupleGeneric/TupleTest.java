package aTupleGeneric;

public class TupleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TwoTuple<A, B> {
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

}
