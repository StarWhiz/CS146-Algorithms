
public class Node {
	Process process;
	Node next;
	Node prev;
	
	Node(Process p) {
		process = p;
		next = null;
		prev = null;
	}
	
	public void addProcess(Process p) {
		Node newNode = new Node(p);
		next = newNode;
	}

	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
