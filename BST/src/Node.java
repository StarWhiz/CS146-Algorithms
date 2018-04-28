

public class Node implements Comparable<Node>{
    Process key;
    Node left, right;
    
    Node(){
    	//key = null;
    	left = null;
    	right = null;
    }

    public Node(Process p) {
        key = null;
        left = right = null;
    }

    
    /**
     * The compareTo method is used to compare Nodes in the binary search
     * tree based on the key process's priority
     */
	@Override
	public int compareTo(Node n) {
		if (key.getPriority() < n.getPriority()) {
			return -1;
		}
		else if (key.getPriority() == n.getPriority()) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public int getPriority() {
		return key.getPriority();
	}
	
	public Node getLeftChild() {
		return left;
	}
	public void setLeftChild(Node n) {
		left = n;
	}
	
	public Node getRightChild() {
		return right;
	}
	public void setRightChild(Node n) {
		right = n;
	}
}

