/**
 * 
 *  Due Friday Next Week 11:59 PM. March 30.
 * @author Tai Dao
 *
 */
import java.util.ArrayList;

public class MultiTaskingSimulator {
	static int a_HeapSize;
	
	public static void main(String[] args) {
		ArrayList <Process> A = new ArrayList<Process> ();
		int currentPID;
		

		for (int i = 0; i < 15 ; i++) {
			//A.add(new Process(i));
			currentPID = i;
			A.add(new Process(i)); // add 20 Processes into ArrayList
		}
    
		printArrayList(A);
		buildMaxHeap(A);
		//heapSort(A);
		
		System.out.println();
		System.out.println();
		printArrayList(A);
		
		System.out.println();
		System.out.println();
		System.out.println(heapExtractMax(A));
		System.out.println();
		
		printArrayList(A);
	}
	
	/**
	 * This function takes an ArrayList of Processes and makes their priorities adhere to the max heap property.
	 * @param ArrayList<Process> A
	 */
	private static void buildMaxHeap(ArrayList<Process> A) {
		a_HeapSize = A.size()-1; //(element of last index is ArraySize minus 1)
		for (int i = (A.size()-1)/2; i >= 0; i--) {
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

		int l = 2*i;
		int r = 2*i + 1;

		if (l <= a_HeapSize && A.get(l).getPriority() > A.get(i).getPriority()) {
			largest = l;
		}
		else {
			largest = i;
		}
		if (r <= a_HeapSize && A.get(r).getPriority() > A.get(largest).getPriority()) {
			largest = r;
		}
		if (largest != i) {
			swapArrayElements(i, largest, A);
			maxHeapify(A,largest);
		}
	}
	
	/**
	 * This function performs a heapsort of the ArrayList of Proccses by priority
	 * 
	 * @param ArrayList<Process> A
	 */
	public static void heapSort(ArrayList<Process> A) {
		buildMaxHeap(A);	
		for (int i = a_HeapSize; i >= 1 ; i--) {
			swapArrayElements(0, i, A);
			a_HeapSize--;
			maxHeapify(A,0);
		}
	}
	
	/**
	 * This function extracts the process of the highest priority from the heap.
	 * 
	 * @param ArrayList<Process> A
	 */
	public static int heapExtractMax(ArrayList<Process> A) {
		if (a_HeapSize < 0) {
			throw new RuntimeException("Heap Underflow.");
		}
		int max = A.get(0).getPriority();
		A.get(0).setPriority(A.get(a_HeapSize).getPriority());
		a_HeapSize--;
		maxHeapify(A,0);
		return max;
	}
	
	/**
	 * This function returns a process with the highest priority from the heap.
	 * 
	 * @param ArrayList<Process> A
	 */
	public static int heapMaximum(ArrayList<Process> A) {
		return A.get(0).getPriority();
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

