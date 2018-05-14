import java.util.Scanner;

public class RedBlackTreeTester {
	static TreeRB t = new TreeRB();
	static int currentPID = 0;
	
	public static void main(String[] args) {

		System.out.println("Hello World");
		
		// creates 20 Processes with random priorities into the Tree 
		for (int i = 0; i < 20 ; i++) {
			Process newProcess = new Process(currentPID); 
			t.processInsert(newProcess);
			currentPID++;
		}
		startMenu();

	}
	
	/**
	 * This function is used to print the key Node that was passed to it
	 * @param Node z
	 */
	public static void printNodeKey(Node z) {
		System.out.println("Process Name: " + z.getKey().getPID() + "\t" + "Priority: " + z.getKey().getPriority());
		System.out.println();
	}
	
	/**
	 * This function is used to print the Process that was passed to it
	 * @param Process p
	 */
	public static void printProcess(Process p) {
		System.out.println("Process Name: " + p.getPID() + "\t" + "Priority: " + p.getPriority());
		System.out.println();
	}
	
	/**
	 * This function displays a menu with operations that can be done to a
	 * binary search tree.
	 */
	public static void startMenu() {
		String choice = null;
		while (choice != "q" || choice != "Q") {
			System.out.println();
			System.out.println("************ Menu Of Availiable Options ************");
			System.out.println("1. Show sorted list Processes from binary search tree. (inOrderTreeWalk)");
			System.out.println("2. Delete a process from the tree based on it's priority.");
			System.out.println("3. Insert a random process into the binary search tree");
			System.out.println("Q. Quit.\n");
			
			System.out.print("Please type in an option and press enter: ");
		    Scanner scan = new Scanner(System.in);
	    	Scanner scanPriority = new Scanner(System.in);
		    choice = scan.nextLine();
		    System.out.println();
		    switch(choice) {
			    case "1": 
					t.inOrderTreeWalk(t.getRoot());
			    	break;
			    case "2": 
			    	boolean validInput = false;
			    	while (!validInput) {
				    	int priorityInput;
				    	System.out.println("Here is a list of all the processes currently running: ");
						t.inOrderTreeWalk(t.getRoot());
				    	System.out.print("\nPlease enter the priority of the process you want to delete: ");
				    	while (!scanPriority.hasNextInt()) {
				    		scanPriority.next();
				    	}
				    	priorityInput = scanPriority.nextInt();
				    	
						Node z = t.rbSearch(t.getRoot(), priorityInput);
						
						if (z == t.getNil()) {
							System.out.println("Invalid input... Please try again...");
							validInput = false;
						}
						else {
							validInput = true;
							t.rbDelete(t, z);
							t.inOrderTreeWalk(t.getRoot());	
							System.out.print("\nThe Process Deleted Was...");
							printNodeKey(z);
						}
			    	}
			    	break;
			    case "3": 
					Process newProcess = new Process(currentPID); 
			    	currentPID++;
					System.out.println("This process will be inserted: ");
					printProcess(newProcess);
					t.processInsert(newProcess);
					t.inOrderTreeWalk(t.getRoot());
			    	break;
			    case "Q": 
			    case "q": 
			    	scan.close();
			    	scanPriority.close();
			    	System.out.println("Exiting... Thank you and have a nice day!");
			    	System.exit(1);
			    	break;
			    default:
			    	System.out.println("Invalid Choice. Please try again.\n");
		    }
		}	
	}

}
