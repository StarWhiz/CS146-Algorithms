import java.util.Arrays;

/**
 * 
 * @author Froz
 *
 */
public class MergeSortTester {

	public static void main(String[] args) {
		int[] arrayToSort = {18, 25, 6, 9, 15, 12, 5, 20, 11, 30};
		
		mergeSort(arrayToSort, 0 , arrayToSort.length);
		
		
		
	}
	private static void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p+r)/2;
			mergeSort(array, p, q);
			mergeSort(array, q +1, r);
			merge(array, p, q, r);
			printArray(array);
		}
	}
	
	private static void merge(int[] array, int p, int q, int r) {
		int n1 = q - p +1;
		int n2 = r - q;
		int i2;
		int j2;
		
		int[] left = new int[n1 + 1]; //not sure about this
		int[] right = new int[n2 + 1];  //not sure about this
		
		for (int i = 1; i < n1; i ++) {
			left[i] = array[p + i -1];
		}
		for (int j = 1; j < n2 ; j++) {
			right[j] = array[q+j];
		}
		left[n1 + 1] = 9999;
		right[n2 +1] = 9999;
		i2 = 1;
		j2 = 1;
		for (int k = 0 ; p < r ; k++) {
			if (left[i2] <= right[j2]) {
				array[k] = left[i2];
				i2++;
			}
			else {
				array[k] = right[j2];
				j2++;
			}
		}	
	}

	private static void printArray(int[] array) {
	   System.out.println(Arrays.toString(array));
	}
}
