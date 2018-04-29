import java.util.ArrayList;

/**
 * Binary Search Tree
 * 
 * @author Tai Dao
 * Date: 04/27/2018
 *
Requirements
a) Build up a Process BST. (MUST follow BST properties specified in textbook
and ppt slides. Your own tree structure will not be accepted.)

b) Insert a process to the BST based on its priority code.

c) Delete a process from the BST.

d) Make a sorted list of processes according to the priority codes from the BST.
*/
public class BstTester {

	public static void main(String[] args) {
		ArrayList <Process> A = new ArrayList<Process> ();
		int currentPID;
		Tree t = new Tree();
		
		
		// creates 20 Processes with random priorities into the Tree 
		for (int i = 0; i < 9 ; i++) {
			currentPID = i;
			Process newProcess = new Process(currentPID); 
			t.processInsert(newProcess);
		}
		
		t.inOrderTreeWalk(t.getRoot());
		
		
		Node z = t.treeSearch(t.getRoot(), 1000);
		System.out.print("Process found...   ");
		printNode(z);
		t.treeDelete(t, z);
		t.inOrderTreeWalk(t.getRoot());

		
	}
	
	public static void printNode(Node z) {
		System.out.println("Process: " + z.getKey().getPID() + "\t" + "Priority: " + z.getKey().getPriority());
	}
}
