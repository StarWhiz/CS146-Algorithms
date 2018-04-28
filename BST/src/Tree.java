
public class Tree {
    Node root = null;
 
    Tree() { 
       
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
    	
    	//TODO: set z's parent = to y
    	
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
    
    public Node getRoot() {
    	return root;
    }
    public void setRoot(Node n) {
    	root = n;
    }
}
