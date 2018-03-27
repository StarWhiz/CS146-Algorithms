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
			//A.add(new Process(i));
			A.add(new Process(i)); // add 20 Processes into ArrayList
		}
		
		printArrayList(A);
		buildMaxHeap(A);
		
		System.out.println();
		System.out.println();
		
		printArrayList(A);
	}
	
	/**
	 * This function takes an ArrayList of Processes and makes their priorities adhere to the max heap property.
	 * @param ArrayList<Process> A
	 */
	
	private static void buildMaxHeap(ArrayList<Process> A) {
		int aHeapSize = A.size();
		for (int i = aHeapSize/2; i >= 0; i--) {
		
			maxHeapify(A, i);
		}
	}
	
	/**
	 * This function is used by buildMaxHeap to recursively swap children nodes with 
	 * parent nodes if the child node is greater than the parent node.
	 * @param ArrayList<Process> A
	 * @param i
	 */
	private static void maxHeapify (ArrayList<Process> A, int i) {
		int largest;
		int a_heapSize = A.size();
		int l = 2*i;
		int r = 2*i + 1;

		if (l < a_heapSize && A.get(l).getPriority() > A.get(i).getPriority()) {
			largest = l;
		}
		else {
			largest = i;
		}
		if (r < a_heapSize && A.get(r).getPriority() > A.get(largest).getPriority()) {
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
	
	/**
	 * This method swaps the priorities of the selected processes from an ArrayList of processes
	 * 
	 * @param index i
	 * @param index j
	 * @param ArrayList<Process> A
	 */
	private static void swapArrayElements(int i, int j, ArrayList<Process> A) {
		int z = A.get(i).getPriority();
		A.get(i).setPriority(A.get(j).getPriority());
		A.get(j).setPriority(z);		
	}
	
}

