package lists;

public class LinkedList<E> implements List<E> {
	private Node<E> first, last;
	private int size;

	private static class Node<E> {

		public Node(E it, Object object) {
			// TODO Auto-generated constructor stub
		}
		public E element;
		public Node<E> next;
		
	}
	public LinkedList() {
		first  = last = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public E get(int p) {
		try {
			if (p < 0 || p >= size) {
				throw new Exception();
			}
		}catch (Exception e) {
		}
		return locate(p).element;
	}

	public Node<E> locate(int p) {
		// TODO Auto-generated method stub
		Node<E> curr = first;
		for (int j = 0; j<p;j++) {
			curr = curr.next;
		}
		return curr;
	}
	
	public void add(int p, E it) {
		try {
			if (p < 0 || p > size) {
				throw new Exception();
			}
		} catch (Exception e) {
			
		} 
		Node<E> newest = new Node<E>(it, null);
		if (p == 0) {
			newest.next = first;
			first = newest;
		} else {
			Node<E> pred = locate(p-1);
			newest.next = pred.next;
			pred.next = newest;
		}
		if (newest.next == null) {
			last = newest;
			size++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
