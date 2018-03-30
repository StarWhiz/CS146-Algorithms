import java.util.ArrayList;
import java.util.Collections;

public class Heap {
	static int a_HeapSize;
	/**
	 * This function takes an ArrayList of Processes and makes them adhere to the 
	 * maxHeap property where the parent processes have a higher priority than the
	 * children processes.
	 * 
	 * @param ArrayList<Process> A
	 */
	public static void buildMaxHeap(ArrayList<Process> A) {
		a_HeapSize = A.size() - 1; //(element of last index is ArraySize minus 1)
		for (int i = (A.size() - 1)/2; i >= 0; i--) {
			maxHeapify(A, i);
		}
	}
	
	/**
	 * This function is used by buildMaxHeap to recursively swap children nodes with 
	 * parent nodes if the child node has greater priority than the parent node.
	 * 
	 * @param ArrayList<Process> A, int i
	 */
	public static void maxHeapify (ArrayList<Process> A, int i) {
		int largest;
		int l = 2*i + 1;
		int r = 2*i + 2;
		if (l <= a_HeapSize && A.get(l).compareTo(A.get(i)) == 1) {
			//in compareTo Method a result of 1 means A[l] > A[i]
			largest = l;
		}
		else {
			largest = i;
		}
		if (r <= a_HeapSize && A.get(r).compareTo(A.get(largest)) == 1) {
			largest = r;
		}
		if (largest != i) {
			Collections.swap(A, i, largest);
			maxHeapify(A,largest);
		}
	}
	
	/**
	 * This function performs a heapSort of the ArrayList of Processes by priority
	 * 
	 * @param ArrayList<Process> A
	 */
	public static void heapSort(ArrayList<Process> A) {
		buildMaxHeap(A);
		for (int i = (A.size()-1); i >= 1 ; i--) {
			Collections.swap(A, 0, i);
			a_HeapSize = a_HeapSize - 1;
			maxHeapify(A,0);
		}
		a_HeapSize = A.size() - 1; // I added this in so printArrayList would function properly
	}
	
	/**
	 * This function extracts the process of the highest priority
	 * from the heap and re-maintains the heap property after extracting.
	 * 
	 * @param ArrayList<Process> A
	 */
	public static Process heapExtractMax(ArrayList<Process> A) {
		if (a_HeapSize < 0) {
			throw new RuntimeException("Error: Heap Underflow.");
		}
		Process max = A.get(0);


		A.set(0, A.get(a_HeapSize));
		
		A.remove(0);
		a_HeapSize--;
		maxHeapify(A,0);
		return max;
	}
	
	
	/**
	 * This function returns a process with the highest priority from the heap,
	 * but does not remove it from the heap.
	 * 
	 * @param ArrayList<Process> A
	 */
	public static Process heapMaximum(ArrayList<Process> A) {
		return A.get(0);
	}
	
	
	/**
	 * This function is used to add a new Process into the Heap. It initially creates a leaf 
	 * node with the lowest priority possible then calls heapIncreaseKey.
	 * 
	 * @param ArrayList<Process> A, Process p (key)
	 */
	public static void maxHeapInsert(ArrayList<Process> A, Process p) {
		a_HeapSize++;
		Process newProcess = new Process();
		newProcess.setPriority(0);
		A.add(newProcess);
		heapIncreaseKey(A, a_HeapSize, p);
	}
	
	
	/**
	 * This function first assigns the new leaf node created by maxHeapInsert to the key. 
	 * Then it constantly compares the child node with it's parent node. if the parent node is
	 * smaller the child node. The child node bubbles up until this condition is no longer true.
	 * 
	 * @param ArrayList<Process> A, int i (index), Process p (key)
	 */
	public static void heapIncreaseKey(ArrayList<Process> A, int i, Process p) {
		if (p.compareTo(A.get(i)) == -1) {
			throw new RuntimeException("Error: New key is smaller than current key.");
		}
		
		A.set(i, p);
		
		while (i > 0 && A.get((i-1)/2).compareTo(A.get(i)) == -1) {	
			Collections.swap(A, (i-1)/2, i);
			i = (i-1)/2; //(i-1)/2 is the parent of child i
		}
	}
	
	/**
	 * Returns the heap size. Used for printing in Main.
	 * @return a_HeapSize
	 */
	public static int getHeapSize() {
		return a_HeapSize;
	}
}
