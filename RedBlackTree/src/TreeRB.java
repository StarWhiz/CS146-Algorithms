
public class TreeRB {
    Node nil = new Node(); // sentinel nil
    Node root = nil;
    
    /**
     * Constructor to create a empty TreeRB with root = nil
     */
    TreeRB() { 
    	root.setLeftChild(nil);
    	root.setRightChild(nil);
    	root.setParent(nil);
    }
    
    /**
     * This function is used to insert a process into the TreeRB.
     * It creates a new Node and sets it's key to the process that was passed into it.
     * Then rbInsert is called to insert the Node into the BST.
     * @param Process p
     */
    public void processInsert(Process p) {
    	Node z = new Node(p);
    	z.setParent(nil);
    	z.setLeftChild(nil);
    	z.setRightChild(nil);
    	rbInsert(this, z);
    }
    
    /**
     * This function inserts a Node into the TreeRB.
     * @param TreeRB t
     * @param Node z
     */
    public void rbInsert(TreeRB t, Node z) {
    	Node y = t.getNil(); //parent node
    	Node x = t.getRoot(); //current node
    	
    	while (x != t.getNil()) {
    		y = x;
    		if (z.compareTo(x) == -1) {
    			x = x.getLeftChild();
    		}
    		else {
    			x = x.getRightChild();
    		}
    	}
    	z.setParent(y);
    	
    	if (y == t.getNil()) {
    		t.setRoot(z);
    	}
    	else if (z.compareTo(y) == -1) {
    		y.setLeftChild(z);
    	}
    	else {
    		y.setRightChild(z);
    	}
    	z.setLeftChild(t.getNil());
    	z.setRightChild(t.getNil());
    	z.setColor("RED");
    	rbInsertFixUp(t, z);
    }
    
    /**
     * This function is used to fix any violations of the RBTree caused by treeInsert.
     */
    public void rbInsertFixUp(TreeRB t, Node z) {
    	Node y = new Node(); //pointer #2
	    	while (z.getParent().getColor() == "RED") {
	    		if (z.getParent() == z.getParent().getParent().getLeftChild()) { // if z's parent is a left child
	    			y = z.getParent().getParent().getRightChild(); // y = z's uncle...
	    			// Case 1: Z's uncle is red... Re-COLOR
	    			if (y.getColor() == "RED") { 
	    				z.getParent().setColor("BLACK");
	    				y.setColor("BLACK"); // Both brothers and sisters are now black (z's uncle and parent)
	    				z.getParent().getParent().setColor("RED"); //Grandpa is now red instead of black
	    				z = z.getParent().getParent(); // move pointer z up the tree
	    			} // otherwise if Z's uncle was black to begin with skip... lines 71-73
	    			
	    			// Case 2: if z is the right child. LEFT then RIGHT rotation...
	    			else if (z == z.getParent().getRightChild()) { 
	    				z = z.getParent();
	    				leftRotate(t, z);
	    			}
	    			// Case 3: if z is the left child. RIGHT rotation only...
					z.getParent().setColor("BLACK"); //Case 3
					z.getParent().getParent().setColor("RED");
					rightRotate(t, z.getParent().getParent());
	    		}
	    		else { // if z's parent is a right child
	    			y = z.getParent().getParent().getLeftChild(); // y = z's uncle...
	    			// Case 1: Z's uncle is red... Re-COLOR
	    			if (y.getColor() == "RED") { 
	    				z.getParent().setColor("BLACK");
	    				y.setColor("BLACK");
	    				z.getParent().getParent().setColor("RED"); 
	    				z = z.getParent().getParent();
	    			}
	    			 // Case 2: if z is the left child. RIGHT then LEFT rotation...
	    			else if (z == z.getParent().getLeftChild()) {
	    				z = z.getParent();
	    				rightRotate(t,z);
	    			}
	    			// Case 3: if z is the right child. LEFT rotation only...
					z.getParent().setColor("BLACK"); //Case 3
					z.getParent().getParent().setColor("RED");
					leftRotate(t, z.getParent().getParent());
	    		}
	    	}
    	t.getRoot().setColor("BLACK");
    }
    
    /**
     * This function replaces one subtree as a child of its parent with another subtree.
     * Used by rbDelete
     * 
     * @param TreeRB t
     * @param Node u
     * @param Node v
     */
    public void rbTransplant(TreeRB t, Node u, Node v ) {
    	if (u.getParent() == t.getNil()) {
    		t.setRoot(v);
    	}
    	else if ( u == u.getParent().getLeftChild()) {
    		u.getParent().setLeftChild(v);
    	}
    	else {
    		u.getParent().setRightChild(v);
    	}
    	v.setParent(u.getParent());
    }
    
