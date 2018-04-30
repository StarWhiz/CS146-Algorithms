import java.util.LinkedList;
import java.util.Scanner;

/**
 * Process Hash Tables
 * @author Tai Dao
 *
 */
public class HashTableTester {
	static LinkedList<Process>[] table = new LinkedList[11]; // Array of linked lists. Has 11 slots for a 11-slot chaining hash table.
	static ChainedHash chainedHash = new ChainedHash(table);
	static int currentPID = 0;

	public static void main(String[] args) {
		// create 20 Processes with random priorities into the table 
		for (int i = 0; i < 20 ; i++) {
			Process newProcess = new Process(currentPID); 
			chainedHash.hashInsert(table, newProcess);
			currentPID++;
		}
		startMenu();
	}
	
	/**
	 * This function displays a menu with operations that can be done to the
	 * chaining hash table.
	 */
	public static void startMenu() {
		String choice = null;
		boolean validInput;
		while (choice != "q" || choice != "Q") {
			System.out.println();
			System.out.println("************ Menu Of Availiable Options ************");
			System.out.println("1. Show sorted list Processes from chaining hash table.");
			System.out.println("2. Search for a Process ID from the chaining hash table based on it's priority.");
			System.out.println("3. Delete a Process from the chaining hash table based on it's PID.");
			System.out.println("4. Insert a random process into the chaining hash table.");
			System.out.println("Q. Quit.\n");
			System.out.print("Please type in an option and press enter: ");
		    Scanner scan = new Scanner(System.in);
	    	Scanner scanPriority = new Scanner(System.in);
		    choice = scan.nextLine();
		    System.out.println();
		    
		    switch(choice) {
			    case "1": 
			    	chainedHash.printChainedHashTable(table);
			    	break;
			    case "2": 
			    	validInput = false;
			    	while (!validInput) {
				    	int priorityInput;
				    	System.out.println("Here is a list of all the processes currently running: ");
				    	chainedHash.printChainedHashTable(table);
				    	System.out.print("\nPlease enter the priority of the process ID you want to find: ");
				    	while (!scanPriority.hasNextInt()) {
				    		scanPriority.next();
				    	}
				    	priorityInput = scanPriority.nextInt();
				    	Process found = chainedHash.hashSearch(table, priorityInput);
						
						
						if (found == null) {
							System.out.println("Cannot find a process with priority " + priorityInput + "... Please try again...");
							validInput = false;
						}
						else {
							validInput = true;
							System.out.println("The Process's Name with this priority is: " + found.getPID());
						}
			    	}
			    	break;
			    case "3": 
			    	validInput = false;
			    	while (!validInput) {
				    	int priorityInput;
				    	System.out.println("Here is a list of all the processes currently running: ");
				    	chainedHash.printChainedHashTable(table);
				    	System.out.print("\nPlease enter the priority of the Process you want to delete: ");
				    	while (!scanPriority.hasNextInt()) {
				    		scanPriority.next();
				    	}
				    	priorityInput = scanPriority.nextInt();
				    	Process found = chainedHash.hashSearch(table, priorityInput);

						if (found == null) {
							System.out.println("Cannot find a process with priority " + priorityInput + "... Please try again...");
							validInput = false;
						}
						else {
							validInput = true;
							//TODO Call Delete
						}
			    	}
			    	break;
			    case "4":
			    	/**
					Process newProcess = new Process(currentPID); 
			    	currentPID++;
					System.out.println("This process will be inserted: ");
					printProcess(newProcess);
					hashTable.hashInsert(newProcess);
					hashTable.printHashTable();
					*/
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
	
	/**
	 * This function is used to print the Process that was passed to it
	 * @param Process p
	 */
	public static void printProcess(Process p) {
		System.out.print("PID: " + p.getPID() + ", ");
		System.out.println("Priority: " + p.getPriority());
	}
}
