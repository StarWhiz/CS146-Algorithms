
public class Tree {
    Node root = null;
    
    /**
     * Constructor to create a empty tree with root = null
     */
    Tree() { 
    }
    
    /**
     * This function is used to insert a process into the tree.
     * It creates a new Node and sets it's key to the process that was passed into it.
     * Then treeInsert is called to insert the Node into the BST.
     * @param Process p
     */
    public void processInsert(Process p) {
    	Node z = new Node(p);
    	treeInsert(this, z);
    }
    
    /**
     * This function inserts a Node into the tree.
     * @param Tree t
     * @param Node z
     */
    public void treeInsert(Tree t, Node z) {
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
     * @param Tree t
     * @param Node u
     * @param Node v
     */
    public void transplant(Tree t, Node u, Node v ) {
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
    
    //TODO
    public Node treeSearch (Node x, int k) {
    	if (x == null || k == x.getKey().getPriority()) {
    		return x;
    	}
    	if (k < x.getKey().getPriority()) {
    		return treeSearch(x.getLeftChild(), k);	
    	}
    	else {
    		return treeSearch(x.getRightChild(), k);
    	}
    }
    
    /**
     * This function deletes a node in the tree.
     * @param Tree t
     * @param Node z
     */
    public void treeDelete(Tree t, Node z) {
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
     * the tree in sorted order.
     * 
     * @param Node x // The root of the tree
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
     * @return
     */
    public Node treeMinimum(Node x) {
    	while (x.left != null) {
    		x = x.getLeftChild();
    	}
    	return x;
    }
    
    public Node treeMaximum (Node x) {
    	while (x.right != null) {
    		x = x.getRightChild();
    	}
    	return x;
    }
    
    public Node getRoot() {
    	return root;
    }
    public void setRoot(Node n) {
    	root = n;
    }
}