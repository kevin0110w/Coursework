package map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap implements Map {
	private ArrayMap.Entry[] entries;
	private int card;
	
	public ArrayMap(int maxCard) {
		// TODO Auto-generated constructor stub
		// Construct a map that is initially empty, whose cardinality is bounded by maxCard.
		this.entries = new ArrayMap.Entry[maxCard];
		this.card = 0;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object key) {
		ArrayMap.Entry[] newEntries = new ArrayMap.Entry[this.card];
		if (key instanceof Comparable) {
			int pos = search))
		}
		return newEntries;
		
	}

	@Override
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Entry {
		private Comparable key;
		private Object value;
	}
	
	public Entry() {
		
	}
}
