
public class AvlNode {
	int value;
	int height = 0;
	AvlNode der;
	AvlNode izq;
	
	public AvlNode(int v) {
		value = v; der = null; izq = null;
	}
	
	public AvlNode(int v, AvlNode a, AvlNode b){
		value = v; izq = a; der = b;
	}
}
