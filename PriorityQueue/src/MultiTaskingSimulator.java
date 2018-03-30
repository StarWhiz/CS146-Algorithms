/**
 * Priority Queue Simulation
 * 
 * Due Friday Next Week 11:59 PM. March 30.
 * @author Tai Dao
 *
 */
import java.util.ArrayList;

import java.util.Scanner;

public class MultiTaskingSimulator {
	static int currentPID;
	
	public static void main(String[] args) {
		ArrayList <Process> A = new ArrayList<Process> ();
		for (int i = 0; i < 20 ; i++) {
			currentPID = i;
			A.add(new Process(currentPID)); // add 20 Processes into ArrayList
			//This ArrayList represents the heap.
		}
		Heap.buildMaxHeap(A);
		startMenu(A);
	}
	

	/**
	 * This function prints the PIDs & Priorities of all elements of the
	 * ArrayList <Process> that was passed to it. It only prints up to the 
	 * heapSize of the heap.
	 * 
	 * @param ArrayList<Process>
	 */
	public static void printArrayList(ArrayList<Process> A) {
		System.out.println("Index\tPID\tPriority");
		
		for (int i = 0; i < Heap.getHeapSize() + 1; i++) {
			System.out.print(i + "\t");
			System.out.print(A.get(i).getPID() + "\t");
			System.out.println(A.get(i).getPriority());
		}
		System.out.println();
	}
	
	
	/**
	 * This function prints the PID & Priority of an element by taking an
	 * index and ArrayList <Process> that was passed to it.
	 * 
	 * @param int i; // index
	 * @param ArrayList<Process>
	 */
	public static void printProcess(Process p) {
		System.out.println("PID\tPriority");
		System.out.print(p.getPID());
		System.out.println("\t" + p.getPriority());
	}
	
	
	/**
	 * This function displays a menu with operations that can be done to an 
	 * ArrayList of Processes.
	 * @param ArrayList<Process> A
	 */
	public static void startMenu(ArrayList<Process> A) {
		String choice = null;
		while (choice != "q" || choice != "Q") {
			System.out.println("************ Menu Of Availiable Options ************");
			System.out.println("1. Show current ArrayList of Processes. (PriorityQueue)");
			System.out.println("2. View and remove the highest priority process from the PriorityQueue.");
			System.out.println("3. Increase priority of a specified process which changes it's position in the PriorityQueue.");
			System.out.println("4. Insert a new process with a random priority index into the PriorityQueue.");
			System.out.println("5. Sort Processes by priority and displays list of Processes (HeapSort)");
			System.out.println("Q. Quit.\n");
			
			System.out.print("Please type in an option and press enter: ");
		    Scanner scan = new Scanner(System.in);
		    choice = scan.nextLine();
		    System.out.println();
		    switch(choice) {
			    case "1": 
			    	printArrayList(A);
					System.out.println();
			    	break;
			    case "2": 
			    	Boolean repeat = true;
			    	System.out.println("The highest priority process is: ");
			    	Process highestPriorityProcess = Heap.heapMaximum(A);
			    	printProcess(highestPriorityProcess);
			    	System.out.println();
			    	
			    	while (repeat) {
				    	System.out.println("Do you want to remove this process? Type Y/N and press Enter: ");
				    	String ynChoice;

				    	ynChoice = scan.nextLine();
				    	switch(ynChoice) {
				    		case "Y":
				    		case "y":
				    			Heap.heapExtractMax(A);
						    	System.out.println("Highest priority process was removed from PQ.\n");
						    	printArrayList(A);
						    	repeat = false;
						    	break;
				    		case "N":
				    		case "n":
						    	System.out.println("Process removal canceled...\n");	   
						    	repeat = false;
						    	break;
						    default: 
						    	System.out.println("Invalid input. Please try again.");
					    		repeat = true;	
				    	}		
			    	}
			    	break;
			    case "3": 
			    	printArrayList(A);
					System.out.println("Enter in index of process priority you want to increase: ");
			    	int processChoice;
			    	while(scan.hasNextInt()) {
			    		processChoice = scan.nextInt();
				    	if (processChoice > 0 && processChoice < A.size()) {
				    		System.out.println("Current Process Chosen is: ");
				    		printProcess(A.get(processChoice));
				    		System.out.println();
				    		
				    		A.get(processChoice).increasePriority();
				    		Heap.heapIncreaseKey(A, processChoice, A.get(processChoice));
				    		
				    		printArrayList(A);
				    		break;
				    		
				    	}
				    	else {
				    		System.out.println("Invalid choice. Choice out of range.");
				    		System.out.println("Enter in index of process priority you want to increase: ");
				    	}
			    	}
			    	break;
			    case "4": 
			    	currentPID++;
			    	Process newProcess = new Process(currentPID);
			    	
					System.out.println("This new process will be inserted: ");
					printProcess(newProcess);
					System.out.println();
					
					Heap.maxHeapInsert(A, newProcess);					
					printArrayList(A);
					System.out.println();
			    	break;
			    case "5":
			    	ArrayList <Process> newA = new ArrayList <Process> (A);
			    	Heap.heapSort(newA);
					printArrayList(newA);
					System.out.println();
					break;
			    case "Q": 
			    case "q": 
			    	scan.close();
			    	System.out.println("Exiting... Thank you and have a nice day!");
			    	System.exit(1);
			    	break;
			    default:
			    	System.out.println("Invalid Choice. Please try again.\n");
		    }
		}	
	}
}

