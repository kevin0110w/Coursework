package linkedLists;

public class DLLNode {
	protected Object elem;
	protected DLLNode pred, succ;
	
	protected DLLNode(Object elem, DLLNode pred, DLLNode succ) {
		this.elem = elem;
		this.pred = pred;
		this.succ = succ;
	}
	
}
