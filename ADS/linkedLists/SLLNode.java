package linkedLists;

public class SLLNode {
	protected Object element;
	protected SLLNode succ;
	
	protected SLLNode(Object elem, SLLNode succ) {
		this.element = elem;
		this.succ = succ;
	}
}
