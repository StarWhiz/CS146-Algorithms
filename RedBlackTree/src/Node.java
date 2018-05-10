/**
 * This class is for creating Node objects. All node objects are comparable.
 * 
 * @author Tai Dao
 */

public class Node implements Comparable<Node>{
	Process key;
    Node left;
    Node right;
    Node parent;
    String color = null;
    
    /**
     * Constructor for new empty node. All values initialized to null.
     */
    Node() {
    	key = null;
    	left = null;
    	right = null;
    	parent = null;
    	color = null;
    }

    /**
     * Constructor for when a process is specified. This sets the key equal
     * to the process p that was passed onto the function.
     * 
     * @param Process p
     */
	public Node(Process p) {
        key = p;
    	left = null;
    	right = null;
    	parent = null;
    }

	/**
     * The compareTo method is used to compare Nodes in the binary search
     * tree based on the key process's priority. 
     * 
     * @parem Node n
     * @return -1, 0, or 1
     * 
     * A result of -1 means the current Node is less than the node that was passed to it
     * A result of 0 means the current Node is equal to the node that was passed to it
     * A result of 1 means the current Node is greater than the node that was passed to it
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
	
	/**
	 * This function returns the key of the Node.
	 * @return Process key
	 */
    public Process getKey() {
		return key;
	}

    /**
     * This function sets key to the key that was passed to it
     * @param Process key
     */
	public void setKey(Process key) {
		this.key = key;
	}
	
	/**
	 * This function returns the priority of the key of the Node.
	 * compareTo depends on this function
	 * @return int priority
	 */
	public int getPriority() {
		return key.getPriority();
	}
	
	/**
	 * This function returns Node's left child
	 * @return Node left;
	 */
	public Node getLeftChild() {
		return left;
	}
	
	/**
	 * This function sets Node's left child to the node that was passed to it.
	 * @param Node n;
	 */
	public void setLeftChild(Node n) {
		left = n;
	}
	
	/**
	 * This function returns Node's right child
	 * @return Node right;
	 */
	public Node getRightChild() {
		return right;
	}
	
	/**
	 * This function sets Node's right child to the node that was passed to it.
	 * @param Node n;
	 */
	public void setRightChild(Node n) {
		right = n;
	}
	
	/**
	 * This function returns Node's parent 
	 * @return Node parent;
	 */
    public Node getParent() {
		return parent;
	}

	/**
	 * This function sets Node's parent to the node that was passed to it.
	 * @param Node n;
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * This function returns the color of the Node
	 * @return String color
	 */
    public String getColor() {
		return color;
	}
    
    /**
     * This function sets the color of the node to the color that was passed to it.
     * @param color
     */
	public void setColor(String color) {
		this.color = color;
	}
}

