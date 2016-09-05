
public class AVL implements ArbolBinario {
	private AvlNode root;

	public AVL() {
		root = null;
	}
	
	public void insertar(int x ){
		root = insertar(x, root );
	}
	
	public boolean buscar(int x){
		return isThere(x,root);
	}
	
	private boolean isThere(int x, AvlNode node) {
		if( isEmpty() ) return false;   // caso base
		while(node != null){
			if( comparar( x, node.value ) < 0)
				node = node.izq;
			else if( comparar( x, node.value) >0 )
				node = node.der;
			else return true;   // encontrado
		} 
		return false;   // no lo encontró
	}
	
	private AvlNode insertar(int val, AvlNode node) {
		if ( node==null ) node = new AvlNode(val);
		else if( comparar( val, node.value ) < 0 ){
			node.izq = insertar( val, node.izq );
			if( height( node.izq ) - height( node.der ) == 2 ){
				if( comparar( val, node.izq.value ) < 0 )
					node = rotateWithLeftChild( node );
				else 
					node = doubleWithLeftChild( node );
			}
		}
		else if( comparar( val, node.value ) > 0 ){
			node.der = insertar( val, node.der );
            if( height( node.der ) - height( node.izq ) == 2 )
                if( comparar( val, node.der.value ) > 0 )
                    node = rotateWithRightChild( node );
                else 
                    node = doubleWithRightChild( node );
		}
		node.height = max( height( node.izq ), height( node.der ) ) + 1;
		return node;
	}

	private AvlNode rotateWithLeftChild(AvlNode node2) {
		AvlNode node1 = node2.izq;
		node2.izq = node1.der;
		node1.der = node2;
		node2.height = max( height( node2.izq ), height( node2.der ) ) + 1;
		node1.height = max( height( node1.izq ) , node2.height ) + 1;
		return node1;
	}

	private AvlNode doubleWithLeftChild(AvlNode node3) {
        node3.izq = rotateWithRightChild( node3.izq );
        return rotateWithLeftChild( node3 );
	}

	private AvlNode rotateWithRightChild(AvlNode node1) {
        AvlNode node2 = node1.der;
        node1.der = node2.izq;
        node2.izq = node1;
        node1.height = max( height( node1.izq ), height( node1.der ) ) + 1;
        node2.height = max( height( node2.der ), node1.height ) + 1;
        return node2;
	}

	private AvlNode doubleWithRightChild(AvlNode node1) {
        node1.der = rotateWithLeftChild( node1.der );
        return rotateWithRightChild( node1 );
	}

	private int height(AvlNode node) {
		return node == null? -1 : node.height;
	}

	private int comparar(int x, int v ) {
		if( x == v ) return 0;
		else if ( x < v ) return -1;
		else return 1;
	}
	
	private int max(int a, int b){
		if( a >= b ) return a;
		else return b;
	}

	public boolean isEmpty(){
		return root == null ;
	}

}
