
public class RB implements ArbolBinario{
    static final boolean BLACK = true;
    static final boolean RED   = false;

    private static RBNode current;
    private static RBNode parent;
    private static RBNode grand;
    private static RBNode great;
    private RBNode root;
    
    private static RBNode nullNode;
        static{
            nullNode = new RBNode();
            nullNode.left = nullNode.right = nullNode;
        }
	
    public RB(){ // negativo menor que todo el resto
        root      = new RBNode( Integer.MIN_VALUE ); 
        root.left = root.right = nullNode;
    }
	
    public void insertar( int val ){
        current = parent = grand = root;
        nullNode.value = val;
        while( comparar( current.value, val ) != 0 )
        {
        	great = grand; grand = parent; parent = current;
        	current = comparar( val, current.value ) < 0 ?
        			current.left : current.right;
        	// Check if two red children; fix if so
        	if( current.left.color == RED && current.right.color == RED )
        		handleReorient( val );
        }
        // Insertion fails if already present
        if( current != nullNode )
            return;
        current = new RBNode( val, nullNode, nullNode );
        // Attach to parent
        if( comparar( val, parent.value) < 0 )
            parent.left = current;
        else
            parent.right = current;
        handleReorient( val );
        }

        private void handleReorient( int item ){
            current.color = RED;
            current.left.color = BLACK;
            current.right.color = BLACK;
            if( parent.color == RED ){
                grand.color = RED;
                if( ( comparar( item, grand.value ) < 0 ) !=
                    ( comparar(item, parent.value ) < 0 ) )
                    parent = rotate( item, grand );
                current = rotate( item, great );
                current.color = BLACK;
            }
            root.right.color = BLACK; // Make root black
        }
	
    private RBNode rotate( int item, RBNode parent )
    	{
        if( comparar( item, parent.value ) < 0 )
            return parent.left = comparar( item, parent.left.value ) < 0 ?
                rotateWithLeftChild( parent.left )  :  // LL
                rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = comparar( item, parent.right.value ) < 0 ?
                rotateWithLeftChild( parent.right ) :  // RL
                rotateWithRightChild( parent.right );  // RR
    }
        
    private static RBNode rotateWithLeftChild( RBNode node2 ){
        RBNode node1 = node2.left;
        node2.left = node1.right;
        node1.right = node2;
        return node1;
    }
        
    private static RBNode rotateWithRightChild( RBNode node1 ){
        RBNode node2 = node1.right;
        node1.right = node2.left;
        node2.left = node1;
        return node2;
    }
        
	private int comparar(int a, int b) {
		if(a > b) return 1;
		else if (a < b) return -1;
		else return 0;
	}
	
	public boolean buscar(int x){
        nullNode.value = x;
        current = root.right;
        while(true){
            if( comparar( x, current.value ) < 0 )
                current = current.left;
            else if( comparar( x, current.value ) > 0 ) 
                current = current.right;
            else if( current != nullNode )
                return true;
            else
                return false;
        }
	}

	public int altura(){
		if(root == null) return 0;
		else return altura( root );
	}

	private int altura(RBNode node) {
		if (node == null) return 0;
		else return Math.max(altura(node.left), altura(node.right))+1;
	}
	
}
