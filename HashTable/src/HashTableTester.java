import java.util.LinkedList;
import java.util.Scanner;

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
		
		startMenu();

	}
	

	
	/**
	 * This function displays a menu with operations that can be done to the
	 * chaining hash table.
	 */
	public static void startMenu() {
		String choice = null;
		while (choice != "q" || choice != "Q") {
			System.out.println();
			System.out.println("************ Menu Of Availiable Options ************");
			System.out.println("1. Show sorted list Processes from chaining hash table.");
			System.out.println("2. Search for a Process ID from the chaining hash table based on it's priority.");
			System.out.println("3. Insert a random process into the chaining hash table.");
			System.out.println("Q. Quit.\n");
			
			System.out.print("Please type in an option and press enter: ");
		    Scanner scan = new Scanner(System.in);
	    	Scanner scanPriority = new Scanner(System.in);
		    choice = scan.nextLine();
		    System.out.println();
		    switch(choice) {
			    case "1": 
					hashTable.printHashTable();
			    	break;
			    case "2": 
			    	boolean validInput = false;
			    	while (!validInput) {
				    	int priorityInput;
				    	System.out.println("Here is a list of all the processes currently running: ");
						hashTable.printHashTable();
				    	System.out.print("\nPlease enter the priority of the process you want to delete: ");
				    	while (!scanPriority.hasNextInt()) {
				    		scanPriority.next();
				    	}
				    	priorityInput = scanPriority.nextInt();
				    	Process found = hashTable.searchProcessByPriority(priorityInput);
						
						
						if (found == null) {
							System.out.println("Cannot find a process with priority " + priorityInput + "... Please try again...");
							validInput = false;
						}
						else {
							validInput = true;
							System.out.println("\nThe Process's Name with this priority is: " + found.getPID());
						}
			    	}
			    	break;
			    case "3": 
					Process newProcess = new Process(currentPID); 
			    	currentPID++;
					System.out.println("This process will be inserted: ");
					printProcess(newProcess);
					hashTable.hashInsert(newProcess);
					hashTable.printHashTable();
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
