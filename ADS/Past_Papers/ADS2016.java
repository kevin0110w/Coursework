import java.util.*;

public class ADS2016 {
  public static void main(String[] args) {

    // v)
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.remove(i));

    // vi)
    Set<A> set = new HashSet<A>();
    set.add(new A());
    set.add(new A());
    set.add(new A());
    set.add(new A());
    System.out.println(set);

    // ix)
    Map<String, String> map = new HashMap<String, String>();
      map.put("123", "John Smith");
      map.put("111", "Ella Smith");
      map.put("123", "Steve Price");
      map.put("222", "Steve Price");
      System.out.println(map);
  }
  static class A  {
    int r = 1;
    public String toString() {
        return r + "";
    }
    public int hashCode() {
        return r;
    }
  }
}
