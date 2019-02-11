package Stacks;

import java.util.NoSuchElementException;

public class ArrayStack implements Stack {
	private Object[] elems;
	private int depth;
	
	public ArrayStack(int maxDepth) {
		elems = new Object[maxDepth];
		depth = 0;
	}
	
	public boolean isEmpty() {
		return depth == 0;
	}
	public Object getLast() {
		if (depth == 0) {
			throw new NoSuchElementException();
		} else {
			return elems[depth-1];
		}
	}
	public void clear() {
		for (int i = 0; i < depth; i++) {
			elems[i] = null;
		}
		depth = 0;
	}
	
	public void addLast(Object elem) {
		if (depth == elems.length) {
			expand();
		} 
		elems[depth++] = elems;
	}
	
	public Object removeLast() {
		if (depth ==0 ) {
			throw new NoSuchElementException();
		} else {
			Object topElem = elems[depth -1];
			elems[depth] = null;
			return topElem;
		}
	}
	
	public int getDepth() {
		return this.elems.length;
	}
	
	private void expand() {
		Object[] newElems = new Object[2*elems.length];
		for (int i = 0; i < depth; i++) {
			newElems[i] = elems[i];
		}
		elems = newElems;
	}
	
	public String toString() {
		String s = null;
		for (int i = 0; i < this.getDepth(); i++) {
			s += this.elems[i] + ", ";
		}
		return s;
	}
	
	
	public static void main(String[] args) {
		ArrayStack newStack = new ArrayStack(5);
		for (int i = 0; i < newStack.getDepth(); i++) {
			newStack.addLast("I am the " + i);
		}
		System.out.println(newStack.isEmpty());		
		for (int i = 0; i< newStack.getDepth(); i++) {
			System.out.println(newStack.elems[i]);
		}
	}
}
