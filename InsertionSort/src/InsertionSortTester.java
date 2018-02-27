/**
 * "Introduction to Algorithms - Thomas H. Cormen". 3rd edition. (18).
 *    Insertion Sort Pseudocode Translated By: Tai Dao
 *    Date Written: 02/23/18
 */

import java.util.Arrays;
public class InsertionSortTester {
	public static void main(String[] args) {
		int[] arrayToSort = {18, 25, 6, 9, 15, 12, 5, 20, 11, 30};
		int key;
		int i;
		printArray(arrayToSort);
		for (int j = 2; j < arrayToSort.length - 1 ; j++) {
			key = arrayToSort[j];
			// Inserting key into sorted Array
			i = j - 1;
			while (i >= 0 && arrayToSort[i] > key){
				arrayToSort[i+1] = arrayToSort[i];
				i = i - 1;
			}
			arrayToSort[i+1] = key;
			printArray(arrayToSort);
		}
	}
	
   private static void printArray(int[] array) {
	   System.out.println(Arrays.toString(array));
   }
}
