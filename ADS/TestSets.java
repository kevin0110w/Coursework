import java.util.Set;
import java.util.TreeSet;

public class TestSets {

public static <E> void displaySet(Set<E> theSet){
 for(E e: theSet) {
   System.out.print(e + " ");
 }
}

public static void main(String[] args) {
 Pair<String,Integer> p1 = new Pair<String,Integer>("Alec",1);
 Pair<String,Integer> p3 = new Pair<String,Integer>("Cath",2);
 Pair<String,Integer> p2 = new Pair<String,Integer>("Blair",1);

 Set<Pair<String,Integer>> newSet = new TreeSet<Pair<String,Integer>>();
 newSet.add(p1);
 newSet.add(p2);
 newSet.add(p3);
 displaySet(newSet);
}

static class Pair<X,Y> implements Comparable<Pair<String, Integer>> {
 X firstElement;
 Y secondElement;

 public Pair(X x, Y y){
  firstElement=x;
  secondElement=y;
 }

 public String toString(){
  return "(" + firstElement.toString() + "," +
      secondElement.toString() + "), ";
 }
 @Override
 public int compareTo(Pair<String, Integer> that) {
   return 0;
 }
}
}
