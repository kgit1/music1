package quizes;

import java.util.Arrays;

public class fib {

	public static void main(String[] args) {
		int[] n = new int[50];
		n[0] = 0;
		n[1] = 1;
		for(int i =2;i<n.length;i++){
			n[i] = n[i-1]+n[i-2];
		}
		System.out.println(Arrays.toString(n));

	}

}
//1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946
