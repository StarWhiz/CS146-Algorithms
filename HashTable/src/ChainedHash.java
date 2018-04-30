import java.util.LinkedList;

public class ChainedHash {
	
	/**
	 * This constructor takes in an array of Process LinkedLists and initializes
	 * each element in the array to a new LinkedList of Processes.
	 * 
	 * @param table
	 */
	ChainedHash(LinkedList<Process>[] table){
		for (int i = 0; i < table.length; i ++) { // for all elements in table...
			table[i] = new LinkedList<Process> (); // each element of the hash table is initialized to an empty linked list of Process's
		}
	}
	
	public void hashInsert(LinkedList<Process>[] table, Process p) {
		int hashResult = p.getPriority() % table.length; // this is the hash function
		table[hashResult].add(p); //A Process is added at the end of the LinkedList
	}
	
	public Process searchProcessByPriority (LinkedList<Process>[] table, int priority) {
		int hashResult = priority % table.length;
		int sizeOfLL = table[hashResult].size();
		Process p;
		
		for (int i = 0; i < sizeOfLL; i++) {
			p = (Process) table[hashResult].get(i);
			if (priority == p.getPriority()) {
				return p;
			}
		}
		return null;
	}
	
	public void printChainedHashTable (LinkedList<Process>[] table) {	
		for (int j = 0; j < table.length; j++) {
			int sizeOfLL = table[j].size();
			//System.out.println("Last Index in Linked List: " + sizeOfLL);
			System.out.println("______HashTable[" + j + "]______");
			for (int i = 0; i < sizeOfLL; i++) {
				printProcess((Process) table[j].get(i));
			}
			System.out.println();
		}
	}
	
	public static void printProcess(Process p) {
		System.out.print("PID: " + p.getPID() + ", ");
		System.out.println("Priority: " + p.getPriority());
	}
	
}
