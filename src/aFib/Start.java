package aFib;
import java.util.Arrays;
import java.util.Random;

public class Start {
	public static void main(String[] args) {

		//nt [] arr = {2,5,7,8,9,5,4,8,5,25};
		
		int arr2 [] = new int [5];
		arr2[0] = 150;
		arr2[1] = 32;
		arr2[2] = 1050;
		arr2[3] = -18;
		arr2[4] = 0;
		//System.out.println(arr2.length);
		
		Random r = new Random();
	//	int x = r.nextInt(100)-50;
		
		/*for (int i = 0; i < arr2.length; i++) {
			arr2[i] = r.nextInt(100)-50;
			System.out.print(arr2[i] + " ");
			
		}
		System.out.println();*/
		
	//	Arrays.sort(arr2);
		
		
		/*for (int i = 0; i < arr2.length-1; i++) {
			for (int j = i+1; j < arr2.length; j++) {
				if(arr2[i]>arr2[j]){
					int temp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = temp;
				}
				
			}
		}
		
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}*/
		
		
		int [][] mass = new int [5][10];
		
		for (int i = 0; i < mass.length; i++) {
			for (int j = 0; j < mass[i].length; j++) {
				mass[i][j] = new Random().nextInt(50);
				System.out.print(mass[i][j] + " ");
				
			}
			System.out.println();
		}
		
		
		int [][] mx = {
						{5,8,6},
						{1,5,8,9,9},
						{20,5,7,4,0,5,8,7}
					  };
		
		
		
	}
}
