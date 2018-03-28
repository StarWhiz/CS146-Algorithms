
public class Process implements Comparable<Process> {
	private int priority;
	private String processID;
	
	/**
	 * This constructor initializes the priority of the Process when it is created
	 * with a random number from 1 to 9999.
	 */
	Process(int currentPID) {
		//priority = currentPID +1000; // FOR DEBUGGING
		priority = (int) (Math.random()*9999 + 1);
		processID = "P" + currentPID;
	}
	
	
	/**
	 * This function returns the priority of the Process
	 * @return int priority
	 */
	public int getPriority (){
		return priority;
	}
	
	
	/**
	 * This function returns the PID of the Process
	 * @return int priority
	 */
	public String getPID (){
		return processID;
	}
	
	
	/**
	 * This function takes an int and sets priority to it
	 * @param p
	 */
	public void setPriority(int p) {
		priority = p;
	}
	
	
	/**
	 * This funciton increases the priority of the Process by 1
	 */
	public void increasePriority () {
		priority++;
	}
	
	
	/**
	 * This function takes another Process and compares it's priority with the current process.
	 * @param Process
	 */
	@Override
	public int compareTo(Process other) {
		if (priority < other.getPriority()) {
			return -1;
		}
		else if (priority == other.getPriority()) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
