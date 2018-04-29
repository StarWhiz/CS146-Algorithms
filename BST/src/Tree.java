
public class Tree {
    Node root = null;
 
    Tree() { 
       
    }
    
    public void processInsert(Process p) {
    	Node z = new Node(p);
    	treeInsert(this, z);
    }
    
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
    		
    		if(y.getParent().compareTo(z) == -1 || y.getParent().compareTo(z) == 1) { //y.p != z
    			transplant(t, y, y.getRightChild());
    			y.setRightChild(z.getRightChild());
    			y.getRightChild().setParent(y);
    		}
    		transplant(t, z, y);
    		y.setLeftChild(z.getLeftChild());
    		y.getLeftChild().setParent(y);
    	}
    	
    }
    
    public void inOrderTreeWalk(Node x) {
    	if (x != null) {
    		inOrderTreeWalk(x.getLeftChild());
    		System.out.println("Process: " + x.getKey().getPID() + "\t" + "Priority: " + x.getKey().getPriority());
    		inOrderTreeWalk(x.getRightChild());
    	}
    }
    
    
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
