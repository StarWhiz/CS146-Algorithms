import java.util.LinkedList;

public class ChainedHashTable {
	LinkedList<Process> a;
	LinkedList[] hashTable;
	
	
	ChainedHashTable(){
		hashTable = new LinkedList[11];
		for (int i = 0; i < 11; i ++) {
			hashTable[i] = new LinkedList<Process> (); // each element of the hash table is initialized to an empty linked list
		}
		

		
	}
	
	public void hashInsert(ChainedHashTable this, Process p) {
		int hashResult = p.getPriority() % 11; // this is the hash function
		hashTable[hashResult].add(p); //A Process is pushed into the LinkedList
		
		//Process tempProcess = (Process) hashTable[hashResult].element();
		//printProcess(tempProcess);
	}
	
	public Process getProcess (int index) {
		return (Process) hashTable[index].element();
	}


	
	public static void printProcess(Process p) {
		System.out.print("PID: " + p.getPID() + ", ");
		System.out.println("Priority: " + p.getPriority());
	}
	
}
