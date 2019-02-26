package lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E>{
	private E[] elems;
	private int size;
	
	public ArrayList(int cap) {
		elems = (E[]) new Object[cap];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public E get (int p) {
		try {
			if (p < 0 || p >= size) {
				throw new Exception();
			}
		}	
		catch (Exception e) {
		}
		return elems[p];
	}
	
	public void add (int p, E it) {
		try {
			if (p < 0 || p > size) {
				throw new Exception();
			}
		}catch (Exception e) {
		} if (size == elems.length) {
			for (int j = size; j > p; j--) {
				elems[j] = elems[j-1];
				elems[p] = it;
				size++;
			}
		}
	}
		public boolean contains(Object x) {
			boolean check = false;
			for (int i = 0; i <= size; i++) {
				if (elems[i].equals(x)) {
					check = true;
					break;
				}
			}
			return check;
		}
	
		public int indexOf(Object x) {
			boolean contains = false;
			int index = 0;
			for (int i = 0; i <= size; i++) {
				if (elems[i].equals(x)) {
					index = i;
					contains = true;
					break;
				}
			}
			if (contains) {
				return index;
			} else {
				return -1;
			}
		}
	
	
	public Iterator<E> iterator() {
		return new LRIterator();
	}
	
	private class LRIterator implements Iterator<E>{
		private int position;
		
		private LRIterator() {
			position = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return position < size;
		}

		@Override
		public E next() {
			
				try {
					if (position >= size) {
					throw new Exception();
				} 
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return elems[position++];
			}
		}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	public static void main(String[] args) {
		ArrayList x = new ArrayList(2);
		E p = new E();
		x.add(1, );
	}
	*/
}
 