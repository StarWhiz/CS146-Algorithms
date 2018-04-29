/**
 * Process Hash Tables
 * @author Tai Dao
 *
a) Create a 11-slots separate chaining Hash Table for the 20 processes.
b) Insert a process to the chaining Hash Table.
c) Search a process's name by entering a priority code.
d) Delete a process from the chaining Hash Table.
e) Make a list of processes in the hash table.
 */
public class HashTableTester {
	static ChainedHashTable hashTable = new ChainedHashTable();
	static int currentPID = 0;

	public static void main(String[] args) {
		// creates 20 Processes with random priorities into the Tree 
		for (int i = 0; i < 20 ; i++) {
			Process newProcess = new Process(currentPID); 
			hashTable.hashInsert(newProcess);
			currentPID++;
		}
		
		Process tempProcess2 = hashTable.getProcess(0);
		printProcess(tempProcess2);
	}
	
	public static void printProcess(Process p) {
		System.out.print("PID: " + p.getPID() + ", ");
		System.out.println("Priority: " + p.getPriority());
	}

}