    /**
     * This function does a left rotation
     * TODO: Describe
     */
    public void leftRotate(TreeRB t, Node x) {
    	Node y = x.getRightChild();
    	x.setRightChild(y.getLeftChild());
    	if (y.getLeftChild() != t.getNil()) {
    		y.getLeftChild().setParent(x);
    	}
    	y.setParent(x.getParent());
    	if (x.getParent() == t.getNil()) {
    		t.setRoot(y);
    	}
    	else if (x == x.getParent().getLeftChild()){
    		x.getParent().setLeftChild(y);
    	}
    	else {
    		x.getParent().setRightChild(y);
    	}
    	y.setLeftChild(x);
    	x.setParent(y);
    }
    
    /**
     * This function does a right rotation
     * TODO: Describe
     */
    public void rightRotate(TreeRB t, Node x) {
    	Node y = x.getLeftChild();
    	x.setLeftChild(y.getRightChild());
    	if (y.getRightChild() != t.getNil()) {
    		y.getRightChild().setParent(x);
    	}
    	y.setParent(x.getParent());
    	if (x.getParent() == t.getNil()) {
    		t.setRoot(y);
    	}
    	else if (x == x.getParent().getRightChild()){
    		x.getParent().setRightChild(y);
    	}
    	else {
    		x.getParent().setLeftChild(y);
    	}
    	y.setRightChild(x);
    	x.setParent(y);
    }
    
    /**
     * This function does an iterative TreeRB search for a Process
     * based on it's priority
     * 
     * @param x // the node typically the root of the TreeRB
     * @param int k // the priority
     * @return Node x //a node that was searched for.
     * 
     * x returns nil whenever the key entered in does not exist in the TreeRB
     */
    public Node rbSearch (Node x, int k) {
    	while (x != this.getNil() && k != x.getKey().getPriority()) {
    		if (k < x.key.getPriority()) {
    			if (x.getLeftChild() == this.getNil()) {
    				return this.getNil(); // for cases where the key entered into the search does not exist
    			}
    			else {
        			x = x.getLeftChild();
    			}
    		}
    		else {
    			if (x.getRightChild() == this.getNil()) {
    				return this.getNil(); // for cases where the key entered into the search does not exist
    			}
    			else {
        			x = x.getRightChild();
    			}
    		}
    	}
    	return x;
    }
    
    /**
     * This function deletes a node in the TreeRB.
     * @param TreeRB t
     * @param Node z
     */
    public void rbDelete(TreeRB t, Node z) {
    	Node y = new Node();
    	
    	if (z.getLeftChild() == t.getNil()) {
    		rbTransplant(t, z, z.getRightChild());
    	}
    	else if (z.getRightChild() == t.getNil()) {
    		rbTransplant(t, z, z.getLeftChild());
    	}
    	else {
    		y = treeMinimum(z.getRightChild());
    		if(y.getParent().compareTo(z) != 0) { //y.p != z
    			rbTransplant(t, y, y.getRightChild());
    			y.setRightChild(z.getRightChild());
    			y.getRightChild().setParent(y);
    		}
    		rbTransplant(t, z, y);
    		y.setLeftChild(z.getLeftChild());
    		y.getLeftChild().setParent(y);
    	}
    	
    }
    
    /**
     * This function is a recursive algorithm that prints the key of all the nodes of
     * the TreeRB in sorted order.
     * 
     * @param Node x // The root of the TreeRB
     */
    public void inOrderTreeWalk(Node x) {
    	if (x != this.getNil()) {
    		inOrderTreeWalk(x.getLeftChild());
    		System.out.println("Process: " + x.getKey().getPID() + "\t" + "Priority: " + x.getKey().getPriority() + "\t" + "Color: " + x.getColor());
    		inOrderTreeWalk(x.getRightChild());
    	}
    }
    
    /**
     * This function gets the Node with the lowest key.
     * @param x
     * @return Node x
     */
    public Node treeMinimum(Node x) {
    	while (x.left != this.getNil()) {
    		x = x.getLeftChild();
    	}
    	return x;
    }
    
    /**
     * This function returns the Node of the root of the TreeRB
     * 
     * @return Node root
     */
    public Node getRoot() {
    	return root;
    }
    
    /**
     * This function returns the Node of the root of the TreeRB
     * 
     * @return Node root
     */
    public Node getNil() {
    	return nil;
    }
    
    /**
     * This function sets the root Node of the TreeRB to the Node that was
     * passed to it.
     * 
     * @parem Node n
     */
    public void setRoot(Node n) {
    	root = n;
    }
}
