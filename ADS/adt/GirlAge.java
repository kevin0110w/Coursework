package adt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GirlAge {

	public static void main(String[] args) {
		Set<Integer> girlAge = new HashSet<>();
		girlAge.add(20);
		girlAge.add(25);
		girlAge.add(13);
		girlAge.add(10);
		
		for (int i = 0; i < girlAge.size(); i++) {
			System.out.println(girlAge);
		}
		System.out.println("-------------------");
		for (Integer age : girlAge) {
			System.out.println(age);
		}
		System.out.println("-------------------");
		Iterator<Integer> iterator = girlAge.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
