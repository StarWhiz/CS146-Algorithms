/**
 * 
 * 
 * @author Tai Dao
 *
 */
public class MultiTaskingSimulator {

	public static void main(String[] args) {
		int[] A = {18, 25, 6, 9, 15, 12, 5, 20, 11, 30};
		int r = A.length -1;
		
		BuildMaxHeap(A);
		PrintMenu();
	}
	
	private static void MaxHeapify (int[] A, int i) {
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
	private static void BuildMaxHeap(int[] A) {
		int a_length = A.length - 1;
		int a_heapSize = a_length;
		for (int i = 0; i < a_length/2; i++ ) {
		}
	}
	
	/**
	 * This Method Prints the menu
	 */
	private static void PrintMenu() {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}
}

