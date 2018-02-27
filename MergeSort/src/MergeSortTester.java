/**
 * "Introduction to Algorithms - Thomas H. Cormen". 3rd edition. (PG 31 & 34).
 *    Merge Sort Pseudocode Translated By: Tai Dao
 *    Date Written: 02/23/18
 */
import java.util.Arrays;

public class MergeSortTester {

	public static void main(String[] args) {
		int[] arrayToSort = {18, 25, 6, 9, 15, 12, 5, 20, 11, 30};
		int p = 0;
		int r = arrayToSort.length -1;
		mergeSort(arrayToSort, p , r);
	}
	
	private static void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p+r)/2; //q means end of first array
			mergeSort(array, p, q);
			mergeSort(array, q +1, r);
			merge(array, p, q, r);
			printArray(array);
		}
	}
	
	private static void merge(int[] array, int p, int q, int r) {
		int n1 = q - p +1;
		int n2 = r - q;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1]; 
		
		for (int i = 0; i < n1; i++) {
			left[i] = array[p+i];
		}
		for (int j = 0; j < n2 ; j++) {
			right[j] = array[q+j+1];
		}
		
		left[n1] = 2147483647; // Maximum value for integers
		right[n2] = 2147483647; // used to represent infinity for sentinel
		int i = 0;
		int j = 0;
		
		for (int k = p; k <= r ; k++) {
			if (left[i] <= right[j]) {
				array[k] = left[i++];
			}
			else {
				array[k] = right[j++];
			}
		}	
	}

	private static void printArray(int[] array) {
	   System.out.println(Arrays.toString(array));
	}
}
