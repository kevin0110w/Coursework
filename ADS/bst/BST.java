package bst;

public class BST <E extends Comparable<E>>{
	private Node<E> root;

	public BST() {
		root = null;
	}

	public static class Node<E extends Comparable<E>> {
		protected E element;
		protected Node<E> left, right;

		protected Node(E elem) {
			element = elem;
			left = null;
			right = null;
		}
		

		public Node<E> deleteTopmost() {
			if (this.left == null) {
				return this.right;
			} else if (this.right == null) {
				return this.left;
			} else { // this node has two subtrees
				this.element = this.right.getLeftmost();
				this.right = this.right.deleteLeftmost();
				return this;
			}
		}
	

		private E getLeftmost() {
			Node<E> curr = this;
			while (curr.left != null) {
				curr = curr.left;
			}
			return curr.element;
		}

		private Node<E> deleteLeftmost() {
			if (this.left == null) {
				return this.right;
			} else {
				Node<E> parent = this;
				Node<E> curr = this.left;
				while (curr.left != null) {
					parent = curr;
					curr = curr.left;
				}
				parent.left = curr.right;
				return this;
			}
		}

		/*
		 * Search method for a binary search tree object
		 * O(logn) for well balanced tree, O(n) for ill-balanced
		 */
		public Node<E> search(E target) {
			int direction = 0;
			Node<E> curr = root;
			while (true) {
				if (curr == null) {
					return null;
				} 
				direction = target.compareTo(curr.element);
				if (direction == 0) {
					return curr;
				} else if (direction < 0) {
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}
		}

		public void insert(E elem) {
			int direction = 0;
			Node<E> parent = null;
			Node<E> curr = root;
			while (true) {
				if (curr == null) {
					Node<E> ins = new Node<E> (elem); // newly created leaf node with element elem
					if (root == null) { 
						root = ins;
					} else if (direction < 0) {
						parent.left = ins;
					} else {
						parent.right = ins;
					}
					return;
				}
				direction = elem.compareTo(curr.element);
				if (direction == 0) { // elem is equal to curr's element
					return;
				}
				parent = curr; 
				if (direction < 0) {
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			} 
		}


		public void delete (E elem) {
			int direction = 0;
			Node<E> parent = null;
			Node<E> curr = root;
			while (true) {
				if (curr == null) {
					return;
				}
				direction = elem.compareTo(curr.element);
				if (direction == 0) {
					Node<E> del = curr.deleteTopmost();
					if (curr == root) {
						root = del;
					} else if (curr == parent.left) {
						parent.left = del;
					} else {
						parent.right = del;
					}
					return;
				}
				parent = curr;
				if (direction < 0) {
					curr = parent.left;
				} else {
					curr = parent.right;
				}
			}
		}
		public static void main(String[] args) {
		}

	}
}
