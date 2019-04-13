import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/*
 * Some code from the ADS Sample Paper 2018
 */
public class ADS2018 {

	public static void main(String[] args) {
//	    List<String> list = new ArrayList<>();
//	    list.add("A");
//	    list.add("B");
//	    list.add("C");
//	    list.add("D");
//	    for (int i = 0; i < list.size(); i++) {
//	      System.out.print(list.remove(i));
//	    }


//		Set<A> set = new HashSet<A>();
//		set.add(new A());
//		set.add(new A());
//		set.add(new A());
//		set.add(new A());
//		System.out.println(set);
//	}
//
//	public static class A {
//		int r = 1;
//		public String toString() {
//			return r + "";
//		}
//
//		public int hashCode() {
//			return r;
//		}
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("123", "John Smith");
//		map.put("111", "Ella Smith");
//		map.put("123", "Steve Price");
//		map.put("222", "Steve Price");
//		System.out.println(map);

//	    ArrayList<Integer> list = new ArrayList<>();
//	    list.add(1);
//	    list.add(2);
//	    list.add(3);
//	    list.add(4);
//	    list.remove(2);
//	    System.out.println(list);

//		HashSet<String> set1 = new HashSet<String>();
//		set1.add("bubblegum");
//		set1.add("starburst");
//		HashSet<String> set2 = (HashSet<String>) (set1.clone());
//		System.out.println(set1);
//		System.out.println(set2);
//		set1.add("smarties");
//		set2.add("dolly mixture");
//		set1.remove("bubblegum");
//		set1.add("smarties");
//		System.out.println(set2);
//		System.out.println(set1);

		// Map<Integer, String> map1 = new HashMap<Integer, String>();
		//  map1.put(1, "CS1");
		//  map1.put(5, "CS2");
		//  map1.put(11, "DSA");
		//
		//  Map<Integer, String> map2 = new HashMap<Integer, String>();
 		//  map2.put(2, "HCI");
 		//  map2.put(4, "CP");
 		//  map2.put(5, "CS1");
 		//  map2.put(10, "OS");
 		//  map2.put(11, "TCS");
		//
		//  // map1.putAll(map2);
		//  // System.out.println(map1);
		//
		//  map2 = map1;
		//  map1.remove(1, "CS1");
		//  String s = map2.get(7);
		//  System.out.println(map2 + " " + s);
		List<Integer> list3 = new LinkedList<>();
		list3.add(2);
		list3.add(2);
		list3.add(1);
		list3.add(4);
		list3.add(3);
		list3.remove(3);
		System.out.println(list3);

		List<String> list4 = new ArrayList<>();
		list4.add("bob");
		list4.add("duncan");
		list4.add("bob");
		list4.remove("bob");
		System.out.println(list4);
	}
}
