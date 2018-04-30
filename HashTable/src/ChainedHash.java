import java.util.LinkedList;

public class ChainedHash {
	
	/**
	 * This constructor takes in an array of Process LinkedLists and initializes
	 * each element in the array to a new LinkedList of Processes.
	 * 
	 * @param LinkedList<Process>[] table
	 */
	ChainedHash(LinkedList<Process>[] table){
		for (int i = 0; i < table.length; i ++) { // for all elements in table...
			table[i] = new LinkedList<Process> (); // each element of the hash table is initialized to an empty linked list of Process's
		}
	}
	
	/**
	 * This function takes in an array of Process LinkedLists and a process p.
	 * It puts the process p into the array as a result of hashing.
	 * 
	 * @param LinkedList<Process>[] table
	 * @param Process p
	 */
	public void hashInsert(LinkedList<Process>[] table, Process p) {
		int hashResult = p.getPriority() % table.length; // this is the hash function
		table[hashResult].add(p); //A Process is added at the end of the LinkedList
	}
	
	/**
	 * This function takes in an array of Process LinkedLists and an integer priority 
	 * as the key. It searches for a process that contains this priority and returns it.
	 * 
	 * @param LinkedList<Process>[] table
	 * @return Process p // If it doesn't find anything matching it returns null.
	 */
	public Process hashSearch (LinkedList<Process>[] table, int priority) {
		int hashResult = priority % table.length;
		int sizeOfLL = table[hashResult].size();
		Process p;
		
		for (int i = 0; i < sizeOfLL; i++) {
			p = table[hashResult].get(i);
			if (priority == p.getPriority()) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * This function takes in an array of Process LinkedLists and a Process p to remove.
	 * It then removes the Process from the table.
	 * @param LinkedList<Process>[] table
	 * @param Process p
	 */
	public void hashDelete (LinkedList<Process>[] table, Process p) {
		int hashResult = p.getPriority() % table.length;
		table[hashResult].remove(p);
	}
	
	/**
	 * This function takes in an array of Process LinkedLists and  prints the
	 * table with chaining for collisions.
	 * 
	 * @param LinkedList<Process>[] table
	 */
	public void printChainedHashTable (LinkedList<Process>[] table) {	
		for (int j = 0; j < table.length; j++) {
			int sizeOfLL = table[j].size();
			//System.out.println("Last Index in Linked List: " + sizeOfLL);
			System.out.println("______HashTable[" + j + "]______");
			for (int i = 0; i < sizeOfLL; i++) {
				printProcess(table[j].get(i));
			}
			System.out.println();
		}
	}
	
	/**
	 * This function is used to print the Process that was passed to it.
	 * 
	 * @param Process p
	 */
	public static void printProcess(Process p) {
		System.out.print("PID: " + p.getPID() + ", ");
		System.out.println("Priority: " + p.getPriority());
	}
	
}
