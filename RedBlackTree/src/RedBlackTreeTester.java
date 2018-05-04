
public class RedBlackTreeTester {
	static RBTree t = new RBTree();
	static int currentPID = 0;
	
	public static void main(String[] args) {

		System.out.println("Hello World");
		
		// creates 20 Processes with random priorities into the Tree 
		for (int i = 0; i < 20 ; i++) {
			Process newProcess = new Process(currentPID); 
			t.processInsert(newProcess);
			currentPID++;
		}

	}

}
