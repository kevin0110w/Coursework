import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;

public class ADS2017 {
  public static void main(String[] args) {
    // vi)
    // ArrayList<Integer> list = new ArrayList<>();
    // list.add(1);
    // list.add(2);
    // list.add(3);
    // list.add(4);
    // list.remove(2);
    // System.out.println(list);

    //vii)
    // LinkedHashSet<String> set1 = new LinkedHashSet<String>();
    // set1.add("bubblegum");
    // set1.add("starburst");
    // LinkedHashSet<String> set2 = (LinkedHashSet<String>)(set1.clone());
    // set1.add("smarties");
    // set2.add("dolly mixture");
    // set1.remove("bubblegum");
    // System.out.println(set2);

    //ix
    Map<Integer, String> map = new HashMap<Integer, String>();
     map.put(100, "Darth Vader");
     map.put(75, "Kylo Ren");
     map.put(150, "Yoda");
     map.put(200, "Han Solo");
     map.put(150, "R2-D2");
     map.put(150, "Boba Fett");
     System.out.println(map);
  }
}
