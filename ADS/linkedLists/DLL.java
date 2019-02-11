package linkedLists;

public class DLL {
	private DLLNode first, last;
	
	public DLL() {
		this.first = null;
		this.last = null;
	}
	
	public void printLastToFirst() {
		for(DLLNode curr = last; curr != null; curr = curr.pred ) {
			System.out.println(curr.elem + " ");
		}
	}
	
	public static void main(String[] args){ 
		DLLNode a = new DLLNode("ant", null, null);
		DLLNode b = new DLLNode("bat", null, null);
		DLL zoo3 = new DLL();
		zoo3.first = a;
		zoo3.last = b;
		zoo3.printLastToFirst();
	}
}
