
public class RBNode {
	int value;
	boolean color;
	RBNode right;
	RBNode left;
	
	public RBNode( int x ){
		value = x; left = right = null;
	}
	
	public RBNode( int x, RBNode l, RBNode r){
		value = x; left = l; right = r;
	}
	
	public RBNode(){
		color = true;
	}
}
