import java.util.LinkedList;

public class ChainedHashTable {
	LinkedList<Process> a;
	LinkedList[] hashTable;
	
	
	ChainedHashTable(){
		hashTable = new LinkedList[11];
		for (int i = 0; i < 11; i ++) {
			hashTable[i] = new LinkedList<Process> ();
		}
	}
	
	public void hashInsert(ChainedHashTable this, Process p) {
		int hashResult = p.getPriority() % 11;
		hashTable[hashResult].push(p);
	}
	
}
