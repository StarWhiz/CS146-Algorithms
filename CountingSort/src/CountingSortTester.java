import java.util.Arrays;

public class CountingSortTester {

	public static void main(String[] args) {
		int[] A = {5, 5, 0, 6, 2, 0, 1, 3, 2, 6, 1, 4, 2, 4};
		System.out.print("A: ");
		printArray(A);
		
		int k = maximumElement(A);
		int[] B = new int[A.length]; //Empty array with same number of elements as A
		countingSort(A, B, k);
	}
	
	/**
	 * This function performs counting sort.
	 * @param A - Original array
	 * @param B - Array to store sorted elements
	 * @param k - Highest value element in A
	 */
	public static void countingSort(int[] A, int[] B, int k ) {
		int[] C = new int [k+1];
		//Initialize C with 0s
		for (int i = 0; i < k; i++) {
			C[i] = 0;
		}
		
		//Inspect each element in A
		for (int j = 0; j < A.length; j++) {
			C[A[j]]++;	
			System.out.print("C (Counting): ");
			printArray(C);
		}
		
		//Determine...
		for (int i = 1; i <= k; i++) { // this can be left alone?
			C[i] = C[i] + C[i-1];
			System.out.print("C (Running Sum): ");
			printArray(C);

		}
		
		for (int j = A.length - 1; j >= 0; j--) {
			B[C[A[j]]-1] = A[j];
			C[A[j]]--;
			System.out.print("C (Decrement): ");
			printArray(C);
			System.out.print("B: ");
			printArray(B);
		}
	}
	
	/**
	 * This function determines the max k for an array with int elements from 0, 1, 2 ... to k
	 * @param A - The array of integers
	 * @return max - The greatest element from the array.
	 */
	public static int maximumElement (int[] A) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i++) {
		      if(A[i] > max) {
		         max = A[i];
		      }
		}
		return max;
	}

	/**
	 * This function prints an int array that was passed into it.
	 * @param A - The array of integers
	 */
	public static void printArray(int[] A) {
		System.out.println(Arrays.toString(A));
	}
}
