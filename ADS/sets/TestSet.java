package sets;

import java.util.HashSet;
import java.util.Set;

public class TestSet {


	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		set1.add("Billy");
		set1.add("Frantny");
		set1.add("Joe");
		Set<String>set2 = new HashSet<String>();
		set2.add("Billy");
		set2.add("Franny");
		Set<String> set3 = new HashSet<String>();
		set3.add("Joe");
		System.out.println(returnSet(set1, set2, set3));
		System.out.println(set1);
	}
	
	public static Set<String> returnSet(Set<String> set1, Set<String> set2, Set<String> set3) {
		set2.addAll(set3);
		set1.retainAll(set2);
		return set1;
	}
}
