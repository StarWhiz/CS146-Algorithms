
public class RBTree {
    Node root = null;
    
    /**
     * Constructor to create a empty RBTree with root = null
     */
    RBTree() { 
    }
    
    /**
     * This function is used to insert a process into the RBTree.
     * It creates a new Node and sets it's key to the process that was passed into it.
     * Then treeInsert is called to insert the Node into the BST.
     * @param Process p
     */
    public void processInsert(Process p) {
    	Node z = new Node(p);
    	treeInsert(this, z);
    }
    
    /**
     * This function inserts a Node into the RBTree.
     * @param RBTree t
     * @param Node z
     */
    public void treeInsert(RBTree t, Node z) {
    	Node y = null; //parent node
    	Node x = t.getRoot(); //current node
    	
    	while (x != null) {
    		y = x;
    		if (z.compareTo(x) == -1) {
    			x = x.getLeftChild();
    		}
    		else {
    			x = x.getRightChild();
    		}
    	}
    	
    	z.setParent(y);
    	
    	if (y == null) {
    		t.setRoot(z);
    	}
    	else if (z.compareTo(y) == -1) {
    		y.setLeftChild(z);
    	}
    	else {
    		y.setRightChild(z);
    	}
    }
    
    /**
     * This function replaces one subtree as a child of its parent with another subtree.
     * Used by treeDelete
     * 
     * @param RBTree t
     * @param Node u
     * @param Node v
     */
    public void transplant(RBTree t, Node u, Node v ) {
    	if (u.getParent() == null) {
    		t.setRoot(v);
    	}
    	else if ( u == u.getParent().getLeftChild()) {
    		u.getParent().setLeftChild(v);
    	}
    	else {
    		u.getParent().setRightChild(v);
    	}
    	if (v != null) {
    		v.setParent(u.getParent());
    	}
    }
    
    /**
     * This function does an iterative RBTree search for a Process
     * based on it's priority
     * 
     * @param x // the node typically the root of the RBTree
     * @param int k // the priority
     * @return Node x //a node that was searched for.
     * 
     * x returns null whenever the key entered in does not exist in the RBTree
     */
    public Node treeSearch (Node x, int k) {
    	while (x != null && k != x.getKey().getPriority()) {
    		if (k < x.key.getPriority()) {
    			if (x.getLeftChild() == null) {
    				return null; // for cases where the key entered into the search does not exist
    			}
    			else {
        			x = x.getLeftChild();
    			}
    		}
    		else {
    			if (x.getRightChild() == null) {
    				return null; // for cases where the key entered into the search does not exist
    			}
    			else {
        			x = x.getRightChild();
    			}
    		}
    	}
    	return x;
    }
    
    /**
     * This function deletes a node in the RBTree.
     * @param RBTree t
     * @param Node z
     */
    public void treeDelete(RBTree t, Node z) {
    	Node y = new Node();
    	
    	if (z.getLeftChild() == null) {
    		transplant(t, z, z.getRightChild());
    	}
    	else if (z.getRightChild() == null) {
    		transplant(t, z, z.getLeftChild());
    	}
    	else {
    		y = treeMinimum(z.getRightChild());
    		if(y.getParent().compareTo(z) != 0) { //y.p != z
    			transplant(t, y, y.getRightChild());
    			y.setRightChild(z.getRightChild());
    			y.getRightChild().setParent(y);
    		}
    		transplant(t, z, y);
    		y.setLeftChild(z.getLeftChild());
    		y.getLeftChild().setParent(y);
    	}
    	
    }
    
    /**
     * This function is a recursive algorithm that prints the key of all the nodes of
     * the RBTree in sorted order.
     * 
     * @param Node x // The root of the RBTree
     */
    public void inOrderTreeWalk(Node x) {
    	if (x != null) {
    		inOrderTreeWalk(x.getLeftChild());
    		System.out.println("Process: " + x.getKey().getPID() + "\t" + "Priority: " + x.getKey().getPriority());
    		inOrderTreeWalk(x.getRightChild());
    	}
    }
    
    /**
     * This function gets the Node with the lowest key.
     * @param x
     * @return Node x
     */
    public Node treeMinimum(Node x) {
    	while (x.left != null) {
    		x = x.getLeftChild();
    	}
    	return x;
    }
    
    /**
     * This function returns the Node of the root of the RBTree
     * 
     * @return Node root
     */
    public Node getRoot() {
    	return root;
    }
    
    /**
     * This function sets the root Node of the RBTree to the Node that was
     * passed to it.
     * 
     * @parem Node n
     */
    public void setRoot(Node n) {
    	root = n;
    }
}
