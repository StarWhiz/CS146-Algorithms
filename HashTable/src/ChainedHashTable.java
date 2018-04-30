import java.util.LinkedList;

public class ChainedHashTable {
	//LinkedList<Process> a;
	LinkedList[] hashTable; // array of linked lists..
	
	
	ChainedHashTable(){
		hashTable = new LinkedList[11]; // array of linked lists supports 11 elements.
		for (int i = 0; i < 11; i ++) { // for all elements...
			hashTable[i] = new LinkedList<Process> (); // each element of the hash table is initialized to an empty linked list of Process's
		}
		

		
	}
	
	public void hashInsert(ChainedHashTable this, Process p) {
		int hashResult = p.getPriority() % 11; // this is the hash function
		hashTable[hashResult].add(p); //A Process is added at the end of the LinkedList
	}
	
	public Process getProcess (int index) {
		return (Process) hashTable[index].element();
	}
	
	public void printHashTable () {	
		for (int j = 0; j < 11; j++) {
			int sizeOfLL = hashTable[j].size();
			//System.out.println("Last Index in Linked List: " + sizeOfLL);
			System.out.println("______HashTable[" + j + "]______");
			for (int i = 0; i < sizeOfLL; i++) {
				printProcess((Process) hashTable[j].get(i));
			}
			System.out.println();
		}
	}
	
	public static void printProcess(Process p) {
		System.out.print("PID: " + p.getPID() + ", ");
		System.out.println("Priority: " + p.getPriority());
	}
	
}
