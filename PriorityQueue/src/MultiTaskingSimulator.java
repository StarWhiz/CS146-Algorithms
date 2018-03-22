/**
 * 
 * 
 * @author Tai Dao
 *
 */

import java.util.Arrays;
import java.util.ArrayList;

public class MultiTaskingSimulator {

	public static void main(String[] args) {
		ArrayList <Process> A = new ArrayList<Process> ();
		for (int i = 0; i < 20 ; i++) {
			A.add(new Process()); // add 20 Processes into ArrayList
		}
		
		printArrayList(A);
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
	 * This function prints the priorities of all elements of the
	 * ArrayList <Process> that was passed to it.
	 * 
	 * @param ArrayList<Process>
	 */
	private static void printArrayList(ArrayList<Process> A) {
		for (int i = 0; i < A.size() ; i++) {
			System.out.print(A.get(i).getPriority() + " ");
			if (i == A.size()/2) {
				System.out.println();
			}
		}
	}
}

