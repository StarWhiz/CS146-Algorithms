import java.util.Arrays;

public class CountingSortTester {

	public static void main(String[] args) {
		int[] A = {5, 5, 0, 6, 2, 0, 1, 3, 2, 6, 1, 4, 2, 4};
		System.out.print("This is A: ");
		printArray(A);
		
		int[] B = new int[A.length];
		countingSort(A, B, 6);
		//printArray(A);
	}
	
	public static void countingSort(int[] A, int[] B, int k ) {
		int[] C = new int [k+1];
		//Initialize C with 0s
		for (int i = 0; i < k; i++) {
			C[i] = 0;
		}
		
		//Inspect each element in A
		for (int j = 0; j < A.length; j++) {
			//System.out.println("This is A.length: " +  A.length);
			//System.out.println("This is A[j]: " + A[j]);
			C[A[j]]++;	
			System.out.print("This is C: ");
			printArray(C);
		}
		
		//Determine...
		for (int i = 1; i <= k; i++) { // this can be left alone?
			//System.out.println("This is C[i]: " + C[i]);
			//System.out.println("This is C[i-1]: " + C[i-1]);
			C[i] = C[i] + C[i-1];
			System.out.print("This is C after calculating: ");
			printArray(C);

		}
		
		for (int j = A.length - 1; j >= 0; j--) {
			//System.out.println("This is A.length: " +  A.length);
			System.out.println("This is A[j]: " + A[j]);
			System.out.println("This is C[A[j]]: " + C[A[j]]);
			//System.out.println("This is B.length: " +  B.length);
			B[C[A[j]]-1] = A[j];
			C[A[j]]--;
			System.out.println("This is C[A[j]] After: " + C[A[j]]);
			System.out.print("This is B: ");
			printArray(B);
		}
		
	}

	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}
}
