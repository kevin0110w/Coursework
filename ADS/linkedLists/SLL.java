package linkedLists;

public class SLL {
	private SLLNode first;

	public SLL() {
		this.first = null;
	}
	
	/**
	 * This method traverses a SLL from its first to last node
	 */
	public void printFirstToLast() {
		for (SLLNode curr = first; curr != null; curr = curr.succ) {
			System.out.println(curr.element + " ");
		}
	}
	
	public void insert(Object elem, SLLNode pred) {
		SLLNode ins = new SLLNode(elem, null);
		if (pred == null) {
			ins.succ = first;
			first = ins;
		} else {
			ins.succ = pred.succ;
			pred.succ = ins;
		}
	}

	public static void main(String[] args) {
		SLLNode c = new SLLNode("cat", null); //create a new node which has element "cat" and does not have a successor
		SLL zoo1 = new SLL(); // create an instance of a SLL
		zoo1.first = new SLLNode("ant", new SLLNode("bat", c));
		zoo1.printFirstToLast();
		System.out.println("--------");
//		zoo1.insert("tiger", null);
		zoo1.insert("tiger", zoo1.first.succ);
//		zoo1.first = zoo1.first.succ;
//		SLLNode second = zoo1.first.succ;
//		zoo1.first.succ = second.succ;
		zoo1.printFirstToLast();
//		SLL zoo2 = new SLL();
//		SLLNode d = new SLLNode(null, null);
//		zoo2.first = d;
//		zoo2.printFirstToLast();
	}
	}

