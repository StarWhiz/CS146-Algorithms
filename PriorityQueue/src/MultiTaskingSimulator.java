/**
 * 
 * 
 * @author Tai Dao
 *
 */

import java.util.Arrays;

public class MultiTaskingSimulator {

	public static void main(String[] args) {
		
		//int[] A = {12, 11, 3, 17, 13, 4, 1, 7, 19, 18, 15, 5, 17, 2, 20, 10, 14, 5, 6, 16}; //test PIDs
		int[] A = new int[20];
		initializeArray(A); // A now has 20 random numbers from 1-9999 simulating PIDs
		int aLength = A.length -1; // length of A
		
		System.out.println("This are the initial PIDs loaded: ");
		printArray(A);
		
		buildMaxHeap(A);
		printArray(A);
		//printMenu();
	}
	
	/**
	 * This function takes an integer array and initializes it with
	 * random numbers from 1 to 9999.
	 * 
	 * @param int[] A
	 */
	private static void initializeArray (int[] A) {
		for(int i = 0; i < A.length; i++) {
			A[i] = (int)(Math.random()*9999 + 1);
		}
	}
	
	/**
	 * This function takes an integer array and makes it adhere to the max heap property.
	 * @param int[] A
	 */
	private static void buildMaxHeap(int[] A) {
		int a_heapSize =  A.length - 1; // not sure why this was in the pseudo-code...
		for (int i = (A.length - 1)/2; i >= 0; i-- ) {
			System.out.println(i);
			maxHeapify(A, i);
		}
	}
	
	/**
	 * This function is used by buildMaxHeap to recursively swap children nodes with 
	 * parent nodes if the child node is greater than the parent node.
	 * @param int[] A
	 * @param i
	 */
	private static void maxHeapify (int[] A, int i) {
		int largest = i;
		int a_heapSize = (A.length -1);
	
		int l = 2*i ; //not sure
		int r = 2*i + 1; //not sure
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
			//swapElements(A[i],A[largest], A);
			  int t = A[i];
			  A[i] = A[largest];
			  A[largest] = t;
			maxHeapify(A,largest);
		}
	}
	//
	//private static void swapElements(int i, int j, int[] A) {
	//
	//}
	

	
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

