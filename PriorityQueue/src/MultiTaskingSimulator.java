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
			A.add(new Process(i));
			//A.add(new Process()); // add 20 Processes into ArrayList
		}
		
		printArrayList(A);
		buildMaxHeap(A);
		
		System.out.println();
		System.out.println();
		
		printArrayList(A);
	}
	
	/**
	 * This function takes an integer array and makes it adhere to the max heap property.
	 * @param int[] A
	 */
	private static void buildMaxHeap(ArrayList<Process> A) {
		for (int i = A.size()/2; i >= 0; i--) {
			maxHeapify(A, i);
		}
	}
	
	/**
	 * This function is used by buildMaxHeap to recursively swap children nodes with 
	 * parent nodes if the child node is greater than the parent node.
	 * @param int[] A
	 * @param i
	 */
	private static void maxHeapify (ArrayList<Process> A, int i) {
		int largest = i;

		
		int a_heapSize = A.size();
		System.out.println("problem size:" + a_heapSize);
	
		int l = 2*i;
		System.out.println("problem int l:" + l);
		int r = 2*i + 1;

		if (l <= a_heapSize && A.get(l).getPriority() > A.get(i).getPriority()) {
			largest = l;
		}
		else {
			largest = i;
		}
		if (r <= a_heapSize && A.get(r).getPriority() > A.get(largest).getPriority()) {
			largest = r;
		}
		if (largest != i) {
			swapArrayElements(i, largest, A);
			maxHeapify(A,largest);
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
	
	private static void swapArrayElements(int i, int j, ArrayList<Process> A) {
		//System.out.println("Swapping i: " + A.get(i).getPriority());
		//System.out.println("Swapping largest: " + A.get(j).getPriority());
		int z = A.get(i).getPriority();
		A.get(i).setPriority(A.get(j).getPriority());
		A.get(j).setPriority(z);
		
		//System.out.println("i is now: " + A.get(i).getPriority());
		//System.out.println("largest is now: " + A.get(j).getPriority());
	}
	
}

