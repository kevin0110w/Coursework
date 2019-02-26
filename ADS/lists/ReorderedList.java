package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReorderedList {
	
	/**
	 * Reorder a list of people that is already sorted by name so that minors come before people older than 18 but keep
	 * ordering by alphabet
	 * @param people - a list of people ordered alphabetically 
	 * @return people - a list with minors first following by older people whilst maintaining alphabetical sorting
	 */
	public static List<Person> reorder(List<Person> people) {
		Iterator<Person> iterator = people.iterator();
		List<Person> young = new ArrayList<>();
		List<Person> old = new ArrayList<>();
		while (iterator.hasNext()) {
			Person x = iterator.next();
			if (x.getAge() < 18) {
				young.add(x);
			} else {
				old.add(x);
			}
		}
		young.addAll(old);
		return young;
	}
	
	
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Bill", 20));
		list.add(new Person("Julie", 10));
		list.add(new Person("Ted", 84));
		list.add(new Person("Zulu", 2));
		System.out.println(list);
		list = reorder(list);
		for (Person person : list) {
			System.out.println(person);
		}
	}
	
	public static class Person {
		public String name;
		public int age;
		
		public  Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		protected String getName() {
			return name;
		}

		protected void setName(String name) {
			this.name = name;
		}

		protected int getAge() {
			return age;
		}

		protected void setAge(int age) {
			this.age = age;
		}
		
		public String toString() {
			return this.name + ": " + this.age;
		}
	}

}
