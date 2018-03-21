/**
 * 
 * 
 * @author Tai Dao
 *
 */

import java.util.Arrays;

public class MultiTaskingSimulator {

	public static void main(String[] args) {
		int[] A = new int[20];
		initializeArray(A); // A now has 20 random numbers from 1-9999 simulating PIDs
		int aLength = A.length -1; // length of A
		System.out.println("This are the initial PIDs loaded: ");
		printArray(A);
		
		buildMaxHeap(A);
		printMenu();
	}
	
	/**
	 * This function takes an integer array and initializes it with
	 * random numbers from 1 to 9999.
	 * 
	 * @param int[] A
	 * @return int[] A
	 */
	private static int[] initializeArray (int[] A) {
		for(int i = 0; i < A.length; i++) {
			A[i] = (int)(Math.random()*9999 + 1);
		}
		return A;
	}
	
	private static void maxHeapify (int[] A, int i) {
		int largest;
		int a_heapSize = A.length - 1;
		
		int l = 2*i; //not sure
		int r = 2*i +1; //not sure
		if (l <= a_heapSize && A[l] > A[i]) {
			largest = l;
		}
		else {
			largest = i;
		}
		if (r <= a_heapSize && A[r] > A[largest]) {
			largest = r;
		}
		if (largest != i) {
			//EXCHANGE
			// MAX_HEAPIFY
		}
		
	}
	
	// TODO
	private static void buildMaxHeap(int[] A) {
		int a_length = A.length - 1;
		int a_heapSize = a_length;
		for (int i = 0; i < a_length/2; i++ ) {
		}
	}
	
	/**
	 * This function prints the menu for the user interface.
	 */
	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}
	
	/**
	 * This function prints an array that was passed to it.
	 * @param array
	 */
	private static void printArray(int[] array) {
		   System.out.println(Arrays.toString(array));
	}
}

