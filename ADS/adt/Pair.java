package adt;

public interface Pair<E> {
	public E first();
	public E second();
	
	public void updateFirst(E e1);
	public void updateSecond(E e2);

}
